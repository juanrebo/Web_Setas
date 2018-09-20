function eliminarClas(n) {
	var confirmar = confirm("\u00BFDesea eliminar este elemento?");
    if (confirmar) {
    	var id = "#eliminar"+n;
        $(id).submit();
    }
}