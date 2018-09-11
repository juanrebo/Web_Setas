/*$(".test").html("holi");

function creaSetas(){
	var nElementos = $(".todasSetas").children().length;
	var anchoTotal = $(".todasSetas").width();
	var anchoFicha = ficha.width();
	var elementosFila = anchoTotal / anchoFicha;
	var contador = 0;
	contador++;
	$(".test").html(anchoTotal +" "+ contador);
}

$(".todasSetas").on("resize", creaSetas());
*/
/*document.getElementsByTagName("BODY")[0].onresize = function() {myFunction()};*/


document.getElementsByTagName("body")[0].onresize = function() {myFunction()};
function myFunction() {
	$("#demo").html($(".todasSetas").width());
}
/*$("body").on('resize', myFunction());*/
$("body").on('resize',function(){
	$("#demo").html($(".todasSetas").width());
	});