function toggle(id) {
	if (document.getElementById(id).style.display == "none")
		document.getElementById(id).style.display = "";
	else
		document.getElementById(id).style.display = "none";
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
    v=v.replace(/\D/g,"");                 //Remove tudo o que não é dígito
    v=v.replace(/^(\d\d)(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d{4})(\d)/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}

function valorDecimal(v){
    v=v.replace(/\D/g,"");                 //Remove tudo o que não é dígito
    v=v.replace(/(\d{2})(\d)/,"$1.$2");    //Coloca ponto entre o segundo e o terceiro dígitos
    return v;
}

function soNumeros(v){
    return v.replace(/\D/g,"");
}

function moeda(v){
	v=v.replace(/\D/g,""); //permite digitar apenas números
	v=v.replace(/[0-9]{12}/,"inválido"); //limita pra máximo 999.999.999,99
	v=v.replace(/(\d{1})(\d{8})$/,"$1.$2"); //coloca ponto antes dos últimos 8 digitos
	v=v.replace(/(\d{1})(\d{5})$/,"$1.$2");  //coloca ponto antes dos últimos 5 digitos
	v=v.replace(/(\d{1})(\d{1,2})$/,"$1,$2"); //coloca virgula antes dos últimos 2 digitos
	return v;
}
