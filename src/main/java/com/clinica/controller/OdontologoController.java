package com.clinica.controller;

import com.clinica.entity.Odontologo;
import com.clinica.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/odontologos")
@CrossOrigin("*")
public class OdontologoController {

    private final static  Logger logger = Logger.getLogger("It's-a me, Mario!");
    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/")
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo) {
        logger.debug("Registrando odontólogo nuevo");
        return ResponseEntity.ok(odontologoService.registrar(odontologo));
    }

    @PutMapping("/")
    public ResponseEntity<Odontologo> modificar(@RequestBody Odontologo odontologo) {
        if (odontologoService.getById(odontologo.getId()).isPresent()) {
            logger.debug("Modificando odontólogo existente");
            odontologoService.registrar(odontologo);
            return ResponseEntity.ok(odontologo);
        }
        logger.debug("Falló la petición o el odontólogo no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> getById(@PathVariable Long id) {
        if (id != null) {
            logger.debug("Consultando odontólogo particular");
            return ResponseEntity.ok(odontologoService.getById(id));
        }
        logger.debug("Falló la petición o el odontologo no existe");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> getAll() {
        logger.debug("Consultando odontólogos");
        return ResponseEntity.ok(odontologoService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(odontologoService.getById(id).isPresent()){
            logger.debug("Borrando odontólogo particular");
            odontologoService.borrar(id);
            return "El odontólogo con id " + id + " se ha eliminado con éxito ";
        }
        logger.debug("Falló la petición o el odontólogo no existe");
        return "No se encontro ningún odontologo con id " + id;
    }

}
