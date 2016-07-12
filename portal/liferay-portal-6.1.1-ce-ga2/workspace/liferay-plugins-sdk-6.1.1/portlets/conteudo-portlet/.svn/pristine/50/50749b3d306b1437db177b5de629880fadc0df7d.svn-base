function MudarTamanho(Tipo, Objeto) {
	if (navigator.appName == "Netscape") {
		b_objeto_i = "document.getElementById('";
		b_objeto_f = "')";
	} else {
		b_objeto_i = "document.all.";
		b_objeto_f = "";
	}
	eval("var obj=" + b_objeto_i + Objeto + b_objeto_f);
	var Tamanho = parseFloat(obj.style.fontSize.replace("em", ""));
	if (isNaN(Tamanho)) {
		Tamanho = .9;
	}
	Tamanho = (Tipo == 0 ? .9 : Tamanho + Tipo);
	if (Tamanho < 1.7 && Tamanho > 0.5) {
		obj.style.fontSize = Tamanho + "em";
	}
}

var dialog;

function showSharePageArticle(url, idConteudo){

	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {

		url = url + "&articleurl=";
		url = url + idConteudo;

		url = url + "&act=email";

         dialog = new A.Dialog({
                title: 'Indique aos seus amigos',
                centered: true,
                draggable: true,
                modal: true,
                width: 510,
                heigth: 750
        }).plug(A.Plugin.IO, {uri: url}).render();

        dialog.show();

    });
}
function showImagePopup(url, downloadurl, params, width ,height, title, modal){
	 var html = "<img src=\""+url+"\"></img>";
	 if(downloadurl != ""){
		 downloadurl = new String(downloadurl).replace("/image/image_gallery","/imagens");
		 height = (height + 28);
	 }

	 AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {

	        var dialog = new A.Dialog({
	                title: 'Imagem Relacionada',
	                bodyContent:html,
	                centered: true,
	                draggable: true,
	                modal: true,
	        }).render();

	        dialog.show();
	    });

}

function closeThisShit(teste) {
		 dialog.close();
}