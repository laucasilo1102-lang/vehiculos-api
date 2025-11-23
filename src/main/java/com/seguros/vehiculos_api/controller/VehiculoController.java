package com.seguros.vehiculos_api.controller;

import com.seguros.vehiculos_api.entity.Vehiculo;
import com.seguros.vehiculos_api.service.VehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehiculo> getAll() {
        return service.listarVehiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehiculo create(@RequestBody Vehiculo v) {
        return service.crearVehiculo(v);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> update(@PathVariable Long id, @RequestBody Vehiculo v) {
        Vehiculo actualizado = service.actualizarVehiculo(id, v);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }
}
