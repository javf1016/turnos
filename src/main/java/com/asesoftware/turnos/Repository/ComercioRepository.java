package com.asesoftware.turnos.Repository;

import com.asesoftware.turnos.Entity.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Long> {

}
