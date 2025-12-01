package com.seguros.vehiculos_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;

    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String color;

    // Relación con Conductor
    @OneToOne
    @JoinColumn(name = "idConductor")
    private Conductor conductor;

    // Relación con Seguros (con JsonIgnore para evitar JSON infinito)
    @JsonIgnore
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Seguro> seguros;

    // GETTERS Y SETTERS
    public Long getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(Long idVehiculo) { this.idVehiculo = idVehiculo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }

    public List<Seguro> getSeguros() { return seguros; }
    public void setSeguros(List<Seguro> seguros) { this.seguros = seguros; }
}
