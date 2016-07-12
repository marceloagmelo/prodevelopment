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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.OrgGroupPermission;
import com.liferay.portal.model.OrgGroupPermissionModel;
import com.liferay.portal.service.persistence.OrgGroupPermissionPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OrgGroupPermission service. Represents a row in the &quot;OrgGroupPermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.OrgGroupPermissionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrgGroupPermissionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrgGroupPermissionImpl
 * @see com.liferay.portal.model.OrgGroupPermission
 * @see com.liferay.portal.model.OrgGroupPermissionModel
 * @generated
 */
public class OrgGroupPermissionModelImpl extends BaseModelImpl<OrgGroupPermission>
	implements OrgGroupPermissionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a org group permission model instance should use the {@link com.liferay.portal.model.OrgGroupPermission} interface instead.
	 */
	public static final String TABLE_NAME = "OrgGroupPermission";
	public static final Object[][] TABLE_COLUMNS = {
			{ "organizationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "permissionId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table OrgGroupPermission (organizationId LONG not null,groupId LONG not null,permissionId LONG not null,primary key (organizationId, groupId, permissionId))";
	public static final String TABLE_SQL_DROP = "drop table OrgGroupPermission";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.OrgGroupPermission"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.OrgGroupPermission"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.OrgGroupPermission"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long PERMISSIONID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.OrgGroupPermission"));

	public OrgGroupPermissionModelImpl() {
	}

	public OrgGroupPermissionPK getPrimaryKey() {
		return new OrgGroupPermissionPK(_organizationId, _groupId, _permissionId);
	}

	public void setPrimaryKey(OrgGroupPermissionPK primaryKey) {
		setOrganizationId(primaryKey.organizationId);
		setGroupId(primaryKey.groupId);
		setPermissionId(primaryKey.permissionId);
	}

	public Serializable getPrimaryKeyObj() {
		return new OrgGroupPermissionPK(_organizationId, _groupId, _permissionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((OrgGroupPermissionPK)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return OrgGroupPermission.class;
	}

	public String getModelClassName() {
		return OrgGroupPermission.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationId", getOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("permissionId", getPermissionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long permissionId = (Long)attributes.get("permissionId");

		if (permissionId != null) {
			setPermissionId(permissionId);
		}
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getPermissionId() {
		return _permissionId;
	}

	public void setPermissionId(long permissionId) {
		_columnBitmask |= PERMISSIONID_COLUMN_BITMASK;

		if (!_setOriginalPermissionId) {
			_setOriginalPermissionId = true;

			_originalPermissionId = _permissionId;
		}

		_permissionId = permissionId;
	}

	public long getOriginalPermissionId() {
		return _originalPermissionId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public OrgGroupPermission toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (OrgGroupPermission)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		OrgGroupPermissionImpl orgGroupPermissionImpl = new OrgGroupPermissionImpl();

		orgGroupPermissionImpl.setOrganizationId(getOrganizationId());
		orgGroupPermissionImpl.setGroupId(getGroupId());
		orgGroupPermissionImpl.setPermissionId(getPermissionId());

		orgGroupPermissionImpl.resetOriginalValues();

		return orgGroupPermissionImpl;
	}

	public int compareTo(OrgGroupPermission orgGroupPermission) {
		OrgGroupPermissionPK primaryKey = orgGroupPermission.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgGroupPermission orgGroupPermission = null;

		try {
			orgGroupPermission = (OrgGroupPermission)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		OrgGroupPermissionPK primaryKey = orgGroupPermission.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		OrgGroupPermissionModelImpl orgGroupPermissionModelImpl = this;

		orgGroupPermissionModelImpl._originalGroupId = orgGroupPermissionModelImpl._groupId;

		orgGroupPermissionModelImpl._setOriginalGroupId = false;

		orgGroupPermissionModelImpl._originalPermissionId = orgGroupPermissionModelImpl._permissionId;

		orgGroupPermissionModelImpl._setOriginalPermissionId = false;

		orgGroupPermissionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OrgGroupPermission> toCacheModel() {
		OrgGroupPermissionCacheModel orgGroupPermissionCacheModel = new OrgGroupPermissionCacheModel();

		orgGroupPermissionCacheModel.organizationId = getOrganizationId();

		orgGroupPermissionCacheModel.groupId = getGroupId();

		orgGroupPermissionCacheModel.permissionId = getPermissionId();

		return orgGroupPermissionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{organizationId=");
		sb.append(getOrganizationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", permissionId=");
		sb.append(getPermissionId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.OrgGroupPermission");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permissionId</column-name><column-value><![CDATA[");
		sb.append(getPermissionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OrgGroupPermission.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			OrgGroupPermission.class
		};
	private long _organizationId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _permissionId;
	private long _originalPermissionId;
	private boolean _setOriginalPermissionId;
	private long _columnBitmask;
	private OrgGroupPermission _escapedModelProxy;
}