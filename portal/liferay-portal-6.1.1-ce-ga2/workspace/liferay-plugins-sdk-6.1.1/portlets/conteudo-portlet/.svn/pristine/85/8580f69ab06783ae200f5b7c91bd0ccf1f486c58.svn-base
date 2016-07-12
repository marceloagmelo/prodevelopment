<%@ page import="java.security.Principal" %>
<%@include file="init.jsp"%>

<portlet:resourceURL var="ajaxResourceUrl" />


<%
	//String shareURL = ParamUtil.getString(request, "shareURL");
	//String action = ParamUtil.getString(request, "action"); 
	
	User usuario = PortalUtil.getUser(request);
	String userName = "";
	String userEmail = "";
	
	if( usuario!=null ){
	   userName = usuario.getFirstName();
	   userEmail = usuario.getEmailAddress();
	}
%>

<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script type="text/javascript">



function mailCheck(obj) {

	var str = new String(obj.value);
	var at="@";
	var dot=".";
	var lat=str.indexOf(at);
	var lstr=str.length;
	var ldot=str.lastIndexOf(dot);
	var msg = "E-mail inválido";
	if (str.indexOf(at)==-1){
	   document.getElementById("errorMsg").style.display = "inline";
	   document.getElementById("errorMsg").innerHTML = msg;
	   obj.focus();
	   return false;
	}

	if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = msg;
		obj.focus();
	   return false;
	}

	if (ldot==-1 || ldot==0 || ldot==(lstr - 1)){
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = msg;  
	    obj.focus();
	    return false;
	}

	 if (str.indexOf(at,(lat+1))!=-1){
		 document.getElementById("errorMsg").style.display = "inline";
		 document.getElementById("errorMsg").innerHTML = msg;
	     obj.focus();
	    return false;
	 }

	 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = msg;
	    obj.focus();
	    return false;
	 }

	 if (str.indexOf(dot,(lat+2))==-1){
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = msg;
	    obj.focus();
	    return false;
	 }
	
	 if (str.indexOf(" ")!=-1){
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = msg;
	    obj.focus();
	    return false;
	 }

		 return true;					
}

function validateFriendsEmail(){
	
	ok = true;
	count = 0;
	for (i = 1; i <= 5; i++) {
		var obj = document.getElementById("friendEmail"+i);
		if(obj.value != undefined && obj.value != ""){
			ok = ok && mailCheck(obj);
			if(!ok){
				obj.focus();
				document.getElementById("errorMsg").style.display = "inline";
				document.getElementById("errorMsg").innerHTML = "Email inválido.";
				return false;
			}
		}
		else if(obj.value == undefined || obj.value == ""){
			count++;
		}
	}
	if (count == 5){
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = "Preencha pelo menos um email.";
		return false;
	}

	return ok;
}


function validateFields(){

	ok = false;
	
	document.getElementById("errorMsg").style.display = "none";
	
	var userName = document.getElementById("userName");
	if(userName.value==undefined || userName.value==""){
		userName.focus();
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = "O campo Nome é obrigatório.";
		return false;
	}
	var userNameAux = new String(userName.value);
	
	if(userNameAux.length >50 || userNameAux.length <3){
		
		userName.focus();
		document.getElementById("errorMsg").style.display = "inline";
		document.getElementById("errorMsg").innerHTML = "O campo Nome deve possuir no mínimo 3 e no máximo 50 caracteres.";
		return false;
	}
	if(document.getElementById("userEmail").value!=undefined && document.getElementById("userEmail").value!= ""){
		ok = mailCheck(document.getElementById("userEmail"));
		if(!ok){
			document.getElementById("userEmail").focus();
			document.getElementById("errorMsg").style.display = "inline";
			document.getElementById("errorMsg").innerHTML = "Email inválido.";
			return false;	
		}
	}
    if(document.getElementById("userEmail").value==undefined || document.getElementById("userEmail").value== ""){
			document.getElementById("errorMsg").style.display = "inline";
			document.getElementById("errorMsg").innerHTML = "O campo Email é obrigatório.";
			document.getElementById("userEmail").focus();
			return false;
	}

	ok = validateFriendsEmail();

	return ok;
}


