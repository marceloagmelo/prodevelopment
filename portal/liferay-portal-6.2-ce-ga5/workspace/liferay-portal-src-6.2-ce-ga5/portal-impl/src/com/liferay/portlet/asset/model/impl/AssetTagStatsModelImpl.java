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

package com.liferay.portlet.asset.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.asset.model.AssetTagStats;
import com.liferay.portlet.asset.model.AssetTagStatsModel;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AssetTagStats service. Represents a row in the &quot;AssetTagStats&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.asset.model.AssetTagStatsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetTagStatsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagStatsImpl
 * @see com.liferay.portlet.asset.model.AssetTagStats
 * @see com.liferay.portlet.asset.model.AssetTagStatsModel
 * @generated
 */
public class AssetTagStatsModelImpl extends BaseModelImpl<AssetTagStats>
	implements AssetTagStatsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset tag stats model instance should use the {@link com.liferay.portlet.asset.model.AssetTagStats} interface instead.
	 */
	public static final String TABLE_NAME = "AssetTagStats";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tagStatsId", Types.BIGINT },
			{ "tagId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "assetCount", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table AssetTagStats (tagStatsId LONG not null primary key,tagId LONG,classNameId LONG,assetCount INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table AssetTagStats";
	public static final String ORDER_BY_JPQL = " ORDER BY assetTagStats.assetCount DESC";
	public static final String ORDER_BY_SQL = " ORDER BY AssetTagStats.assetCount DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.asset.model.AssetTagStats"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.asset.model.AssetTagStats"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.asset.model.AssetTagStats"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long TAGID_COLUMN_BITMASK = 2L;
	public static long ASSETCOUNT_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.asset.model.AssetTagStats"));

	public AssetTagStatsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tagStatsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTagStatsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tagStatsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AssetTagStats.class;
	}

	@Override
	public String getModelClassName() {
		return AssetTagStats.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagStatsId", getTagStatsId());
		attributes.put("tagId", getTagId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("assetCount", getAssetCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagStatsId = (Long)attributes.get("tagStatsId");

		if (tagStatsId != null) {
			setTagStatsId(tagStatsId);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Integer assetCount = (Integer)attributes.get("assetCount");

		if (assetCount != null) {
			setAssetCount(assetCount);
		}
	}

	@Override
	public long getTagStatsId() {
		return _tagStatsId;
	}

	@Override
	public void setTagStatsId(long tagStatsId) {
		_tagStatsId = tagStatsId;
	}

	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_columnBitmask |= TAGID_COLUMN_BITMASK;

		if (!_setOriginalTagId) {
			_setOriginalTagId = true;

			_originalTagId = _tagId;
		}

		_tagId = tagId;
	}

	public long getOriginalTagId() {
		return _originalTagId;
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
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public int getAssetCount() {
		return _assetCount;
	}

	@Override
	public void setAssetCount(int assetCount) {
		_columnBitmask = -1L;

		_assetCount = assetCount;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			AssetTagStats.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AssetTagStats toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AssetTagStats)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AssetTagStatsImpl assetTagStatsImpl = new AssetTagStatsImpl();

		assetTagStatsImpl.setTagStatsId(getTagStatsId());
		assetTagStatsImpl.setTagId(getTagId());
		assetTagStatsImpl.setClassNameId(getClassNameId());
		assetTagStatsImpl.setAssetCount(getAssetCount());

		assetTagStatsImpl.resetOriginalValues();

		return assetTagStatsImpl;
	}

	@Override
	public int compareTo(AssetTagStats assetTagStats) {
		int value = 0;

		if (getAssetCount() < assetTagStats.getAssetCount()) {
			value = -1;
		}
		else if (getAssetCount() > assetTagStats.getAssetCount()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof AssetTagStats)) {
			return false;
		}

		AssetTagStats assetTagStats = (AssetTagStats)obj;

		long primaryKey = assetTagStats.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		AssetTagStatsModelImpl assetTagStatsModelImpl = this;

		assetTagStatsModelImpl._originalTagId = assetTagStatsModelImpl._tagId;

		assetTagStatsModelImpl._setOriginalTagId = false;

		assetTagStatsModelImpl._originalClassNameId = assetTagStatsModelImpl._classNameId;

		assetTagStatsModelImpl._setOriginalClassNameId = false;

		assetTagStatsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AssetTagStats> toCacheModel() {
		AssetTagStatsCacheModel assetTagStatsCacheModel = new AssetTagStatsCacheModel();

		assetTagStatsCacheModel.tagStatsId = getTagStatsId();

		assetTagStatsCacheModel.tagId = getTagId();

		assetTagStatsCacheModel.classNameId = getClassNameId();

		assetTagStatsCacheModel.assetCount = getAssetCount();

		return assetTagStatsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{tagStatsId=");
		sb.append(getTagStatsId());
		sb.append(", tagId=");
		sb.append(getTagId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", assetCount=");
		sb.append(getAssetCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.asset.model.AssetTagStats");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tagStatsId</column-name><column-value><![CDATA[");
		sb.append(getTagStatsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetCount</column-name><column-value><![CDATA[");
		sb.append(getAssetCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AssetTagStats.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AssetTagStats.class
		};
	private long _tagStatsId;
	private long _tagId;
	private long _originalTagId;
	private boolean _setOriginalTagId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private int _assetCount;
	private long _columnBitmask;
	private AssetTagStats _escapedModel;
}