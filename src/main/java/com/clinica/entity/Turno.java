package com.clinica.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Table(name="turnos")
@Entity
@Getter
@Setter
@ToString
public class Turno {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="odontologo_id", referencedColumnName="id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name="paciente_id", referencedColumnName="id", nullable = false)
    private Paciente paciente;

    private String fecha;
}




