var marker;
var mymap;

navigator.geolocation.getCurrentPosition(function(pos){
	mymap = L.map('mapid').setView([pos.coords.latitude, pos.coords.longitude], 18);
	L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
		maxZoom: 19,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
		'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a> '
	}).addTo(mymap);
	marker = L.marker([pos.coords.latitude,pos.coords.longitude]).addTo(mymap);
});

navigator.geolocation.watchPosition(function(position){
	var newPoint = L.latLng(position.coords.latitude,position.coords.longitude);
	marker.setLatLng(newPoint);
	mymap.setView(newPoint);
});