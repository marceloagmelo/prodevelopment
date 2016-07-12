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

package com.liferay.portal.upgrade.v6_1_1;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringBundler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jorge Ferrer
 * @author Julio Camarero
 */
public class UpgradeLayoutSetBranch extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			ps = con.prepareStatement(
				"select groupId, layoutSetBranchId, privateLayout from " +
					"LayoutSetBranch");

			rs = ps.executeQuery();

			while (rs.next()) {
				long layoutSetBranchId = rs.getLong("layoutSetBranchId");
				long groupId = rs.getLong("groupId");
				boolean privateLayout = rs.getBoolean("privateLayout");

				upgradeLayoutSetBranch(
					layoutSetBranchId, groupId, privateLayout);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	protected void updateLayoutSetBranch(
			long layoutSetBranchId, String themeId, String colorSchemeId,
			String wapThemeId, String wapColorSchemeId, String css,
			String settings, String layoutSetPrototypeUuid,
			boolean layoutSetPrototypeLinkEnabled)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			StringBundler sb = new StringBundler(5);

			sb.append("update LayoutSetBranch set themeId = ?, colorSchemeId ");
			sb.append("= ?, wapThemeId = ?, wapColorSchemeId = ?, css = ?, ");
			sb.append("settings_ = ?, layoutSetPrototypeUuid = ?, ");
			sb.append("layoutSetPrototypeLinkEnabled = ? where ");
			sb.append("layoutSetBranchId = ?");

			ps = con.prepareStatement(sb.toString());

			ps.setString(1, themeId);
			ps.setString(2, colorSchemeId);
			ps.setString(3, wapThemeId);
			ps.setString(4, wapColorSchemeId);
			ps.setString(5, css);
			ps.setString(6, settings);
			ps.setString(7, layoutSetPrototypeUuid);
			ps.setBoolean(8, layoutSetPrototypeLinkEnabled);
			ps.setLong(9, layoutSetBranchId);

			ps.executeUpdate();
		}
		finally {
			DataAccess.cleanUp(con, ps);
		}
	}

	protected void upgradeLayoutSetBranch(
			long layoutSetBranchId, long groupId, boolean privateLayout)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			StringBundler sb = new StringBundler(4);

			sb.append("select themeId, colorSchemeId, wapThemeId, ");
			sb.append("wapColorSchemeId, css, settings_, ");
			sb.append("layoutSetPrototypeUuid, layoutSetPrototypeLinkEnabled ");
			sb.append("from LayoutSet where groupId = ? and privateLayout = ?");

			ps = con.prepareStatement(sb.toString());

			ps.setLong(1, groupId);
			ps.setBoolean(2, privateLayout);

			rs = ps.executeQuery();

			while (rs.next()) {
				String themeId = rs.getString("themeId");
				String colorSchemeId = rs.getString("colorSchemeId");
				String wapThemeId = rs.getString("wapThemeId");
				String wapColorSchemeId = rs.getString("wapColorSchemeId");
				String css = rs.getString("css");
				String settings = rs.getString("settings_");
				String layoutSetPrototypeUuid = rs.getString(
					"layoutSetPrototypeUuid");
				boolean layoutSetPrototypeLinkEnabled = rs.getBoolean(
					"layoutSetPrototypeLinkEnabled");

				updateLayoutSetBranch(
					layoutSetBranchId, themeId, colorSchemeId, wapThemeId,
					wapColorSchemeId, css, settings, layoutSetPrototypeUuid,
					layoutSetPrototypeLinkEnabled);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

}