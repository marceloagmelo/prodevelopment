<%
String portletResourceNamespace = ParamUtil.getString(request, "portletResourceNamespace");

DDMStructure structure = null;
if (Validator.isNotNull(typeTask)) {
	if (typeTask.getDDMStructureId() > 0) {
		structure = DDMStructureServiceUtil.getStructure(typeTask.getDDMStructureId());
	}
}

String script = BeanParamUtil.getString(structure, request, "xsd");

JSONArray scriptJSONArray = null;

if (Validator.isNotNull(script)) {
	if (structure != null) {
		try {
			scriptJSONArray = DDMXSDUtil.getJSONArray(structure, script);
		}
		catch (Exception e) {
			scriptJSONArray = DDMXSDUtil.getJSONArray(structure.getDocument());
		}
	}
	else {
		scriptJSONArray = DDMXSDUtil.getJSONArray(script);
	}
}
%>
<liferay-ui:error exception="<%= LocaleException.class %>">

	<%
	LocaleException le = (LocaleException)errorException;
	%>

	<c:if test="<%= le.getType() == LocaleException.TYPE_CONTENT %>">
		<liferay-ui:message arguments="<%= new String[] {StringUtil.merge(le.getSourceAvailableLocales(), StringPool.COMMA_AND_SPACE), StringUtil.merge(le.getTargetAvailableLocales(), StringPool.COMMA_AND_SPACE)} %>" key="the-default-language-x-does-not-match-the-portal's-available-languages-x" />
	</c:if>
</liferay-ui:error>

<%@ include file="/html/form_builder.jspf" %>
