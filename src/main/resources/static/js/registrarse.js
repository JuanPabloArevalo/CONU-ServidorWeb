/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global apiclientRegistrarse */

var registrarse = (function(){
    
    var nombres;
    var apellidos;
    var telefono;
    var empresa;
    var direccion;
    var correo;
    
    return {
        registrarUsuario(){
            nombres = $("#nombre").val(); 
            apellidos = $("#apellido").val(); 
            telefono  = $("#telefono").val();
            empresa  = $("#empresa").val();
            direccion  = $("#direccion").val();
            correo  = $("#correo").val();
            var promesa = apiclientRegistrarse.adicionarUsuario(nombres,apellidos,telefono,empresa,direccion,correo); 
            promesa.then(
                function(){
                    alert("Se ha registrado correctamente en la base de datos");
//                    registrarse.inicializarDatos();
                },
                function(){
                    alert(promesa.responseText);
                 }
            );
        },
        inicializarDatos(){
            $("#nombre").val(""); 
            $("#apellido").val(""); 
            $("#telefono").val("");
            $("#empresa").val("");
            $("#direccion").val("");
            $("#correo").val("");
        }
    };
}());