function sendEmail(){

	var url = '<%=ajaxResourceUrl%>';
	
	document.getElementById("mensagem").style.display = "none";
	var submit = validateFields();
	
	if(submit){	
		document.getElementById("aguarde").style.display = "inline";
		var params = "userName="+document.getElementById("userName").value+"&"+
					 "userEmail="+document.getElementById("userEmail").value+"&"+
					 "comentario="+document.getElementById("comentario").value+"&"+
					 "friendName1="+document.getElementById("friendName1").value+"&"+
					 "friendName2="+document.getElementById("friendName2").value+"&"+
					 "friendName3="+document.getElementById("friendName3").value+"&"+
					 "friendName4="+document.getElementById("friendName4").value+"&"+
					 "friendName5="+document.getElementById("friendName5").value+"&"+
					 "friendEmail1="+document.getElementById("friendEmail1").value+"&"+
					 "friendEmail2="+document.getElementById("friendEmail2").value+"&"+	
					 "friendEmail3="+document.getElementById("friendEmail3").value+"&"+
					 "friendEmail4="+document.getElementById("friendEmail4").value+"&"+
					 "friendEmail5="+document.getElementById("friendEmail5").value+"&"+
					 "articleUrl="+document.getElementById("articleUrl").value+"&"+
					 "tituloNoticia="+document.getElementById("tituloNoticia").value;
					 
		jQuery.ajax({
			   type: "POST",
			   url: url,
			   data: params,
			   success: function(msg){
			      document.getElementById("mensagem").style.display = "inline";
			      document.getElementById("aguarde").style.display = "none";
			   }
			 });
	}
	else{
		document.getElementById("aguarde").style.display = "none";
	}
}
</script>
<body>	
	<div id="cadastre">   
		   <div style="width: 100%;">
		   		<div id="mensagem" class="portlet-msg-success" style="display: none" align="center">Email(s) enviado(s) com sucesso!</div>
				<div id="aguarde" class="portlet-msg-alert"  style="display: none" align="center">Aguarde...</div>
				<div id="errorMsg" class="portlet-msg-error"  style="display: none" align="center"></div>
			</div>			
					<input type="hidden" id="articleUrl" name="articleUrl" value="${articleurl}">
					<input type="hidden" id="tituloNoticia" name="tituloNoticia" value="<%=request.getParameter("tituloNoticia")%>">
				     <br />
				     <h1>Indique este conteúdo para seus amigos</h1>
             			<div class="indcoluna1">             
             				<div class="categoria2">Seu nome:</div>              
             				<input type="text" id="userName" value="<%= userName %>" class="input_cadastre" tabindex="1">               
            			</div> 
            			<div class="indcoluna2">  
               				<div class="categoria2">Email:</div>
           					<input type="text" height="5" id="userEmail" name="userEmail" value="<%= userEmail %>" class="input_cadastre" tabindex="2">
             			</div>             			
             			<br />
             			<br />
             			<br />
             			<br />
                    	<h2>Indicar para:</h2>
            			<div class="indcoluna1">      
              				<div class="categoria2">Nome:</div>
              				   <input type="text" id="friendName1" class="input_cadastre" tabindex="3"><br />   
            				   <input type="text" id="friendName2" class="input_cadastre" tabindex="5"><br />   
               				   <input type="text" id="friendName3" class="input_cadastre" tabindex="7"><br />   
              				   <input type="text" id="friendName4" class="input_cadastre" tabindex="9"><br />   
             				   <input type="text" id="friendName5" class="input_cadastre" tabindex="11"><br />   
            			</div> 
              			<div class="indcoluna2">    
               				<div class="categoria2">Email:</div>
              				   <input type="text" id="friendEmail1" class="input_cadastre" tabindex="4"><br />  
              				   <input type="text" id="friendEmail2" class="input_cadastre" tabindex="6"><br />  
              				   <input type="text" id="friendEmail3" class="input_cadastre" tabindex="8"><br />  
              				   <input type="text" id="friendEmail4" class="input_cadastre" tabindex="10"><br />       
              		    	   <input type="text" id="friendEmail5" class="input_cadastre" tabindex="12"><br />             
              		    </div>     
              		    <br />  
              		    <div class="indcoluna1" style="clear: both;">  
                        	<div class="categoria2"><br />Comentário:</div>
     							<label><textarea cols="30" rows="3" id="comentario" tabindex="13" class="textarea_cadastre"></textarea></label>
             			</div>
             			<br /> 
             			<br /> 
             			<br /> 
             			<div style="clear: both;">
	  						<div class="emailBotoes">
	  							<div class="aui-button aui-button-submit" title="Cancelar"><span style="margin-left:5px;"><input class="aui-button-input aui-button-input-submit" type="button" onclick="closeThisShit(this);" value="Cancelar"></span></div>
							</div>
							<div class="emailBotoes">	  
	 							<div class="aui-button aui-button-submit" title="Enviar"><input class="aui-button-input aui-button-input-submit" type="submit" value="Enviar" onClick="javascript:sendEmail();return false;"></div>
	  						</div>
	  					</div>	
	</div>
</body>
</html>