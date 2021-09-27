package com.clinica.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "odontologos")
@Getter
@Setter
@ToString

public class Odontologo {

    @Id
    @GeneratedValue

    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

  // @OneToMany(mappedBy = "odontologo")
  // private Set<Paciente> pacientes;

    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;

}