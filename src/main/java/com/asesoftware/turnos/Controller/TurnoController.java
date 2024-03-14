package com.asesoftware.turnos.Controller;

import com.asesoftware.turnos.Entity.Turno;
import com.asesoftware.turnos.Service.TurnoService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/generar")
    public ResponseEntity<List<Turno>> generarTurnos(@RequestBody JsonNode requestBody) {
        // Extraer los parámetros del cuerpo de la solicitud JSON
        LocalDate fechaInicio = LocalDate.parse(requestBody.get("fechaInicio").asText());
        LocalDate fechaFin = LocalDate.parse(requestBody.get("fechaFin").asText());
        Integer idServicio = requestBody.get("idServicio").asInt();
System.out.println("el valor del id es "+idServicio);
        System.out.println("el valor del tipo del id es "+idServicio.getClass());
        // Llamar al servicio para generar los turnos
        List<Turno> turnosGenerados = turnoService.generarTurnos(fechaInicio, fechaFin, idServicio);

        // Retornar la lista de turnos generados en la respuesta
        return new ResponseEntity<>(turnosGenerados, HttpStatus.CREATED);
    }


}
