<%@include file="init.jsp"%>
<%@ include file="mensagens.jspf"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<aui:form method="post" action="${configuracaoURL}" name="fm">
	<h3>
		<liferay-ui:message key="label.categorias" />
	</h3>

	<aui:fieldset>
		<liferay-ui:asset-categories-selector
			curCategoryIds="${assetCategoryIds }"
			className="<%=User.class.getName()%>" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>

</aui:form>