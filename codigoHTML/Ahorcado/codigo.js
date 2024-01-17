let palabra;
let aciertos = 0;
let fallos = 0;
let coincidencia = false;

function cogerPalabra() {
	palabra = prompt("Escriba una palabra de 5 letras").toLowerCase();
	reiniciar();
}

function probar() {
	caracter = document.getElementById("letra").value;
	anterior = aciertos;
	coincidencia = false;
	for (var i = 0; i < 5; i++) {
		probarSimple(caracter, i, "r" + (i + 1));
	}
	if (!coincidencia) {

		fallos++;
		intentos = 5 - fallos;
		document.getElementById('mensaje2').innerHTML = intentos;
		mensaje1("MAL");
		cambiarDibujo(fallos);
	}
	else {
		mensaje1("BIEN");
	}
	if (fallos >= 5) {
		mensaje1("HAS PERDIDO");
		fallos = 5;
	}
	else if (aciertos >= 5) {
		mensaje1("HAS GANADO");
	}
	caracter = document.getElementById("letra").value = "";
	caracter = document.getElementById("letra").focus();

}

function probarSimple(caracter, posicion, controlName) {
	//console.log(caracter);
	if (document.getElementById(controlName).value != caracter) {
		if (palabra.charAt(posicion) == caracter) {
			aciertos = aciertos + 1;
			document.getElementById(controlName).value = caracter;
			coincidencia = true;
		}
	}
	else {
		coincidencia = true;
	}
}

function cambiarDibujo(numero) {
	document.getElementById("dibujo").innerHTML = '<object type="image/jpg" data="./dibujos/' + numero + '.png"></object>';
}

function mensaje1(texto){
	document.getElementById("mensaje1").innerHTML = texto;
}

function reiniciar() {
	aciertos = 0;
	fallos = 0;
	document.getElementById("r1").value = "";
	document.getElementById("r2").value = "";
	document.getElementById("r3").value = "";
	document.getElementById("r4").value = "";
	document.getElementById("r5").value = "";
	document.getElementById("letra").value = "";
	document.getElementById("mensaje1").innerHTML = "BIENVENIDO";
	document.getElementById('mensaje2').innerHTML = "5";
	cambiarDibujo(0);
}