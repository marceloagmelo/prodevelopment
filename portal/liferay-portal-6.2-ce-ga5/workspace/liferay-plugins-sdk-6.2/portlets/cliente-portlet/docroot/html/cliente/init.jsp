<%@ include file="/html/init.jsp" %>


<%@page import="br.com.prodevelopment.portlet.cliente.util.ClienteUtil" %>
<%@page import="br.com.prodevelopment.portlet.cliente.util.TelefoneUtil" %>
<%@page import="br.com.prodevelopment.portlet.cliente.util.EnderecoEmailUtil" %>
<%@page import="br.com.prodevelopment.portlet.cliente.util.EnderecoUtil" %>

<%@page import="br.com.prodevelopment.cliente.model.Cliente" %>
<%@page import="br.com.prodevelopment.cliente.model.impl.ClienteImpl" %>
<%@page import="br.com.prodevelopment.cliente.model.ClienteLimCredito" %>
<%@page import="br.com.prodevelopment.contato.model.Telefone" %>
<%@page import="br.com.prodevelopment.contato.model.EnderecoEmail" %>
<%@page import="br.com.prodevelopment.contato.model.Endereco" %>

<%@page import="br.com.prodevelopment.cliente.ClienteNomeObrigatorioException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteDataNascimentoInvalidaException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteRGDataEmissaoInvalidaException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteDataLimiteMaxCreditoInvalidaException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteCPFInvalidoException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteCPFDuplicadoException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteCNPJInvalidoException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteCNPJDuplicadoException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteRGInscricaoMunDuplicadoException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteUsuarioDuplicadoException" %>
<%@page import="br.com.prodevelopment.cliente.ClienteAlteradoOutroUsuarioException" %>
<%@page import="br.com.prodevelopment.contato.TelefoneTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.contato.TelefoneDDDObrigatotioException" %>
<%@page import="br.com.prodevelopment.contato.TelefoneDDDInvalidoException" %>
<%@page import="br.com.prodevelopment.contato.TelefoneNumeroObrigatotioException" %>
<%@page import="br.com.prodevelopment.contato.TelefoneNumeroInvalidoException" %>
<%@page import="br.com.prodevelopment.contato.EnderecoEmailTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.contato.EnderecoEmailEnderecoObrigatotioException" %>
<%@page import="br.com.prodevelopment.contato.EnderecoEmailEnderecoInvalidoException" %>
<%@page import="br.com.prodevelopment.contato.EnderecoTipoObrigatotioException" %>
<%@page import="br.com.prodevelopment.contato.EnderecoLogradouroObrigatotioException" %>

<%@page import="br.com.prodevelopment.portlet.cliente.comparator.ClientesComparator" %>
<%@page import="br.com.prodevelopment.portlet.cliente.search.ClienteSearch" %>
<%@page import="br.com.prodevelopment.portlet.cliente.search.ClienteDisplayTerms" %>
