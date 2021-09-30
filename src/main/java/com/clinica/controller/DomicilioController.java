package com.clinica.controller;

import com.clinica.entity.Domicilio;
import com.clinica.service.DomicilioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/domicilios")
@CrossOrigin("*")
public class DomicilioController {

    @Autowired
    DomicilioService domicilioService;
    private Logger logger = Logger.getLogger("It's-a me, Mario!");

    @PostMapping("/")
    public ResponseEntity<Domicilio> registrar(@RequestBody Domicilio domicilio) {
        logger.info("Registrando nuevo domicilio");
        return ResponseEntity.ok(domicilioService.registrar(domicilio));
    }

    @PutMapping("/")
    public ResponseEntity<Domicilio> modificar(@RequestBody Domicilio domicilio) {
        if (domicilioService.getById(domicilio.getId()).isPresent()) {
            logger.info("Modificando domicilio existente");
            domicilioService.registrar(domicilio);
            return ResponseEntity.ok(domicilio);
        }
        logger.debug("Falló la petición o el domicilio no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> getById(@RequestBody Domicilio domicilio){
        if (domicilioService.getById(domicilio.getId()).isPresent()) {
            logger.info("Modificando domicilio existente");
            domicilioService.registrar(domicilio);
            return ResponseEntity.ok(domicilio);
        }
        logger.info("Falló la petición o el domicilio no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Domicilio>> getAll() {
        logger.info("Consultando domicilios");
        return ResponseEntity.ok(domicilioService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(domicilioService.getById(id).isPresent()){
            logger.info("Borrando domicilio particular");
            domicilioService.borrar(id);
            return "El domicilio con id " + id +  " se ha eliminado con éxito ";
        }
        logger.debug("Falló la petición o el domicilio no existe");
        return "No se encontro ningun domicilio con id " + id;
    }
}