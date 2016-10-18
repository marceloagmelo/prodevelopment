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

package br.com.prodevelopment.cliente.service.base;

import br.com.prodevelopment.cliente.service.ClienteLimCreditoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author marcelo
 * @generated
 */
public class ClienteLimCreditoLocalServiceClpInvoker {
	public ClienteLimCreditoLocalServiceClpInvoker() {
		_methodName0 = "addClienteLimCredito";

		_methodParameterTypes0 = new String[] {
				"br.com.prodevelopment.cliente.model.ClienteLimCredito"
			};

		_methodName1 = "createClienteLimCredito";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteClienteLimCredito";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteClienteLimCredito";

		_methodParameterTypes3 = new String[] {
				"br.com.prodevelopment.cliente.model.ClienteLimCredito"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchClienteLimCredito";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getClienteLimCredito";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getClienteLimCreditos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getClienteLimCreditosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateClienteLimCredito";

		_methodParameterTypes15 = new String[] {
				"br.com.prodevelopment.cliente.model.ClienteLimCredito"
			};

		_methodName46 = "getBeanIdentifier";

		_methodParameterTypes46 = new String[] {  };

		_methodName47 = "setBeanIdentifier";

		_methodParameterTypes47 = new String[] { "java.lang.String" };

		_methodName52 = "addClienteLimCredito";

		_methodParameterTypes52 = new String[] {
				"long", "double", "java.lang.String", "double", "int"
			};

		_methodName53 = "update";

		_methodParameterTypes53 = new String[] {
				"long", "double", "java.lang.String", "double", "int"
			};

		_methodName54 = "fetchByClienteLimCredito";

		_methodParameterTypes54 = new String[] { "long" };

		_methodName55 = "fetchByCliente";

		_methodParameterTypes55 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.addClienteLimCredito((br.com.prodevelopment.cliente.model.ClienteLimCredito)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.createClienteLimCredito(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.deleteClienteLimCredito(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.deleteClienteLimCredito((br.com.prodevelopment.cliente.model.ClienteLimCredito)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.fetchClienteLimCredito(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.getClienteLimCredito(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.getClienteLimCreditos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.getClienteLimCreditosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.updateClienteLimCredito((br.com.prodevelopment.cliente.model.ClienteLimCredito)arguments[0]);
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			ClienteLimCreditoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.addClienteLimCredito(((Long)arguments[0]).longValue(),
				((Double)arguments[1]).doubleValue(),
				(java.lang.String)arguments[2],
				((Double)arguments[3]).doubleValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.update(((Long)arguments[0]).longValue(),
				((Double)arguments[1]).doubleValue(),
				(java.lang.String)arguments[2],
				((Double)arguments[3]).doubleValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.fetchByClienteLimCredito(((Long)arguments[0]).longValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return ClienteLimCreditoLocalServiceUtil.fetchByCliente(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
}