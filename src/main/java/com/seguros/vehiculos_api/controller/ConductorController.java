package com.seguros.vehiculos_api.controller;

import com.seguros.vehiculos_api.entity.Conductor;
import com.seguros.vehiculos_api.service.ConductorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class ConductorController {

    private final ConductorService service;

    public ConductorController(ConductorService service) {
        this.service = service;
    }

    // ➤ CREAR
    @PostMapping
    public Conductor crear(@RequestBody Conductor c) {
        return service.crearConductor(c);
    }

    // ➤ LISTAR
    @GetMapping
    public List<Conductor> listar() {
        return service.listarConductores();
    }

    // ➤ BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Conductor> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➤ ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Conductor> actualizar(@PathVariable Long id, @RequestBody Conductor c) {
        Conductor actualizado = service.actualizarConductor(id, c);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    // ➤ ELIMINAR (corregido)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.eliminarConductor(id);
        return ResponseEntity.noContent().build();
    }
}


