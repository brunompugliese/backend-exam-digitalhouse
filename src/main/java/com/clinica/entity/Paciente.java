package com.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name="pacientes")
@Entity
@Getter
@Setter
@ToString

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaAlta;

   @JsonIgnore
    @OneToOne(mappedBy = "paciente")
    private Domicilio domilicio;

   @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;
}
