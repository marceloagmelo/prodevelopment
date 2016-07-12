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

package br.com.prodevelopment.contato.model;

import br.com.prodevelopment.contato.service.ClpSerializer;
import br.com.prodevelopment.contato.service.TelefoneLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcelo Melo
 */
public class TelefoneClp extends BaseModelImpl<Telefone> implements Telefone {
	public TelefoneClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Telefone.class;
	}

	@Override
	public String getModelClassName() {
		return Telefone.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _telefoneId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTelefoneId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _telefoneId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("telefoneId", getTelefoneId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("ddi", getDdi());
		attributes.put("ddd", getDdd());
		attributes.put("numero", getNumero());
		attributes.put("ramal", getRamal());
		attributes.put("tipo", getTipo());
		attributes.put("principal", getPrincipal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long telefoneId = (Long)attributes.get("telefoneId");

		if (telefoneId != null) {
			setTelefoneId(telefoneId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String ddi = (String)attributes.get("ddi");

		if (ddi != null) {
			setDdi(ddi);
		}

		String ddd = (String)attributes.get("ddd");

		if (ddd != null) {
			setDdd(ddd);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		String ramal = (String)attributes.get("ramal");

		if (ramal != null) {
			setRamal(ramal);
		}

		Integer tipo = (Integer)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		Boolean principal = (Boolean)attributes.get("principal");

		if (principal != null) {
			setPrincipal(principal);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_telefoneRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTelefoneId() {
		return _telefoneId;
	}

	@Override
	public void setTelefoneId(long telefoneId) {
		_telefoneId = telefoneId;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefoneId", long.class);

				method.invoke(_telefoneRemoteModel, telefoneId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_telefoneRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_telefoneRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", long.class);

				method.invoke(_telefoneRemoteModel, createUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreateUserId(), "uuid",
			_createUserUuid);
	}

	@Override
	public void setCreateUserUuid(String createUserUuid) {
		_createUserUuid = createUserUuid;
	}

	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_telefoneRemoteModel, modifiedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_telefoneRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_telefoneRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_telefoneRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_telefoneRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDdi() {
		return _ddi;
	}

	@Override
	public void setDdi(String ddi) {
		_ddi = ddi;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setDdi", String.class);

				method.invoke(_telefoneRemoteModel, ddi);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDdd() {
		return _ddd;
	}

	@Override
	public void setDdd(String ddd) {
		_ddd = ddd;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setDdd", String.class);

				method.invoke(_telefoneRemoteModel, ddd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNumero() {
		return _numero;
	}

	@Override
	public void setNumero(String numero) {
		_numero = numero;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setNumero", String.class);

				method.invoke(_telefoneRemoteModel, numero);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRamal() {
		return _ramal;
	}

	@Override
	public void setRamal(String ramal) {
		_ramal = ramal;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setRamal", String.class);

				method.invoke(_telefoneRemoteModel, ramal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTipo() {
		return _tipo;
	}

	@Override
	public void setTipo(int tipo) {
		_tipo = tipo;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo", int.class);

				method.invoke(_telefoneRemoteModel, tipo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPrincipal() {
		return _principal;
	}

	@Override
	public boolean isPrincipal() {
		return _principal;
	}

	@Override
	public void setPrincipal(boolean principal) {
		_principal = principal;

		if (_telefoneRemoteModel != null) {
			try {
				Class<?> clazz = _telefoneRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipal", boolean.class);

				method.invoke(_telefoneRemoteModel, principal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Telefone.class.getName()), getClassNameId());
	}

	public BaseModel<?> getTelefoneRemoteModel() {
		return _telefoneRemoteModel;
	}

	public void setTelefoneRemoteModel(BaseModel<?> telefoneRemoteModel) {
		_telefoneRemoteModel = telefoneRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _telefoneRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_telefoneRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TelefoneLocalServiceUtil.addTelefone(this);
		}
		else {
			TelefoneLocalServiceUtil.updateTelefone(this);
		}
	}

	@Override
	public Telefone toEscapedModel() {
		return (Telefone)ProxyUtil.newProxyInstance(Telefone.class.getClassLoader(),
			new Class[] { Telefone.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TelefoneClp clone = new TelefoneClp();

		clone.setUuid(getUuid());
		clone.setTelefoneId(getTelefoneId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateUserId(getCreateUserId());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setDdi(getDdi());
		clone.setDdd(getDdd());
		clone.setNumero(getNumero());
		clone.setRamal(getRamal());
		clone.setTipo(getTipo());
		clone.setPrincipal(getPrincipal());

		return clone;
	}

	@Override
	public int compareTo(Telefone telefone) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), telefone.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TelefoneClp)) {
			return false;
		}

		TelefoneClp telefone = (TelefoneClp)obj;

		long primaryKey = telefone.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", telefoneId=");
		sb.append(getTelefoneId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", ddi=");
		sb.append(getDdi());
		sb.append(", ddd=");
		sb.append(getDdd());
		sb.append(", numero=");
		sb.append(getNumero());
		sb.append(", ramal=");
		sb.append(getRamal());
		sb.append(", tipo=");
		sb.append(getTipo());
		sb.append(", principal=");
		sb.append(getPrincipal());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("br.com.prodevelopment.contato.model.Telefone");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefoneId</column-name><column-value><![CDATA[");
		sb.append(getTelefoneId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ddi</column-name><column-value><![CDATA[");
		sb.append(getDdi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ddd</column-name><column-value><![CDATA[");
		sb.append(getDdd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numero</column-name><column-value><![CDATA[");
		sb.append(getNumero());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ramal</column-name><column-value><![CDATA[");
		sb.append(getRamal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo</column-name><column-value><![CDATA[");
		sb.append(getTipo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principal</column-name><column-value><![CDATA[");
		sb.append(getPrincipal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _telefoneId;
	private long _companyId;
	private long _groupId;
	private long _createUserId;
	private String _createUserUuid;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private String _ddi;
	private String _ddd;
	private String _numero;
	private String _ramal;
	private int _tipo;
	private boolean _principal;
	private BaseModel<?> _telefoneRemoteModel;
	private Class<?> _clpSerializerClass = br.com.prodevelopment.contato.service.ClpSerializer.class;
}