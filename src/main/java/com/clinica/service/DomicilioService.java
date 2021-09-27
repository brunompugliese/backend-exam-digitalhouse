package com.clinica.service;

import com.clinica.entity.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {

    Domicilio registrar(Domicilio domicilio);
    List<Domicilio> getAll();
    Domicilio modificar(Domicilio domicilio);
    void borrar(Long id);
    Optional<Domicilio> getById(Long id);
}
