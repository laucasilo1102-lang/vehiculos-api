package com.seguros.vehiculos_api.service;

import com.seguros.vehiculos_api.entity.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehiculoService {

    Vehiculo crearVehiculo(Vehiculo vehiculo);

    List<Vehiculo> listarVehiculos();

    Optional<Vehiculo> buscarPorId(Long id);

    Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculo);

    void eliminarVehiculo(Long id);
}
