package br.com.prodevelopment.hook.social;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.SystemEventConstants;
import com.liferay.portal.service.SystemEventLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceWrapper;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;

public class ExtAssetEntryLocalService extends AssetEntryLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portlet.asset.service.AssetEntryLocalServiceWrapper#AssetEntryLocalServiceWrapper(AssetEntryLocalService assetEntryLocalService)
	 */
	public ExtAssetEntryLocalService(AssetEntryLocalService assetEntryLocalService) {
		super(assetEntryLocalService);
	}

	@Override
	public void deleteEntry(AssetEntry entry)
		throws PortalException, SystemException {

		// Entry
		List<AssetTag> tags = entry.getTags();
		

		AssetEntryLocalServiceUtil.deleteAssetEntry(entry);

		// System event
		SystemEventLocalServiceUtil.addSystemEvent(
			0, entry.getGroupId(), entry.getClassName(), entry.getClassPK(),
			entry.getClassUuid(), null, SystemEventConstants.TYPE_DELETE, null);
		
		// Links
		AssetLinkLocalServiceUtil.deleteLinks(entry.getEntryId());

		// Tags

		for (AssetTag tag : tags) {
			if (entry.isVisible()) {
				AssetTagLocalServiceUtil.decrementAssetCount(tag.getTagId(), entry.getClassNameId());
			}
		}
	}

	@Override
	public void deleteEntry(String className, long classPK)
		throws PortalException, SystemException {

		AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(className, classPK);

		if (entry != null) {
			deleteEntry(entry);
		}
	}
}