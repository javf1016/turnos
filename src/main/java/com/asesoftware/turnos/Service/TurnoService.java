package com.asesoftware.turnos.Service;

import com.asesoftware.turnos.Entity.Turno;
import com.asesoftware.turnos.Repository.TurnoCustomRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TurnoService {
    private final TurnoCustomRepository turnoCustomRepository;

    @Autowired
    public TurnoService(TurnoCustomRepository turnoCustomRepository) {
        this.turnoCustomRepository = turnoCustomRepository;
    }


    public List<Turno> generarTurnos(LocalDate fechaInicio, LocalDate fechaFin, Integer idServicio) {
        try {
            List<Turno> turnosGenerados = new ArrayList<>();
            return turnoCustomRepository.generarTurnos(fechaInicio, fechaFin, idServicio);
        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace();
            // Lanza una excepción personalizada o maneja el error de otra manera si es necesario
            throw new ServiceException("Error al generar los turnos", e);
        }
    }

}
