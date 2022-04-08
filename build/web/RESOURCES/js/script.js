function validarFormRegister() {
    var nombre= document.getElementById("txtNombres").value;
    var apellido = document.getElementById("txtApellidos").value;
    var usuario = document.getElementById("txtUsuario").value;
    var correo= document.getElementById("txtCorreo").value;
    var clave1= document.getElementById("txtClave1").value;
    var clave2= document.getElementById("txtClave2").value;
    
    if (nombre === "" || nombre.length === 0) {
        document.getElementById("mensaje1").style.display = "block";
        document.getElementById("mensaje1").style.color = "red";
        document.getElementById("mensaje1").innerHTML = "Complete sus nombres";
        return false;
    }
    else if (apellido === "" || apellido.length === 0) {
        document.getElementById("mensaje2").style.display = "block";
        document.getElementById("mensaje2").style.color = "red";
        document.getElementById("mensaje2").innerHTML = "Complete sus apellidos";
        return false;
    }
    else if (usuario === "" || usuario.length === 0) {
        document.getElementById("mensaje3").style.display = "block";
        document.getElementById("mensaje3").style.color = "red";
        document.getElementById("mensaje3").innerHTML = "Debe ingresar un nombre de usuario";
        return false;
    }
    else if (correo === "" || correo.length === 0) {
        document.getElementById("mensaje4").style.display = "block";
        document.getElementById("mensaje4").style.color = "red";
        document.getElementById("mensaje4").innerHTML = "Debe ingresar un correo";
        return false;
    }
    else if (clave1 === "" || clave1.length === 0) {
        document.getElementById("mensaje5").style.display = "block";
        document.getElementById("mensaje5").style.color = "red";
        document.getElementById("mensaje5").innerHTML = "Debe ingresar una contraseña";
        return false;
    }
    else if (clave1 === "" || clave2.length === 0 || clave1 !== clave2) {
        document.getElementById("mensaje6").style.display = "block";
        document.getElementById("mensaje6").style.color = "red";
        document.getElementById("mensaje6").innerHTML = "Las contraseñas deben coincidir";
        return false;
    }
}

function validarFormLogin() {
    var usuario = document.getElementById("txtUsuario").value;
    var clave1= document.getElementById("txtClave1").value;
    
    if (usuario === "" || usuario.length === 0) {
        document.getElementById("mensaje1").style.display = "block";
        document.getElementById("mensaje1").style.color = "red";
        document.getElementById("mensaje1").innerHTML = "Ingrese nombre de Usuario";
        return false;
    }
    
    else if (clave1 === "" || clave1.length === 0) {
        document.getElementById("mensaje2").style.display = "block";
        document.getElementById("mensaje2").style.color = "red";
        document.getElementById("mensaje2").innerHTML = "Ingrese su contraseña";
        return false;
    }
}

function ocultar() {
    document.getElementById("mensaje1").style.display = "none";
    document.getElementById("mensaje2").style.display = "none";
    document.getElementById("mensaje3").style.display = "none";
    document.getElementById("mensaje4").style.display = "none";
    document.getElementById("mensaje5").style.display = "none";
    document.getElementById("mensaje6").style.display = "none";
}

function showTime(){
fecha = new Date();
hora = fecha.getHours();
minuto = fecha.getMinutes();
if (hora < 10) hora = 0 + hora;
if (minuto < 10) minuto = "0" + minuto;
document.getElementById('fechaHora').innerHTML= time;
}