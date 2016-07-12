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

package br.com.prodevelopment.appcomercial.servico.service.base;

import br.com.prodevelopment.appcomercial.servico.service.FuncionarioLocalServiceUtil;

import java.util.Arrays;

/**
 * @author marcelo
 * @generated
 */
public class FuncionarioLocalServiceClpInvoker {
	public FuncionarioLocalServiceClpInvoker() {
		_methodName0 = "addFuncionario";

		_methodParameterTypes0 = new String[] {
				"br.com.prodevelopment.appcomercial.servico.model.Funcionario"
			};

		_methodName1 = "createFuncionario";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteFuncionario";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteFuncionario";

		_methodParameterTypes3 = new String[] {
				"br.com.prodevelopment.appcomercial.servico.model.Funcionario"
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

		_methodName10 = "fetchFuncionario";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getFuncionario";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getFuncionarios";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getFuncionariosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateFuncionario";

		_methodParameterTypes15 = new String[] {
				"br.com.prodevelopment.appcomercial.servico.model.Funcionario"
			};

		_methodName34 = "getBeanIdentifier";

		_methodParameterTypes34 = new String[] {  };

		_methodName35 = "setBeanIdentifier";

		_methodParameterTypes35 = new String[] { "java.lang.String" };

		_methodName40 = "addFuncionario";

		_methodParameterTypes40 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int", "int", "int", "int", "boolean",
				"java.lang.String"
			};

		_methodName41 = "update";

		_methodParameterTypes41 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int", "int", "int", "int", "boolean",
				"java.lang.String"
			};

		_methodName42 = "search";

		_methodParameterTypes42 = new String[] {
				"long", "long", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName43 = "searchCount";

		_methodParameterTypes43 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName44 = "search";

		_methodParameterTypes44 = new String[] {
				"long", "long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName45 = "searchCount";

		_methodParameterTypes45 = new String[] { "long", "long" };

		_methodName46 = "search";

		_methodParameterTypes46 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName47 = "searchCount";

		_methodParameterTypes47 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return FuncionarioLocalServiceUtil.addFuncionario((br.com.prodevelopment.appcomercial.servico.model.Funcionario)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return FuncionarioLocalServiceUtil.createFuncionario(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return FuncionarioLocalServiceUtil.deleteFuncionario(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return FuncionarioLocalServiceUtil.deleteFuncionario((br.com.prodevelopment.appcomercial.servico.model.Funcionario)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return FuncionarioLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return FuncionarioLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return FuncionarioLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return FuncionarioLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return FuncionarioLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return FuncionarioLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return FuncionarioLocalServiceUtil.fetchFuncionario(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionario(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionarios(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionariosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return FuncionarioLocalServiceUtil.updateFuncionario((br.com.prodevelopment.appcomercial.servico.model.Funcionario)arguments[0]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			FuncionarioLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return FuncionarioLocalServiceUtil.addFuncionario(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Integer)arguments[14]).intValue(),
				((Integer)arguments[15]).intValue(),
				((Integer)arguments[16]).intValue(),
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(java.lang.String)arguments[24],
				(java.lang.String)arguments[25],
				(java.lang.String)arguments[26],
				(java.lang.String)arguments[27],
				(java.lang.String)arguments[28],
				(java.lang.String)arguments[29],
				(java.lang.String)arguments[30],
				(java.lang.String)arguments[31],
				(java.lang.String)arguments[32],
				(java.lang.String)arguments[33],
				(java.lang.String)arguments[34],
				(java.lang.String)arguments[35],
				(java.lang.String)arguments[36],
				(java.lang.String)arguments[37],
				(java.lang.String)arguments[38],
				((Integer)arguments[39]).intValue(),
				((Integer)arguments[40]).intValue(),
				((Integer)arguments[41]).intValue(),
				((Integer)arguments[42]).intValue(),
				((Integer)arguments[43]).intValue(),
				((Integer)arguments[44]).intValue(),
				((Boolean)arguments[45]).booleanValue(),
				(java.lang.String)arguments[46]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return FuncionarioLocalServiceUtil.update(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				((Integer)arguments[15]).intValue(),
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(java.lang.String)arguments[24],
				(java.lang.String)arguments[25],
				(java.lang.String)arguments[26],
				(java.lang.String)arguments[27],
				(java.lang.String)arguments[28],
				(java.lang.String)arguments[29],
				(java.lang.String)arguments[30],
				(java.lang.String)arguments[31],
				(java.lang.String)arguments[32],
				(java.lang.String)arguments[33],
				(java.lang.String)arguments[34],
				(java.lang.String)arguments[35],
				(java.lang.String)arguments[36],
				(java.lang.String)arguments[37],
				((Integer)arguments[38]).intValue(),
				((Integer)arguments[39]).intValue(),
				((Integer)arguments[40]).intValue(),
				((Integer)arguments[41]).intValue(),
				((Integer)arguments[42]).intValue(),
				((Integer)arguments[43]).intValue(),
				((Boolean)arguments[44]).booleanValue(),
				(java.lang.String)arguments[45]);
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue());
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
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
}