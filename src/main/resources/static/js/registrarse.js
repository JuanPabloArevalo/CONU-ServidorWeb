/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global apiclientRegistrarse */

var registrarse = (function () {

    var nombres;
    var apellidos;
    var telefono;
    var empresa;
    var direccion;
    var correo;
    function inicializarElementos() {
        $(".filas").remove("tr");
    }

    function adicionarFila(item) {
        var markup = "<tr class=\"filas\"><td>" + item.nombres + "</td><td>" + item.apellidos + "</td><td>" + item.telefono + "</td><td>" + item.empresa + "</td><td>" + item.direccion + "</td><td>" + item.correo + "</td></tr>";
        $("table tbody").append(markup);
    }
    return {
        registrarUsuario() {
            nombres = $("#nombre").val();
            apellidos = $("#apellido").val();
            telefono = $("#telefono").val();
            empresa = $("#empresa").val();
            direccion = $("#direccion").val();
            correo = $("#correo").val();
            var promesa = apiclientRegistrarse.adicionarUsuario(nombres, apellidos, telefono, empresa, direccion, correo);
            promesa.then(
                    function () {
                        registrarse.inicializarDatos();
                        alert("Se ha registrado correctamente en la base de datos");
//                    registrarse.inicializarDatos();
                    },
                    function (dato) {
                        alert(dato.responseJSON.message);
                    }
            );
        },
        inicializarDatos() {
            $("#nombre").val("");
            $("#apellido").val("");
            $("#telefono").val("");
            $("#empresa").val("");
            $("#direccion").val("");
            $("#correo").val("");
        },
        cargar(){
            var promesaConsulta = apiclientRegistrarse.getUsuarios();
            promesaConsulta.then(
                    function (datos) {
                        inicializarElementos();
                        datos.map(adicionarFila);
                    },
                    function (dato) {
                        alert(dato.responseJSON.message);
                    }
            );
        }
    };
}());
