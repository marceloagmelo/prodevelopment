<div class="columns-2" id="main-content" role="main">
	#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
		<table class="portlet-layout nav_lateral_conteudo">
		<tr>
			<td class="portlet-column portlet-column-first nav_lateral" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
			</td>
			<td class="portlet-column portlet-column-last conteudo" id="column-2">
				$processor.processColumn("column-2", "portlet-column-content portlet-column-content-last")
			</td>
		</tr>
		</table>
	#else
		<div class="portlet-layout nav_lateral_conteudo">
			<div class="portlet-column portlet-column-first nav_lateral" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
			</div>

			<div class="portlet-column portlet-column-last conteudo" id="column-2">
				$processor.processColumn("column-2", "portlet-column-content portlet-column-content-last")
			</div>
		</div>
	#end
</div>