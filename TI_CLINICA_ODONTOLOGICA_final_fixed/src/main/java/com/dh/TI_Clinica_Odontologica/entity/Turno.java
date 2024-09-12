package com.dh.TI_Clinica_Odontologica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.FetchType;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación ManyToOne con Odontologo
    @ManyToOne(fetch = FetchType.EAGER)
    private Odontologo odontologo;

    // Relación ManyToOne con Paciente
    @ManyToOne(fetch = FetchType.EAGER)
    private Paciente paciente;

    // Fecha del turno
    private LocalDate fecha;
}
