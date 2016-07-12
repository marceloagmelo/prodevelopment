/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.prodevelopment.funcionario.service.base;

import br.com.prodevelopment.funcionario.service.FuncionarioLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcelo Melo
 * @generated
 */
public class FuncionarioLocalServiceClpInvoker {
	public FuncionarioLocalServiceClpInvoker() {
		_methodName0 = "addFuncionario";

		_methodParameterTypes0 = new String[] {
				"br.com.prodevelopment.funcionario.model.Funcionario"
			};

		_methodName1 = "createFuncionario";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteFuncionario";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteFuncionario";

		_methodParameterTypes3 = new String[] {
				"br.com.prodevelopment.funcionario.model.Funcionario"
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

		_methodName11 = "fetchFuncionarioByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchFuncionarioByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getFuncionario";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getFuncionarioByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getFuncionarioByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getFuncionarios";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getFuncionariosCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateFuncionario";

		_methodParameterTypes19 = new String[] {
				"br.com.prodevelopment.funcionario.model.Funcionario"
			};

		_methodName60 = "getBeanIdentifier";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "setBeanIdentifier";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName66 = "addFuncionario";

		_methodParameterTypes66 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean", "long",
				"double", "long", "boolean", "double", "java.util.List",
				"java.util.List", "com.liferay.portal.service.ServiceContext"
			};

		_methodName67 = "update";

		_methodParameterTypes67 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "long", "double", "long", "boolean", "double",
				"java.util.List", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName68 = "deleteFuncionario";

		_methodParameterTypes68 = new String[] {
				"br.com.prodevelopment.funcionario.model.Funcionario", "long"
			};

		_methodName69 = "updateAsset";

		_methodParameterTypes69 = new String[] {
				"long", "br.com.prodevelopment.funcionario.model.Funcionario",
				"long[][]", "java.lang.String[][]", "long[][]"
			};

		_methodName70 = "search";

		_methodParameterTypes70 = new String[] {
				"long", "long", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName71 = "searchCount";

		_methodParameterTypes71 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName72 = "search";

		_methodParameterTypes72 = new String[] {
				"long", "long", "java.lang.String", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName73 = "searchCount";

		_methodParameterTypes73 = new String[] {
				"long", "long", "java.lang.String", "boolean"
			};

		_methodName74 = "search";

		_methodParameterTypes74 = new String[] {
				"long", "long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName75 = "searchCount";

		_methodParameterTypes75 = new String[] { "long", "long" };

		_methodName76 = "search";

		_methodParameterTypes76 = new String[] {
				"long", "long", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName77 = "searchCount";

		_methodParameterTypes77 = new String[] { "long", "long", "boolean" };

		_methodName78 = "search";

		_methodParameterTypes78 = new String[] {
				"long", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName79 = "searchCount";

		_methodParameterTypes79 = new String[] { "long", "java.lang.String" };

		_methodName80 = "search";

		_methodParameterTypes80 = new String[] {
				"long", "java.lang.String", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName81 = "searchCount";

		_methodParameterTypes81 = new String[] {
				"long", "java.lang.String", "boolean"
			};

		_methodName82 = "search";

		_methodParameterTypes82 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName83 = "searchCount";

		_methodParameterTypes83 = new String[] { "long" };

		_methodName84 = "search";

		_methodParameterTypes84 = new String[] {
				"long", "boolean", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName85 = "searchCount";

		_methodParameterTypes85 = new String[] { "long", "boolean" };

		_methodName86 = "updateFoto";

		_methodParameterTypes86 = new String[] { "long", "byte[][]" };

		_methodName87 = "deleteFoto";

		_methodParameterTypes87 = new String[] { "long" };

		_methodName88 = "updateFoto";

		_methodParameterTypes88 = new String[] { "long", "long" };

		_methodName89 = "fetchByUSUARIO";

		_methodParameterTypes89 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return FuncionarioLocalServiceUtil.addFuncionario((br.com.prodevelopment.funcionario.model.Funcionario)arguments[0]);
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
			return FuncionarioLocalServiceUtil.deleteFuncionario((br.com.prodevelopment.funcionario.model.Funcionario)arguments[0]);
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
			return FuncionarioLocalServiceUtil.fetchFuncionarioByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return FuncionarioLocalServiceUtil.fetchFuncionarioByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionario(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionarioByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionarioByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionarios(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getFuncionariosCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return FuncionarioLocalServiceUtil.updateFuncionario((br.com.prodevelopment.funcionario.model.Funcionario)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return FuncionarioLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			FuncionarioLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return FuncionarioLocalServiceUtil.addFuncionario(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				((Long)arguments[18]).longValue(),
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(java.lang.String)arguments[24],
				(java.lang.String)arguments[25],
				((Long)arguments[26]).longValue(),
				(java.lang.String)arguments[27],
				(java.lang.String)arguments[28],
				(java.lang.String)arguments[29],
				(java.lang.String)arguments[30],
				((Boolean)arguments[31]).booleanValue(),
				((Long)arguments[32]).longValue(),
				((Double)arguments[33]).doubleValue(),
				((Long)arguments[34]).longValue(),
				((Boolean)arguments[35]).booleanValue(),
				((Double)arguments[36]).doubleValue(),
				(java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail>)arguments[37],
				(java.util.List<br.com.prodevelopment.contato.model.Telefone>)arguments[38],
				(com.liferay.portal.service.ServiceContext)arguments[39]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return FuncionarioLocalServiceUtil.update(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				((Long)arguments[19]).longValue(),
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(java.lang.String)arguments[24],
				(java.lang.String)arguments[25],
				(java.lang.String)arguments[26],
				((Long)arguments[27]).longValue(),
				(java.lang.String)arguments[28],
				(java.lang.String)arguments[29],
				(java.lang.String)arguments[30],
				(java.lang.String)arguments[31],
				((Boolean)arguments[32]).booleanValue(),
				((Long)arguments[33]).longValue(),
				((Double)arguments[34]).doubleValue(),
				((Long)arguments[35]).longValue(),
				((Boolean)arguments[36]).booleanValue(),
				((Double)arguments[37]).doubleValue(),
				(java.util.List<br.com.prodevelopment.contato.model.EnderecoEmail>)arguments[38],
				(java.util.List<br.com.prodevelopment.contato.model.Telefone>)arguments[39],
				(com.liferay.portal.service.ServiceContext)arguments[40]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return FuncionarioLocalServiceUtil.deleteFuncionario((br.com.prodevelopment.funcionario.model.Funcionario)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			FuncionarioLocalServiceUtil.updateAsset(((Long)arguments[0]).longValue(),
				(br.com.prodevelopment.funcionario.model.Funcionario)arguments[1],
				(long[])arguments[2], (java.lang.String[])arguments[3],
				(long[])arguments[4]);

			return null;
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[6]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return FuncionarioLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return FuncionarioLocalServiceUtil.searchCount(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return FuncionarioLocalServiceUtil.updateFoto(((Long)arguments[0]).longValue(),
				(byte[])arguments[1]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			FuncionarioLocalServiceUtil.deleteFoto(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return FuncionarioLocalServiceUtil.updateFoto(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return FuncionarioLocalServiceUtil.fetchByUSUARIO(((Long)arguments[0]).longValue());
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
}