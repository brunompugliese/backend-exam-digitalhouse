package com.clinica.service;

import com.clinica.entity.Domicilio;
import com.clinica.entity.Paciente;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceImpTest {

    @Autowired
    PacienteService pacienteService;
    private final static Logger logger = Logger.getLogger("");

    @Test
    public void registrarPaciente() {
        logger.debug("Guardando pacientes en la base de datos");

        Paciente paciente = pacienteService.registrar(new Paciente("Test", "Test", "1234", "2021-09-30", new Domicilio("callao", "3517", "buenos aires")));
        Paciente paciente2 = pacienteService.registrar(new Paciente("Test2", "Test2", "1234", "2021-09-30", new Domicilio("pte. peron", "2000", "buenos aires")));

        logger.debug("Corroborando que se generaron correctamente en la base de datos");

        assertTrue(paciente.getId() > 0);
        assertEquals("Test", paciente.getNombre());
        assertEquals("Test", paciente.getApellido());
        assertEquals("1234", paciente.getDni());
        assertEquals("2021-09-30", paciente.getFechaAlta());
        assertEquals("callao", paciente.getDomicilio().getCalle());
        assertEquals("3517", paciente.getDomicilio().getNumero());
        assertEquals("buenos aires", paciente.getDomicilio().getProvincia());
        assertEquals(null, paciente.getTurnos());

        assertTrue(paciente2.getId() > 0);
        assertEquals("Test2", paciente2.getNombre());
        assertEquals("Test2", paciente2.getApellido());
        assertEquals("1234", paciente2.getDni());
        assertEquals("2021-09-30", paciente2.getFechaAlta());
        assertEquals("pte. peron", paciente2.getDomicilio().getCalle());
        assertEquals("2000", paciente2.getDomicilio().getNumero());
        assertEquals("buenos aires", paciente2.getDomicilio().getProvincia());
        assertEquals(null, paciente2.getTurnos());
    }

    @Test
    public void traerOdontologos(){
        logger.debug("Guardando pacientes en la base de datos");

        pacienteService.registrar(new Paciente("Test", "Test", "1234", "2021-09-30", new Domicilio("callao", "3517", "buenos aires")));
        pacienteService.registrar(new Paciente("Test2", "Test2", "1234", "2021-09-30", new Domicilio("pte. peron", "2000", "buenos aires")));
        List<Paciente> pacientes = pacienteService.getAll();

        logger.debug("Traigo la lista de pacientes y compruebo que su tamaño sea mayor a cero");
        assertTrue(pacientes.size() > 0, "Compruebo que los pacientes estén guardados en la base de datos");
    }

}