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

package com.liferay.portal.kernel.uuid;

import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class PortalUUIDUtil {

	public static String fromJsSafeUuid(String jsSafeUuid) {
		return getPortalUUID().fromJsSafeUuid(jsSafeUuid);
	}

	public static String generate() {
		return getPortalUUID().generate();
	}

	public static String generate(byte[] bytes) {
		return getPortalUUID().generate(bytes);
	}

	public static PortalUUID getPortalUUID() {
		PortalRuntimePermission.checkGetBeanProperty(PortalUUIDUtil.class);

		return _portalUUID;
	}

	public static String toJsSafeUuid(String uuid) {
		return getPortalUUID().toJsSafeUuid(uuid);
	}

	public void setPortalUUID(PortalUUID portalUUID) {
		PortalRuntimePermission.checkSetBeanProperty(getClass());

		_portalUUID = portalUUID;
	}

	private static PortalUUID _portalUUID;

}