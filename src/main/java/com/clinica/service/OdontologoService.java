package com.clinica.service;

import com.clinica.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {

   Odontologo registrar(Odontologo odontologo);
    List<Odontologo> getAll();
    Odontologo modificar(Odontologo odontologo);
    void borrar(Long id);
    Optional<Odontologo> getById(Long id);
}
