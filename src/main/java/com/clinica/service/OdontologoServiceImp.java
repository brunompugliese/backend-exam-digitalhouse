package com.clinica.service;

import com.clinica.entity.Odontologo;
import com.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImp implements OdontologoService{

    @Autowired
    OdontologoRepository odontologoRepository;

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        if(odontologo != null){
            return odontologoRepository.save(odontologo);
        }
        return null;
    }

    @Override
    public List<Odontologo> getAll() {
        return  odontologoRepository.findAll();
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        if(odontologoRepository.getById(odontologo.getId()) != null) {
            return odontologoRepository.save(odontologo);
        }
        return null;
    }

    @Override
    public void borrar(Long id) {
        odontologoRepository.delete(odontologoRepository.getById(id));
    }

    @Override
    public Optional<Odontologo> getById(Long id) {
        return odontologoRepository.findById(id);
    }
}
