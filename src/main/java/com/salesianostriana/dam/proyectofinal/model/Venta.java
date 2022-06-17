package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {

	private double precioTotal;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCompra;

	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "venta", fetch = FetchType.EAGER)
	private List<LineaVenta> lineas = new ArrayList<>();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String comprador;
}
