package com.seguros.vehiculos_api.service.impl;

import com.seguros.vehiculos_api.entity.Seguro;
import com.seguros.vehiculos_api.entity.Vehiculo;
import com.seguros.vehiculos_api.repository.SeguroRepository;
import com.seguros.vehiculos_api.repository.VehiculoRepository;
import com.seguros.vehiculos_api.service.SeguroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroServiceImpl implements SeguroService {

    private final SeguroRepository repo;
    private final VehiculoRepository vehiculoRepo;

    public SeguroServiceImpl(SeguroRepository repo, VehiculoRepository vehiculoRepo) {
        this.repo = repo;
        this.vehiculoRepo = vehiculoRepo;
    }

    @Override
    public Seguro crearSeguro(Seguro seguro) {

        // 1️⃣ Buscar el vehículo usando el idVehiculo que viene en el JSON
        Vehiculo vehiculo = vehiculoRepo.findById(seguro.getIdVehiculo())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        // 2️⃣ Asignarlo al seguro
        seguro.setVehiculo(vehiculo);

        // 3️⃣ Guardar
        return repo.save(seguro);
    }

    @Override
    public List<Seguro> listarSeguros() {
        return repo.findAll();
    }

    @Override
    public Optional<Seguro> buscarPorId(String id) {
        return repo.findById(id);
    }

    @Override
    public Seguro actualizarSeguro(String id, Seguro seguro) {

        if (!repo.existsById(id)) {
            return null;
        }

        // 1️⃣ Buscar vehículo actualizado
        Vehiculo vehiculo = vehiculoRepo.findById(seguro.getIdVehiculo())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        // 2️⃣ Ajustar id y vehículo
        seguro.setIdSeguro(id);
        seguro.setVehiculo(vehiculo);

        // 3️⃣ Actualizar
        return repo.save(seguro);
    }

    @Override
    public void eliminarSeguro(String id) {
        repo.deleteById(id);
    }
    @Override
    public List<Seguro> obtenerSegurosPorVehiculo(Long idVehiculo) {
        return repo.findByVehiculoIdVehiculo(idVehiculo);
    }

}
