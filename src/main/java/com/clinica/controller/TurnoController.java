package com.clinica.controller;



import com.clinica.entity.Turno;
import com.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin("*")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @PostMapping("/")
    public ResponseEntity<Turno> registrar(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.registrar(turno));
    }

    @PutMapping("/")
    public ResponseEntity<Turno> modificar(@RequestBody Turno turno) {
        if (turnoService.getById(turno.getId()).isPresent()) {
            turnoService.registrar(turno);
            return ResponseEntity.ok(turno);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Turno>> getAll() {
        return ResponseEntity.ok(turnoService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(turnoService.getById(id).isPresent()){
            turnoService.borrar(id);
            return "El paciente con id " + id + " se ha eliminado con éxito ";
        }
        return "No se encontro ningún paciente con id " + id;
    }

}
