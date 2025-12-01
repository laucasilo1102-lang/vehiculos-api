package com.seguros.vehiculos_api.controller;

import com.seguros.vehiculos_api.entity.Seguro;
import com.seguros.vehiculos_api.service.SeguroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    private final SeguroService service;

    public SeguroController(SeguroService service) {
        this.service = service;
    }

    // ➤ 1. Listar todos los seguros
    @GetMapping
    public List<Seguro> listar() {
        return service.listarSeguros();
    }

    // ➤ 2. Buscar seguro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Seguro> obtener(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


    @GetMapping("/vehiculo/{idVehiculo}")
    public ResponseEntity<?> obtenerPorVehiculo(@PathVariable Long idVehiculo) {
        List<Seguro> seguros = service.obtenerSegurosPorVehiculo(idVehiculo);

        if (seguros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(seguros);
    }

    // ➤ 3. Crear un nuevo seguro
    @PostMapping
    public Seguro crear(@RequestBody Seguro seguro) {
        return service.crearSeguro(seguro);
    }


    // ➤ 4. Actualizar un seguro por ID
    @PutMapping("/{id}")
    public ResponseEntity<Seguro> actualizar(@PathVariable String id, @RequestBody Seguro seguro) {
        Seguro actualizado = service.actualizarSeguro(id, seguro);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    // ➤ 5. Eliminar un seguro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.eliminarSeguro(id);
        return ResponseEntity.noContent().build();
    }
}

