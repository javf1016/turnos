package com.asesoftware.turnos.Entity;

import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicios")
@Data
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio")
    private Long idServicio;

    @ManyToOne
    @JoinColumn(name="id_comercio")
    private Comercio idComercio;
    @Column(name="nom_servicio")
    private String nomServicio;
    @Column(name="hora_apertura")
    private LocalTime horaApertura;
    @Column(name="hora_cierre")
    private LocalTime horaCierre;
    private int duracion;
}
