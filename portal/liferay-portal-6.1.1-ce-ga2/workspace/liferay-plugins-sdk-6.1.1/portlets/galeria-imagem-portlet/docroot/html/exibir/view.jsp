<%@ include file="init.jsp"%>

<%
	List<FileEntry> fileEntries = (List<FileEntry>) request
			.getAttribute("fileEntries");

	int defaultSpeed = 3000;

	PortletURL embeddedPlayerURL = renderResponse.createRenderURL();

	embeddedPlayerURL.setWindowState(LiferayWindowState.POP_UP);

	embeddedPlayerURL.setParameter("struts_action",
			"/image_gallery_display/embedded_player");
%>
<div id="galeria_imagem" class="galeria_imagem">
	<%
	if (prefExibirTituloPortlet) {
	%>
		<h3>${tituloPortlet }</h3>
	<%	
	}
	if (prefExibirTituloPasta) {
	%>
	<div class="nomePasta">${nomePasta }</div>
	<%	
	}
	if (fileEntries.size() == 0) {
	%>
	<div class="portlet-msg-info">
		<liferay-ui:message key="mensagem.nao.existem.imagens" />
	</div>
<%}
		for (FileEntry fileEntry : fileEntries) {

			FileVersion fileVersion = fileEntry.getFileVersion();

			boolean hasAudio = AudioProcessorUtil.hasAudio(fileVersion);
			boolean hasImages = ImageProcessorUtil.hasImages(fileVersion);
			boolean hasPDFImages = PDFProcessorUtil.hasImages(fileVersion);
			boolean hasVideo = VideoProcessorUtil.hasVideo(fileVersion);

			String href = themeDisplay.getPathThemeImages()
					+ "/file_system/large/"
					+ DLUtil.getGenericName(fileEntry.getExtension())
					+ ".png";
			String src = themeDisplay.getPathThemeImages()
					+ "/file_system/large/"
					+ DLUtil.getGenericName(fileEntry.getExtension())
					+ ".png";

			int playerHeight = 500;
			String dataOptions = StringPool.BLANK;

			if (hasAudio) {
				href = DLUtil.getPreviewURL(fileEntry, fileVersion,
						themeDisplay, HtmlUtil.escapeURL("&audioPreview=1")
								+ "&supportedAudio=1&mediaGallery=1");

				String[] aAudios = PropsUtil
						.getArray("dl.file.entry.preview.audio.containers");
				for (String audioContainer : aAudios) {
					dataOptions += "&"
							+ audioContainer
							+ "PreviewURL="
							+ HtmlUtil.escapeURL(DLUtil.getPreviewURL(
									fileEntry, fileVersion, themeDisplay,
									"&supportedAudio=1&audioPreview=1&type="
											+ audioContainer));
				}

				playerHeight = 43;
			} else if (hasImages) {
				href = DLUtil.getPreviewURL(fileEntry, fileVersion,
						themeDisplay, "&imagePreview=1");
				src = DLUtil.getPreviewURL(fileEntry, fileVersion,
						themeDisplay, "&imageThumbnail=1");
			} else if (hasPDFImages) {
				href = DLUtil.getPreviewURL(fileEntry, fileVersion,
						themeDisplay, "&documentThumbnail=1");
				src = DLUtil.getPreviewURL(fileEntry, fileVersion,
						themeDisplay, "&previewFileIndex=1");
			} else if (hasVideo) {
				href = DLUtil.getPreviewURL(fileEntry, fileVersion,
						themeDisplay, "&supportedVideo=1&mediaGallery=1");
				src = DLUtil.getPreviewURL(fileEntry, fileVersion,
						themeDisplay, "&videoThumbnail=1");

				String[] aVideos = PropsUtil
						.getArray(PropsKeys.DL_FILE_ENTRY_PREVIEW_VIDEO_CONTAINERS);

				for (String videoContainer : aVideos) {
					dataOptions += "&"
							+ videoContainer
							+ "PreviewURL="
							+ HtmlUtil.escapeURL(DLUtil.getPreviewURL(
									fileEntry, fileVersion, themeDisplay,
									"&supportedVideo=1&videoPreview=1&type="
											+ videoContainer));
				}

			}
	%>
	<a class="image-thumbnail preview"
		<%=(hasAudio || hasVideo) ? "data-options=\"height="
						+ playerHeight
						+ "&thumbnailURL="
						+ HtmlUtil.escapeURL(DLUtil.getPreviewURL(fileEntry,
								fileVersion, themeDisplay, "&videoThumbnail=1"))
						+ "&width=640" + dataOptions + "\""
						: StringPool.BLANK%>
		href="<%=href%>" fileEntryId="<%=fileEntry.getFileEntryId()%>"
		title="<%=HtmlUtil.escape(fileEntry.getTitle())%>">
		<img class="imagem"
		alt="<%=HtmlUtil.escape(fileEntry.getTitle())%>"
		border="no" src="<%=src%>"
		style="max-height: 128px; max-width: 128px;" /></a>

	<%
		}
	%>
	<liferay-portlet:renderURL var="renderURL" />
	
	<div class="paginacao">
	<liferay-ui:page-iterator cur="${pagina}" curParam="pagina" type="sample"
		delta="${paginaTamanho }" deltaConfigurable="false" maxPages="50"
		total="${total}" url="<%=renderURL%>" />
	</div>
	
</div>

<aui:script use="aui-image-viewer-gallery,aui-media-viewer-plugin">
	var viewportRegion = A.getDoc().get('viewportRegion');

	var maxHeight = (viewportRegion.height / 2);
	var maxWidth = (viewportRegion.width / 2);

	var imageGallery = new A.ImageGallery(
		{
			after: {
				render: function(event) {
					var instance = this;

					var footerNode = instance.footerNode;

					instance._actions = A.Node.create('<div class="lfr-image-gallery-actions"></div>');

					if (footerNode) {
						footerNode.append(instance._actions);
					}
				}
			},
			delay: 5000,
			maxHeight: <%= prefAlturaImagem %>,
			maxWidth: <%= prefLarguraImagem %>,
			links: '#galeria_imagem .image-thumbnail.preview',
			playingLabel: '(<liferay-ui:message key="label.exibindo.imagem" />)',
			plugins: [
				{
					cfg: {
						'providers.liferay': {
							container: '<iframe frameborder="0" width="{width}" height="{height}" scrolling="no" src="<%= embeddedPlayerURL.toString() %>&<portlet:namespace />thumbnailURL={thumbnailURL}&<portlet:namespace />mp3PreviewURL={mp3PreviewURL}&<portlet:namespace />mp4PreviewURL={mp4PreviewURL}&<portlet:namespace />oggPreviewURL={oggPreviewURL}&<portlet:namespace />ogvPreviewURL={ogvPreviewURL}"></iframe>',
							matcher: /(.+)&mediaGallery=1/,
							options: A.merge(
								A.MediaViewerPlugin.DEFAULT_OPTIONS,
								{
									'thumbnailURL': '',
									'mp3PreviewURL': '',
									'mp4PreviewURL': '',
									'oggPreviewURL': '',
									'ogvPreviewURL': ''
								}
							),
							mediaRegex: /(.+)&mediaGallery=1/
						}
					},
					fn: A.MediaViewerPlugin
				}
			]
		}
	).render();
</aui:script>