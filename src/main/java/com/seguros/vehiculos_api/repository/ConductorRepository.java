package com.seguros.vehiculos_api.repository;
import com.seguros.vehiculos_api.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}