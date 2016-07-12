function SomenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}

function mascara(o,f){
    v_obj=o;
    v_fun=f;
    setTimeout("execmascara()",1);
}
 
function execmascara(){
    v_obj.value=v_fun(v_obj.value);
}
 
function telefone(v){
    v=v.replace(/\D/g,"");                 //Remove tudo o que n�o � d�gito
    v=v.replace(/^(\d\d)(\d)/g,"($1) $2"); //Coloca par�nteses em volta dos dois primeiros d�gitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2");    //Coloca h�fen entre o quarto e o quinto d�gitos
    return v;
}

function soNumeros(v){
    return v.replace(/\D/g,"");
}

function moeda(v){
	v=v.replace(/\D/g,""); //permite digitar apenas n�meros
	v=v.replace(/[0-9]{12}/,"invalido"); //limita pra m�ximo 999.999.999,99
	v=v.replace(/(\d{1})(\d{8})$/,"$1.$2"); //coloca ponto antes dos �ltimos 8 digitos
	v=v.replace(/(\d{1})(\d{5})$/,"$1.$2");  //coloca ponto antes dos �ltimos 5 digitos
	v=v.replace(/(\d{1})(\d{1,2})$/,"$1,$2"); //coloca virgula antes dos �ltimos 2 digitos
	return v;
}
