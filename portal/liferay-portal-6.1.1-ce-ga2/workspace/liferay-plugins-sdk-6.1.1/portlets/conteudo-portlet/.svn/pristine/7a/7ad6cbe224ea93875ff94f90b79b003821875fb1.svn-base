<%
AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
		JournalArticle.class.getName(), artigoDisplay.getResourcePrimKey());

long assetEntryId =  assetEntry.getEntryId();

List<AssetLink> assetLinks = null;

if (assetEntryId > 0) {
	assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(assetEntryId);
}
%>

<c:if test="<%= (assetLinks != null) && !assetLinks.isEmpty() %>">
	<div class="taglib-asset-links">
		<h2 class="asset-links-title"><liferay-ui:message key="related-assets" />:</h2>

		<ul class="asset-links-list">

			<%
			for (AssetLink assetLink : assetLinks) {
				AssetEntry assetLinkEntry = null;

				if (assetLink.getEntryId1() == assetEntryId) {
					assetLinkEntry = AssetEntryServiceUtil.getEntry(assetLink.getEntryId2());
				}
				else {
					assetLinkEntry = AssetEntryServiceUtil.getEntry(assetLink.getEntryId1());
				}

				if (!assetLinkEntry.isVisible()) {
					continue;
				}

				assetLinkEntry = assetLinkEntry.toEscapedModel();

				AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(PortalUtil.getClassName(assetLinkEntry.getClassNameId()));

				AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(assetLinkEntry.getClassPK());

				String asseLinktEntryTitle = assetLinkEntry.getTitle(locale);
				String icone = assetRendererFactory.getIconPath(renderRequest); 
				String tipo = assetRendererFactory.getType();
				String url = themeDisplay.getPortalURL()+"/"+assetRenderer.getUrlTitle();
				
				String target = "";
				
				if (Constantes.TIPO_DOCUMENTO.equals(tipo)) {
					url = Helper.getDocDownloadUrl(String.valueOf(assetLinkEntry.getGroupId()), assetLinkEntry.getClassUuid(), themeDisplay);
					url = themeDisplay.getPortalURL()+"/"+url;
					target = "_blank";
				}
				
			%>
					<li class="asset-links-list-item">
					<img src="<%=assetRenderer.getIconPath(renderRequest) %>" /> <a href="<%=url %>" target="<%=target%>"><%=asseLinktEntryTitle %></a>
					</li>
	
			<%
			}
			%>

		</ul>
	</div>
</c:if>