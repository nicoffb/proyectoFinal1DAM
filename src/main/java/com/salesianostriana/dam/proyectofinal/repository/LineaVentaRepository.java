package com.salesianostriana.dam.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;

@Repository
public interface LineaVentaRepository extends JpaRepository<LineaVenta, Long> {

}