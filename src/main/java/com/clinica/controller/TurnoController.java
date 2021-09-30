package com.clinica.controller;



import com.clinica.entity.Turno;
import com.clinica.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin("*")
public class TurnoController {

    private Logger logger = Logger.getLogger("It's-a me, Mario!");

    @Autowired
    TurnoService turnoService;

    @PostMapping("/")
    public ResponseEntity<Turno> registrar(@RequestBody Turno turno) {
        logger.info("Registrando turno nuevo");
        return ResponseEntity.ok(turnoService.registrar(turno));
    }

    @PutMapping("/")
    public ResponseEntity<Turno> modificar(@RequestBody Turno turno) {
        if (turnoService.getById(turno.getId()).isPresent()) {
            logger.info("Modificando turno existente");
            turnoService.registrar(turno);
            return ResponseEntity.ok(turno);
        }
        logger.info("Falló la petición o el turno no existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> getById(@PathVariable Long id) {
        if (id != null) {
            logger.info("Consultando turno particular");
            return ResponseEntity.ok(turnoService.getById(id));
        }
        logger.info("Falló la petición o el turno no existe");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Turno>> getAll() {
        logger.info("Consultando turnos");
        return ResponseEntity.ok(turnoService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(turnoService.getById(id).isPresent()){
            logger.info("Borrando turno particular");
            turnoService.borrar(id);
            return "El turno con id " + id + " se ha eliminado con éxito ";
        }
        logger.info("Falló la petición o el turno no existe");
        return "No se encontro ningún turno con id " + id;
    }

}
