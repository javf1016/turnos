package com.asesoftware.turnos.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "turnos")
@Data
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno")
    private Long idTurno;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio idServicio;
    @Column(name="fecha_turno")
    private LocalDate fechaTurno;
    @Column(name="hora_inicio")
    private LocalTime horaInicio;
    @Column(name="hora_fin")
    private LocalTime horaFin;
    private String estado;
}
