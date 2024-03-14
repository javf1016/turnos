package com.asesoftware.turnos.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comercios")
@Data
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comercio")
    private Long idComercio;

    @Column(name="nom_comercio")
    private String nomComercio;
    @Column(name="aforo_maximo")
    private int aforoMaximo;
}
