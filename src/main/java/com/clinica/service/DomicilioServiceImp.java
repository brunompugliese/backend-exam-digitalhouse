package com.clinica.service;

import com.clinica.entity.Domicilio;
import com.clinica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImp implements DomicilioService{

    @Autowired
    DomicilioRepository domicilioRepository;

    @Override
    public Domicilio registrar(Domicilio domicilio) {
        if(domicilio != null){
            return domicilioRepository.save(domicilio);
        }
        return null;
    }

    @Override
    public List<Domicilio> getAll() {
        return domicilioRepository.findAll();
    }


    @Override
    public Domicilio modificar(Domicilio domicilio) {
        if(domicilioRepository.getById(domicilio.getId()) != null) {
            return domicilioRepository.save(domicilio);
        }
        return null;
    }

    @Override
    public void borrar(Long id) {
        domicilioRepository.delete(domicilioRepository.getById(id));
    }

    @Override
    public Optional<Domicilio> getById(Long id) {
        return domicilioRepository.findById(id);
    }
}
