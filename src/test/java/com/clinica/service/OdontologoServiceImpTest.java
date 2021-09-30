package com.clinica.service;

import com.clinica.entity.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceImpTest {

    @Autowired
    OdontologoService odontologoService;
    private final static Logger logger = Logger.getLogger("");

    @Test
    public void registrarOdontologo() {
        logger.debug("Guardando odontologos en la base de datos");

        Odontologo odontologo = odontologoService.registrar(new Odontologo("Test", "Test", "1234"));
        Odontologo odontologo2 = odontologoService.registrar(new Odontologo("Test2", "Test2", "1234"));

        logger.debug("Corroborando que se generaron correctamente en la base de datos");
        assertTrue(odontologo.getId() > 0);
        assertEquals("Test", odontologo.getNombre());
        assertEquals("Test", odontologo.getApellido());
        assertEquals("1234", odontologo.getMatricula());
        assertEquals(null, odontologo.getTurnos());

        assertTrue(odontologo2.getId() > 0);
        assertEquals("Test2", odontologo2.getNombre());
        assertEquals("Test2", odontologo2.getApellido());
        assertEquals("1234", odontologo2.getMatricula());
        assertEquals(null, odontologo2.getTurnos());
    }

    @Test
    public void traerOdontologos(){
        odontologoService.registrar(new Odontologo("Test", "Test", "1234"));
        List<Odontologo> odontologos = odontologoService.getAll();

        logger.debug("Traigo la lista de odontologos y compruebo que su tamaño sea mayor a cero");
        assertTrue(odontologos.size() > 0, "Compruebo que ambos odontologos estén guardados en la base de datos");
    }

}