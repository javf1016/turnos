package com.asesoftware.turnos.Repository;

import com.asesoftware.turnos.Entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

}
