package com.clinica.service;

import com.clinica.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    Paciente registrar(Paciente paciente);
    List<Paciente> getAll();
    Paciente modificar(Paciente paciente);
    void borrar(Long id);
    Optional<Paciente> getById(Long id);
}
