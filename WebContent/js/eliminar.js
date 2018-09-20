function eliminar(){
	var confirmar = confirm("¿Deseas eliminar este registro?");
	if(confirmar){
		$("#eliminar").submit();
	}
}