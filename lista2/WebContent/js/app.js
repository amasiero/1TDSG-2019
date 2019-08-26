function getCookie(name) {
  var value = "; " + document.cookie;
  var parts = value.split("; " + name + "=");
  if (parts.length == 2) return parts.pop().split(";").shift();
}

var cookie = getCookie("usuario.logado");
if(!(cookie === undefined)) {
	// Se o cookie existir
}