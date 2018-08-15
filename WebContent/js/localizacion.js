var marker;
var mymap;
var popup;
var latitud;
var longitud;

navigator.geolocation.getCurrentPosition(function(pos){
	latitud = pos.coords.latitude;
	longitud = pos.coords.longitude;
	mymap = L.map('mapid').setView([latitud,longitud], 18);
	L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
		maxZoom: 19,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
		'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a> '
	}).addTo(mymap);
	marker = L.marker([latitud,longitud]).addTo(mymap);
	popup = L.popup().setLatLng([latitud,longitud]).setContent('<p>Holi</p>').openOn(mymap);
});

navigator.geolocation.watchPosition(function(pos){
	var newPoint = L.latLng(pos.coords.latitude,pos.coords.longitude);
	marker.setLatLng(newPoint);
	mymap.setView(newPoint);
});

function CrearPunto(){
	return "insertarLocalizacion.do?latitud="+latitud+"&longitud="+longitud;
};