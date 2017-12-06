/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conu.conuwebserver;

import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping(value = "/")
public class Controller {

    @RequestMapping(path = "/vitrina", method = RequestMethod.POST)
    public ResponseEntity<?> crearRegistro(@RequestBody Vitrina vitrina) {
        System.out.println("conu.conuwebserver.Controller.manejadorPostRecursoAdicionarReporteClima()" + vitrina.getApellidos() + ". " + vitrina.getCorreo());
        try {
            vitrina.insertar();
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/vitrina", method = RequestMethod.GET)
    public ResponseEntity<?> getRegistros() {
        try {
            return new ResponseEntity<>(Vitrina.getAll(), HttpStatus.ACCEPTED);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
