function registro(){
	var nombre = $("input[name=nombre]");
	var correo = $("input[name=correo]");
	var contrasena = $("input[name=contrasena]");
	var contrasena2 = $("input[name=contrasena2]");
	var error = $(".error");
	
	error.text("");
	
	if(nombre.val() == "" || correo.val() =="" || contrasena.val() =="" || contrasena2.val() ==""){
		error.text("Por favor, rellene todos los campos.");
	}else{
		if(contrasena.val() == contrasena2.val()){
			$("#registro").submit();
		}else{
			contrasena.val("");
			contrasena2.val("");
			error.text("La contrase\u00F1a debe coincidir");
		}
	}
}