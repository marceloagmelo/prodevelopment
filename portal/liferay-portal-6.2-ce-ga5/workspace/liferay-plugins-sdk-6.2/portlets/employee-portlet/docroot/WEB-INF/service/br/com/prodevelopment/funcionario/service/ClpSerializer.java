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

package br.com.prodevelopment.funcionario.service;

import br.com.prodevelopment.funcionario.model.CargoClp;
import br.com.prodevelopment.funcionario.model.FuncionarioClp;

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
 * @author Marcelo Melo
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
						"employee-portlet-deployment-context");

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
							"employee-portlet-deployment-context");

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
				_servletContextName = "employee-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CargoClp.class.getName())) {
			return translateInputCargo(oldModel);
		}

		if (oldModelClassName.equals(FuncionarioClp.class.getName())) {
			return translateInputFuncionario(oldModel);
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

	public static Object translateInputCargo(BaseModel<?> oldModel) {
		CargoClp oldClpModel = (CargoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCargoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFuncionario(BaseModel<?> oldModel) {
		FuncionarioClp oldClpModel = (FuncionarioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFuncionarioRemoteModel();

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
					"br.com.prodevelopment.funcionario.model.impl.CargoImpl")) {
			return translateOutputCargo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.prodevelopment.funcionario.model.impl.FuncionarioImpl")) {
			return translateOutputFuncionario(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
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
					"br.com.prodevelopment.funcionario.CargoAlteradoOutroUsuarioException")) {
			return new br.com.prodevelopment.funcionario.CargoAlteradoOutroUsuarioException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.CargoNomeObrigatorioException")) {
			return new br.com.prodevelopment.funcionario.CargoNomeObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FotoFuncionarioTamanhoException")) {
			return new br.com.prodevelopment.funcionario.FotoFuncionarioTamanhoException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioAlteradoOutroUsuarioException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioAlteradoOutroUsuarioException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioCPFDuplicadoException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioCPFDuplicadoException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioCPFInvalidoException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioCPFInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioDataEntradaInvalidaException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioDataEntradaInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioDataNascimentoInvalidaException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioDataNascimentoInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioDataSaidaInvalidaException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioDataSaidaInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioEmailInvalidoException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioEmailInvalidoException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioNomeObrigatorioException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioNomeObrigatorioException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioRGDataEmissaoInvalidaException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioRGDataEmissaoInvalidaException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioRGDuplicadoException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioRGDuplicadoException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.FuncionarioUsuarioDuplicadoException")) {
			return new br.com.prodevelopment.funcionario.FuncionarioUsuarioDuplicadoException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.NoSuchCargoException")) {
			return new br.com.prodevelopment.funcionario.NoSuchCargoException();
		}

		if (className.equals(
					"br.com.prodevelopment.funcionario.NoSuchFuncionarioException")) {
			return new br.com.prodevelopment.funcionario.NoSuchFuncionarioException();
		}

		return throwable;
	}

	public static Object translateOutputCargo(BaseModel<?> oldModel) {
		CargoClp newModel = new CargoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCargoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFuncionario(BaseModel<?> oldModel) {
		FuncionarioClp newModel = new FuncionarioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFuncionarioRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}