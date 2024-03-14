package com.asesoftware.turnos.Repository;

import com.asesoftware.turnos.Entity.Turno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Repository
public class TurnoCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    public List<Turno> generarTurnos(LocalDate fechaInicio, LocalDate fechaFin, Integer idServicio) {
        try {
            // Obtener una conexión desde el DataSource
            Connection connection = dataSource.getConnection();

            // Llamar al procedimiento almacenado
            String call = "{call generar_turnos(?, ?, ?)}";
            CallableStatement cstmt = connection.prepareCall(call);

            // Configurar los parámetros
            cstmt.setDate(1, java.sql.Date.valueOf(fechaInicio));
            cstmt.setDate(2, java.sql.Date.valueOf(fechaFin));
            cstmt.setInt(3, idServicio);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            // Cerrar la conexión
            connection.close();

            // Obtener los turnos generados
            return obtenerTurnosGenerados(fechaInicio, fechaFin, idServicio);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }



    private List<Turno> obtenerTurnosGenerados(LocalDate fechaInicio, LocalDate fechaFin, Integer idServicio) {
        return Collections.emptyList();
    }
}
