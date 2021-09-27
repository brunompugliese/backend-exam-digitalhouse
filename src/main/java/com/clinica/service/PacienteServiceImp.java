package com.clinica.service;

import com.clinica.entity.Paciente;
import com.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImp implements PacienteService{

    @Autowired
    PacienteRepository  pacienteRepository;

    @Override
    public Paciente registrar(Paciente paciente) {
        return   pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> getAll() {
        return   pacienteRepository.findAll();
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        if( pacienteRepository.getById(paciente.getId()) != null) {
            return  pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public void borrar(Long id) {
        pacienteRepository.delete(pacienteRepository.getById(id));
    }

    @Override
    public Optional<Paciente> getById(Long id) {
        return pacienteRepository.findById(id);
    }
}
