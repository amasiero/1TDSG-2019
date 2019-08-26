console.log(document.cookie);

function getCookie(name) {
  var value = "; " + document.cookie;
  var parts = value.split("; " + name + "=");
  if (parts.length == 2) return parts.pop().split(";").shift();
}

var cookie = getCookie("usuario.logado");
var info = document.getElementById("info-logado");
if(!(cookie === undefined)) {
	// Logado
	info.style.display = "block";
	info.querySelector("span").textContent = cookie;
	document.querySelector("#frm-login").style.display = "none";
	document.querySelector("#acessa-cadastro").style.display = "none";
} else {
	// Não Logado
	info.style.display = "none";
	info.querySelector("span").textContent = "";
	document.querySelector("#frm-login").style.display = "block";
	document.querySelector("#acessa-cadastro").style.display = "block";
}