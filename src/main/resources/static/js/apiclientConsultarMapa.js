/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var apiclientConsultarMapa=(function(){
	return {
            getAllReportesPublicados(callback){
                return $.get("/sharingweather/V1/reportesClima/publicados",callback); 
            },
            getAllRegionesFavoritas(loginUsuario){
                return $.ajax({
                    url: "/sharingweather/V1/regionesFavoritas/"+loginUsuario,
                    type: "GET",
                    contentType: "application/json"
                });
            }
	};	

}());

