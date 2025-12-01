package com.seguros.vehiculos_api.service.impl;

import com.seguros.vehiculos_api.entity.Vehiculo;
import com.seguros.vehiculos_api.repository.VehiculoRepository;
import com.seguros.vehiculos_api.service.VehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository repo;

    public VehiculoServiceImpl(VehiculoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return repo.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listarVehiculos() {
        return repo.findAll();
    }

    @Override
    public Optional<Vehiculo> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculo) {
        if (!repo.existsById(id)) {
            return null;  // o lanzar excepción si prefieres
        }
        vehiculo.setIdVehiculo(id);
        return repo.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(Long id) {
        repo.deleteById(id);
    }
}
