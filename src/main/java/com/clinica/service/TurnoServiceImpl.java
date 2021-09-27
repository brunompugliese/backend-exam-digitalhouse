package com.clinica.service;

import com.clinica.entity.Turno;
import com.clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public Turno registrar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public List<Turno> getAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno modificar(Turno turno) {
        if(turnoRepository.getById(turno.getId()) != null) {
            return turnoRepository.save(turno);
        }
        return null;
    }

    @Override
    public void borrar(Long id) {
        turnoRepository.delete(turnoRepository.getById(id));
    }

    @Override
    public Optional<Turno> getById(Long id) {
        return turnoRepository.findById(id);
    }
}
