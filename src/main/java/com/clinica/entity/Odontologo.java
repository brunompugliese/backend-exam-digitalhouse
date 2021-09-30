package com.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}