package com.clinica.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name="domicilios")
@Entity
@Getter
@Setter
@ToString
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String numero;
    private String provincia;

    @OneToOne
    @JoinColumn(name= "paciente_id", referencedColumnName = "id", nullable =false)
    private Paciente paciente;
}
