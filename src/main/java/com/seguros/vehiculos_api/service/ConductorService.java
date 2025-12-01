package com.seguros.vehiculos_api.service;

import com.seguros.vehiculos_api.entity.Conductor;

import java.util.List;
import java.util.Optional;

public interface ConductorService {

    Conductor crearConductor(Conductor c);

    List<Conductor> listarConductores();

    Optional<Conductor> buscarPorId(Long id);

    Conductor actualizarConductor(Long id, Conductor conductor);

    void eliminarConductor(Long id);
}

