package com.clinica.service;

import com.clinica.entity.Domicilio;
import com.clinica.entity.Odontologo;
import com.clinica.entity.Paciente;
import com.clinica.entity.Turno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceImplTest {

    @Autowired
    TurnoService turnoService;
    private final static Logger logger = Logger.getLogger("");

    @Autowired
    OdontologoService odontologoService;

    @Autowired
    PacienteService pacienteService;

    @Test
    public void registrarTurno(){

        Paciente paciente = pacienteService.registrar(new Paciente("PacTest", "PacTest", "1234", "2021-09-21", new Domicilio("callao", "3517", "buenos aires")));
        Odontologo odontologo = odontologoService.registrar(new Odontologo("OdonTest", "OdonTest", "123456"));
        Turno turno = turnoService.registrar(new Turno(odontologo, paciente, "2021-10-12"));

        assertEquals("2021-10-12", turno.getFecha());

        assertEquals("OdonTest", turno.getOdontologo().getNombre());
        assertEquals("OdonTest", turno.getOdontologo().getApellido());

        assertEquals("PacTest", turno.getPaciente().getNombre());
        assertEquals("PacTest", turno.getPaciente().getApellido());

    }
}