var marker = L.marker();
var mymap;
var popup;
var latitud;
var longitud;

$(function(){	
	navigator.geolocation.getCurrentPosition(function(pos){
		latitud = pos.coords.latitude;
		longitud = pos.coords.longitude;
		var popupsLayer = L.layerGroup();
		
		var mapaHere = L.tileLayer('https://{s}.{base}.maps.cit.api.here.com/maptile/2.1/{type}/{mapID}/hybrid.day/{z}/{x}/{y}/{size}/{format}?app_id={app_id}&app_code={app_code}&lg={language}', {
			attribution: 'Map &copy; 1987-2014 <a href="http://developer.here.com">HERE</a>',
			subdomains: '1234',
			mapID: 'newest',
			app_id: 'dE4izINR47BdsA7il4sK',
			app_code: 'MWdnXwADKv094Rw4dTqTig',
			base: 'aerial',
			maxZoom: 20,
			type: 'maptile',
			language: 'eng',
			format: 'png8',
			size: '256'
		});
		var mapaOpenStreet = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			maxZoom: 19,
			attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
			'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a> '
		});
		var escala = L.control.scale({
			maxWidth: 200,
			metric: true,
			imperial: true,
			updateWhenIdle: false});
		var icono = L.icon({
			iconUrl: '../img/IconMap.png',
			iconSize: [40,40],
			iconAnchor: [20,34],
			popupAnchor: [0,-30]
		});
		marker.setLatLng([latitud,longitud]);

		mymap = L.map('mapid',{layers: [popupsLayer]}).setView([latitud,longitud], 18);
		
		mapaHere.addTo(mymap);
		escala.addTo(mymap);
		marker.addTo(mymap);
		
		
		$(".popup").each(function(index){
			var popupContenido = $(this).children(".popupContenido");
			var popupHtml = popupContenido.html();
			var popupTexto = popupContenido.children(".popupTexto");
			var popupLat = popupTexto.children(".popupLat").attr("latitud");
			var popupLon = popupTexto.children(".popupLon").attr("longitud");
			var popups = L.marker([popupLat,popupLon],{icon: icono}).addTo(mymap).bindPopup(popupHtml);
			popups.addTo(popupsLayer);
		});
		
		var baseMaps = {
			"Here": mapaHere,
			"OpenStreet": mapaOpenStreet,
		};
		var setasLayer = {
			"Setas": popupsLayer
		}
		L.control.layers(baseMaps, setasLayer).addTo(mymap);
	});

	navigator.geolocation.watchPosition(function(){
		var newPoint = L.latLng([pos.coords.latitude,pos.coords.longitude],{icon: redIcon});
		marker.setLatLng(newPoint);
	});
})

function CrearPunto(){
	return "insertarLocalizacion.do?latitud="+latitud+"&longitud="+longitud;
}


function InsertarLocalizacion(){
	if($("input:radio[name=centroCoords]:checked").val() == "usuario"){
		$("#latUbi").attr("value",marker.getLatLng().lat);
		$("#lonUbi").attr("value",marker.getLatLng().lng);
	}
	if($("input:radio[name=centroCoords]:checked").val() == "mapa"){
		$("#latUbi").attr("value",mymap.getCenter().lat);
		$("#lonUbi").attr("value",mymap.getCenter().lng);
	}
	$("#nuevoPunto").submit();
}

function CentrarSeta(latSeta, lonSeta){
	mymap.setView([latSeta,lonSeta]);
}
function CentrarUsuario(){
	mymap.setView(marker.getLatLng());
}
function MostrarControles(){
	$(".controlesLocalizacion").show();
	$("#botonOcultar").attr("onclick","OcultarControles()");
	$("#botonOcultar").text("CANCELAR");
}
function OcultarControles(){
	$(".controlesLocalizacion").hide();
	$("#botonOcultar").attr("onclick","MostrarControles()");
	$("#botonOcultar").text("NUEVA UBICACI\u00D3N");
}
function MostrarControlesLugar(){
	$(".nuevoLugar").show();
	$("#botonOcultarLugar").attr("onclick","OcultarControlesLugar()");
	$("#botonOcultarLugar").text("CANCELAR");
}
function OcultarControlesLugar(){
	$(".nuevoLugar").hide();
	$("#botonOcultarLugar").attr("onclick","MostrarControlesLugar()");
	$("#botonOcultarLugar").text("NUEVO LUGAR");
}