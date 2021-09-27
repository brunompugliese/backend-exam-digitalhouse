package com.clinica.service;

import com.clinica.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {

    Turno registrar(Turno turno);
    List<Turno> getAll();
    Turno modificar(Turno turno);
    void borrar(Long id);
    Optional<Turno> getById(Long id);

}
