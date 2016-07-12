/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.prodevelopment.pesquisaopiniao.service;

import br.com.prodevelopment.pesquisaopiniao.model.PerguntaClp;
import br.com.prodevelopment.pesquisaopiniao.model.PesquisaClp;
import br.com.prodevelopment.pesquisaopiniao.model.Pesquisa_UsuarioClp;
import br.com.prodevelopment.pesquisaopiniao.model.RespostaClp;
import br.com.prodevelopment.pesquisaopiniao.model.Resposta_UsuarioClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"pesquisa-opiniao-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"pesquisa-opiniao-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "pesquisa-opiniao-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(PerguntaClp.class.getName())) {
			return translateInputPergunta(oldModel);
		}

		if (oldModelClassName.equals(PesquisaClp.class.getName())) {
			return translateInputPesquisa(oldModel);
		}

		if (oldModelClassName.equals(Pesquisa_UsuarioClp.class.getName())) {
			return translateInputPesquisa_Usuario(oldModel);
		}

		if (oldModelClassName.equals(RespostaClp.class.getName())) {
			return translateInputResposta(oldModel);
		}

		if (oldModelClassName.equals(Resposta_UsuarioClp.class.getName())) {
			return translateInputResposta_Usuario(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputPergunta(BaseModel<?> oldModel) {
		PerguntaClp oldClpModel = (PerguntaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPerguntaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPesquisa(BaseModel<?> oldModel) {
		PesquisaClp oldClpModel = (PesquisaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPesquisaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPesquisa_Usuario(BaseModel<?> oldModel) {
		Pesquisa_UsuarioClp oldClpModel = (Pesquisa_UsuarioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPesquisa_UsuarioRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputResposta(BaseModel<?> oldModel) {
		RespostaClp oldClpModel = (RespostaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRespostaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputResposta_Usuario(BaseModel<?> oldModel) {
		Resposta_UsuarioClp oldClpModel = (Resposta_UsuarioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getResposta_UsuarioRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"br.com.prodevelopment.pesquisaopiniao.model.impl.PerguntaImpl")) {
			return translateOutputPergunta(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.pesquisaopiniao.model.impl.PesquisaImpl")) {
			return translateOutputPesquisa(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.pesquisaopiniao.model.impl.Pesquisa_UsuarioImpl")) {
			return translateOutputPesquisa_Usuario(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.pesquisaopiniao.model.impl.RespostaImpl")) {
			return translateOutputResposta(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.pesquisaopiniao.model.impl.Resposta_UsuarioImpl")) {
			return translateOutputResposta_Usuario(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"br.com.prodevelopment.pesquisaopiniao.NoSuchPerguntaException")) {
			return new br.com.prodevelopment.pesquisaopiniao.NoSuchPerguntaException();
		}

		if (className.equals(
					"br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException")) {
			return new br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisaException();
		}

		if (className.equals(
					"br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException")) {
			return new br.com.prodevelopment.pesquisaopiniao.NoSuchPesquisa_UsuarioException();
		}

		if (className.equals(
					"br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException")) {
			return new br.com.prodevelopment.pesquisaopiniao.NoSuchRespostaException();
		}

		if (className.equals(
					"br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException")) {
			return new br.com.prodevelopment.pesquisaopiniao.NoSuchResposta_UsuarioException();
		}

		return throwable;
	}

	public static Object translateOutputPergunta(BaseModel<?> oldModel) {
		PerguntaClp newModel = new PerguntaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPerguntaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPesquisa(BaseModel<?> oldModel) {
		PesquisaClp newModel = new PesquisaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPesquisaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPesquisa_Usuario(BaseModel<?> oldModel) {
		Pesquisa_UsuarioClp newModel = new Pesquisa_UsuarioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPesquisa_UsuarioRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputResposta(BaseModel<?> oldModel) {
		RespostaClp newModel = new RespostaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRespostaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputResposta_Usuario(BaseModel<?> oldModel) {
		Resposta_UsuarioClp newModel = new Resposta_UsuarioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setResposta_UsuarioRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}