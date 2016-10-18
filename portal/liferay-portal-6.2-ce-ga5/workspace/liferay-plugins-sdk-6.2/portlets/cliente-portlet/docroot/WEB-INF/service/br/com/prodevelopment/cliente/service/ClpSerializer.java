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

package br.com.prodevelopment.cliente.service;

import br.com.prodevelopment.cliente.model.ClienteClp;
import br.com.prodevelopment.cliente.model.ClienteLimCreditoClp;
import br.com.prodevelopment.cliente.model.ClienteUsuarioClp;

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
						"cliente-portlet-deployment-context");

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
							"cliente-portlet-deployment-context");

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
				_servletContextName = "cliente-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ClienteClp.class.getName())) {
			return translateInputCliente(oldModel);
		}

		if (oldModelClassName.equals(ClienteLimCreditoClp.class.getName())) {
			return translateInputClienteLimCredito(oldModel);
		}

		if (oldModelClassName.equals(ClienteUsuarioClp.class.getName())) {
			return translateInputClienteUsuario(oldModel);
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

	public static Object translateInputCliente(BaseModel<?> oldModel) {
		ClienteClp oldClpModel = (ClienteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getClienteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputClienteLimCredito(BaseModel<?> oldModel) {
		ClienteLimCreditoClp oldClpModel = (ClienteLimCreditoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getClienteLimCreditoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputClienteUsuario(BaseModel<?> oldModel) {
		ClienteUsuarioClp oldClpModel = (ClienteUsuarioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getClienteUsuarioRemoteModel();

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
					"br.com.prodevelopment.cliente.model.impl.ClienteImpl")) {
			return translateOutputCliente(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.cliente.model.impl.ClienteLimCreditoImpl")) {
			return translateOutputClienteLimCredito(oldModel);
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.cliente.model.impl.ClienteUsuarioImpl")) {
			return translateOutputClienteUsuario(oldModel);
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
					"br.com.prodevelopment.cliente.ClienteAlteradoOutroUsuarioException")) {
			return new br.com.prodevelopment.cliente.ClienteAlteradoOutroUsuarioException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteCNPJDuplicadoException")) {
			return new br.com.prodevelopment.cliente.ClienteCNPJDuplicadoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteCNPJInvalidoException")) {
			return new br.com.prodevelopment.cliente.ClienteCNPJInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteCPFDuplicadoException")) {
			return new br.com.prodevelopment.cliente.ClienteCPFDuplicadoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteCPFInvalidoException")) {
			return new br.com.prodevelopment.cliente.ClienteCPFInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteCidadeComTemQueSerNumericaException")) {
			return new br.com.prodevelopment.cliente.ClienteCidadeComTemQueSerNumericaException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteCidadeResTemQueSerNumericaException")) {
			return new br.com.prodevelopment.cliente.ClienteCidadeResTemQueSerNumericaException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteDataLimiteMaxCreditoInvalidaException")) {
			return new br.com.prodevelopment.cliente.ClienteDataLimiteMaxCreditoInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteDataNascimentoInvalidaException")) {
			return new br.com.prodevelopment.cliente.ClienteDataNascimentoInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteEmailInvalidoException")) {
			return new br.com.prodevelopment.cliente.ClienteEmailInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteNomeObrigatorioException")) {
			return new br.com.prodevelopment.cliente.ClienteNomeObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClientePaisComTemQueSerNumericoException")) {
			return new br.com.prodevelopment.cliente.ClientePaisComTemQueSerNumericoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClientePaisResTemQueSerNumericoException")) {
			return new br.com.prodevelopment.cliente.ClientePaisResTemQueSerNumericoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteQtdeLimiteMaxChequeInvalidoException")) {
			return new br.com.prodevelopment.cliente.ClienteQtdeLimiteMaxChequeInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteRGDataEmissaoInvalidaException")) {
			return new br.com.prodevelopment.cliente.ClienteRGDataEmissaoInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteRGInscricaoMunDuplicadoException")) {
			return new br.com.prodevelopment.cliente.ClienteRGInscricaoMunDuplicadoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteUsuarioDuplicadoException")) {
			return new br.com.prodevelopment.cliente.ClienteUsuarioDuplicadoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteValorLimiteMaxChequeInvalidoException")) {
			return new br.com.prodevelopment.cliente.ClienteValorLimiteMaxChequeInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.ClienteValorLimiteMaxCreditoInvalidoException")) {
			return new br.com.prodevelopment.cliente.ClienteValorLimiteMaxCreditoInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.NoSuchClienteException")) {
			return new br.com.prodevelopment.cliente.NoSuchClienteException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException")) {
			return new br.com.prodevelopment.cliente.NoSuchClienteLimCreditoException();
		}

		if (className.equals(
					"br.com.prodevelopment.cliente.NoSuchClienteUsuarioException")) {
			return new br.com.prodevelopment.cliente.NoSuchClienteUsuarioException();
		}

		return throwable;
	}

	public static Object translateOutputCliente(BaseModel<?> oldModel) {
		ClienteClp newModel = new ClienteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setClienteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputClienteLimCredito(BaseModel<?> oldModel) {
		ClienteLimCreditoClp newModel = new ClienteLimCreditoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setClienteLimCreditoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputClienteUsuario(BaseModel<?> oldModel) {
		ClienteUsuarioClp newModel = new ClienteUsuarioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setClienteUsuarioRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}