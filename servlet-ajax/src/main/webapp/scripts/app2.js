window.onload = carregarDados;

var filtro = document.querySelector("#filtro");
filtro.addEventListener("input", function() {
	var filtroDigitado = this.value;
	var empresas = document.querySelectorAll("li");
	if (filtroDigitado.length > 0) {
		empresas.forEach(function(empresa) {
			var nome = empresa.textContent;
			var re = new RegExp(filtroDigitado, "i");
			if (!re.test(nome)) {
				empresa.classList.add("invisivel");
			} else {
				empresa.classList.remove("invisivel");
			}
		});
	} else {
		empresas.forEach(function(empresa){
			empresa.classList.remove("invisivel");
		});
	}
});

function carregarDados() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "empresas", true);
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			var empresas = JSON.parse(xhr.responseText);
			inserirDadosNaTela(empresas);
		}else{
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	
	xhr.addEventListener("loadstart", function(){
		var loading = document.querySelector(".loading");
		loading.classList.add("active");
	});
	
	xhr.addEventListener("loadend", function(){
		var loading = document.querySelector(".loading");
		loading.classList.remove("active");
	});
	
	xhr.send();
}

function inserirDadosNaTela(empresas) {
	var ul = document.querySelector("#empresas");
	empresas.forEach(function(empresa) {
		var li = criarItemLista(empresa.nome);
		ul.appendChild(li);
	});
	
}

function criarItemLista(nome) {
	var li = document.createElement("li");
	li.textContent = nome;
	return li;
}






















