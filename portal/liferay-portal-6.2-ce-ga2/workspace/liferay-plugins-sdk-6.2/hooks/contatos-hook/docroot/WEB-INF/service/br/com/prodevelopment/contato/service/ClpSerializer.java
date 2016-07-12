/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package br.com.prodevelopment.contato.service;

import br.com.prodevelopment.contato.model.ContatoClp;
import br.com.prodevelopment.contato.model.EnderecoClp;
import br.com.prodevelopment.contato.model.EnderecoEmailClp;
import br.com.prodevelopment.contato.model.TelefoneClp;

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
 * @author marcelo
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
						"contatos-hook-deployment-context");

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
							"contatos-hook-deployment-context");

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
				_servletContextName = "contatos-hook";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ContatoClp.class.getName())) {
			return translateInputContato(oldModel);
		}

		if (oldModelClassName.equals(EnderecoClp.class.getName())) {
			return translateInputEndereco(oldModel);
		}

		if (oldModelClassName.equals(EnderecoEmailClp.class.getName())) {
			return translateInputEnderecoEmail(oldModel);
		}

		if (oldModelClassName.equals(TelefoneClp.class.getName())) {
			return translateInputTelefone(oldModel);
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

	public static Object translateInputContato(BaseModel<?> oldModel) {
		ContatoClp oldClpModel = (ContatoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContatoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEndereco(BaseModel<?> oldModel) {
		EnderecoClp oldClpModel = (EnderecoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEnderecoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEnderecoEmail(BaseModel<?> oldModel) {
		EnderecoEmailClp oldClpModel = (EnderecoEmailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEnderecoEmailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTelefone(BaseModel<?> oldModel) {
		TelefoneClp oldClpModel = (TelefoneClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTelefoneRemoteModel();

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
					"br.com.prodevelopment.contato.model.impl.ContatoImpl")) {
			return translateOutputContato(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.contato.model.impl.EnderecoImpl")) {
			return translateOutputEndereco(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.contato.model.impl.EnderecoEmailImpl")) {
			return translateOutputEnderecoEmail(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.contato.model.impl.TelefoneImpl")) {
			return translateOutputTelefone(oldModel);
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
					"br.com.prodevelopment.contato.ContatoDataNascimentoInvalidaException")) {
			return new br.com.prodevelopment.contato.ContatoDataNascimentoInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.ContatoEmailInvalidoException")) {
			return new br.com.prodevelopment.contato.ContatoEmailInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.EnderecoEmailEnderecoInvalidoException")) {
			return new br.com.prodevelopment.contato.EnderecoEmailEnderecoInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.EnderecoEmailEnderecoObrigatotioException")) {
			return new br.com.prodevelopment.contato.EnderecoEmailEnderecoObrigatotioException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.EnderecoEmailTipoObrigatotioException")) {
			return new br.com.prodevelopment.contato.EnderecoEmailTipoObrigatotioException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.EnderecoLogradouroObrigatotioException")) {
			return new br.com.prodevelopment.contato.EnderecoLogradouroObrigatotioException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.EnderecoTipoObrigatotioException")) {
			return new br.com.prodevelopment.contato.EnderecoTipoObrigatotioException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.TelefoneDDDInvalidoException")) {
			return new br.com.prodevelopment.contato.TelefoneDDDInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.TelefoneDDDObrigatotioException")) {
			return new br.com.prodevelopment.contato.TelefoneDDDObrigatotioException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.TelefoneNumeroInvalidoException")) {
			return new br.com.prodevelopment.contato.TelefoneNumeroInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.TelefoneNumeroObrigatotioException")) {
			return new br.com.prodevelopment.contato.TelefoneNumeroObrigatotioException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.TelefoneTipoObrigatotioException")) {
			return new br.com.prodevelopment.contato.TelefoneTipoObrigatotioException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.NoSuchContatoException")) {
			return new br.com.prodevelopment.contato.NoSuchContatoException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.NoSuchEnderecoException")) {
			return new br.com.prodevelopment.contato.NoSuchEnderecoException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.NoSuchEnderecoEmailException")) {
			return new br.com.prodevelopment.contato.NoSuchEnderecoEmailException();
		}

		if (className.equals(
					"br.com.prodevelopment.contato.NoSuchTelefoneException")) {
			return new br.com.prodevelopment.contato.NoSuchTelefoneException();
		}

		return throwable;
	}

	public static Object translateOutputContato(BaseModel<?> oldModel) {
		ContatoClp newModel = new ContatoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContatoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEndereco(BaseModel<?> oldModel) {
		EnderecoClp newModel = new EnderecoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEnderecoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEnderecoEmail(BaseModel<?> oldModel) {
		EnderecoEmailClp newModel = new EnderecoEmailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEnderecoEmailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTelefone(BaseModel<?> oldModel) {
		TelefoneClp newModel = new TelefoneClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTelefoneRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}