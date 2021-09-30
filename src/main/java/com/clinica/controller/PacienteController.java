package com.clinica.controller;

import com.clinica.entity.Paciente;
import com.clinica.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin("*")
public class PacienteController {

    private final static  Logger logger = Logger.getLogger("It's-a me, Mario!");

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/")
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        logger.debug("Registrando paciente nuevo");
        return ResponseEntity.ok(pacienteService.registrar(paciente));
    }

    @PutMapping("/")
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente) {
        if (pacienteService.getById(paciente.getId()).isPresent()) {
            logger.debug("Modificando paciente existente");
            pacienteService.registrar(paciente);
            return ResponseEntity.ok(paciente);
        }
        logger.debug("Falló la petición o el paciente no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> getById(@PathVariable Long id) {
        if (id != null) {
            logger.debug("Consultando paciente particular");
            return ResponseEntity.ok(pacienteService.getById(id));
        }
        logger.debug("Falló la petición o el paciente no existe");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Paciente>> getAll() {
        logger.debug("Consultando pacientes");
        return ResponseEntity.ok(pacienteService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(pacienteService.getById(id).isPresent()){
            logger.debug("Borrando paciente particular");
            pacienteService.borrar(id);
            return "El paciente con id " + id + " se ha eliminado con éxito ";
        }
        logger.debug("Falló la petición o el paciente no existe");
        return "No se encontró ningún paciente con id " + id;
    }

}
