package com.seguros.vehiculos_api.service.impl;

import com.seguros.vehiculos_api.entity.Conductor;
import com.seguros.vehiculos_api.repository.ConductorRepository;
import com.seguros.vehiculos_api.service.ConductorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService {

    private final ConductorRepository repo;

    public ConductorServiceImpl(ConductorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Conductor crearConductor(Conductor c) {
        return repo.save(c);
    }

    @Override
    public List<Conductor> listarConductores() {
        return repo.findAll();
    }

    @Override
    public Optional<Conductor> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Conductor actualizarConductor(Long id, Conductor conductor) {
        if (!repo.existsById(id)) return null;
        conductor.setIdConductor(id);
        return repo.save(conductor);
    }

    @Override
    public void eliminarConductor(Long id) {
        repo.deleteById(id);
    }
}

