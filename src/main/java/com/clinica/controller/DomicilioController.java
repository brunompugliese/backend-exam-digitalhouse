package com.clinica.controller;

import com.clinica.entity.Domicilio;
import com.clinica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/domicilios")
@CrossOrigin("*")
public class DomicilioController {

    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/")
    public ResponseEntity<Domicilio> registrar(@RequestBody Domicilio domicilio) {
        return ResponseEntity.ok(domicilioService.registrar(domicilio));
    }

    @PutMapping("/")
    public ResponseEntity<Domicilio> modificar(@RequestBody Domicilio domicilio) {
        if (domicilioService.getById(domicilio.getId()).isPresent()) {
            domicilioService.registrar(domicilio);
            return ResponseEntity.ok(domicilio);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Domicilio>> getById(@PathVariable Long id){
        return ResponseEntity.ok(domicilioService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Domicilio>> getAll() {
        return ResponseEntity.ok(domicilioService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(domicilioService.getById(id).isPresent()){
            domicilioService.borrar(id);
            return "El domicilio con id " + id +  " se ha eliminado con éxito ";
        }
        return "No se encontro ningun domicilio con id " + id;
    }
}