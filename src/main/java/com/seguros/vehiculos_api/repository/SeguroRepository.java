package com.seguros.vehiculos_api.repository;

import com.seguros.vehiculos_api.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeguroRepository extends JpaRepository<Seguro, String> {
    List<Seguro> findByVehiculoIdVehiculo(Long idVehiculo);

}

