package com.seguros.vehiculos_api.service;

import com.seguros.vehiculos_api.entity.Seguro;

import java.util.List;
import java.util.Optional;

public interface SeguroService {

    Seguro crearSeguro(Seguro seguro);

    List<Seguro> obtenerSegurosPorVehiculo(Long idVehiculo);

    List<Seguro> listarSeguros();

    Optional<Seguro> buscarPorId(String id);

    Seguro actualizarSeguro(String id, Seguro seguro);

    void eliminarSeguro(String id);
}


