package com.clinica.controller;

import com.clinica.entity.Odontologo;
import com.clinica.service.OdontologoService;
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

    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/")
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.registrar(odontologo));
    }

    @PutMapping("/")
    public ResponseEntity<Odontologo> modificar(@RequestBody Odontologo odontologo) {
        if (odontologoService.getById(odontologo.getId()).isPresent()) {
            odontologoService.registrar(odontologo);
            return ResponseEntity.ok(odontologo);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(odontologoService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> getAll() {
        return ResponseEntity.ok(odontologoService.getAll());
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){
        if(odontologoService.getById(id).isPresent()){
            odontologoService.borrar(id);
            return "El odontólogo con id " + id + " se ha eliminado con éxito ";
        }
        return "No se encontro ningún odontologo con id " + id;
    }

}
