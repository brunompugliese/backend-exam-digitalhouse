package com.clinica.controller;

import com.clinica.entity.Paciente;
import com.clinica.service.PacienteService;
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

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/")
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.registrar(paciente));
    }

    @PutMapping("/")
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente) {
        if (pacienteService.getById(paciente.getId()).isPresent()) {
            pacienteService.registrar(paciente);
            return ResponseEntity.ok(paciente);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> getById(@PathVariable Long id) {
        if (id != null) {
            return ResponseEntity.ok(pacienteService.getById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Paciente>> getAll() {
        return ResponseEntity.ok(pacienteService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(pacienteService.getById(id).isPresent()){
            pacienteService.borrar(id);
            return "El paciente con id " + id + " se ha eliminado con éxito ";
        }
        return "No se encontró ningún paciente con id " + id;
    }

}
