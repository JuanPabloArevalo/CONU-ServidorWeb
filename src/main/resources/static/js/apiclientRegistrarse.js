/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var apiclientRegistrarse = (function(){
    
    return{
        getUsuarios(){
            return $.get("/vitrina"); 
        },
        adicionarUsuario(nombres,apellidos,telefono,empresa,direccion,correo){
            return $.ajax({
                url: "/vitrina",
                type: "POST",
                data: '{"nombres":"'+nombres+'","apellidos":"'+apellidos+'", "telefono":"'+telefono+'", "empresa":"'+empresa+'","direccion":"'+direccion+'","correo":"'+correo+'"}',
                contentType: "application/json"
            });
        }
    };
    
}());