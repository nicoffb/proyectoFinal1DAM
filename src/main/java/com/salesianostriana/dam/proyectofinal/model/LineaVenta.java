package com.salesianostriana.dam.proyectofinal.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LineaVenta {
	
	@ManyToOne
	private Producto videojuego;
	
	private int cantidad;
	private double precioUnitario;
	
	//esto debe estar aqui? una linea de venta crea un objeto venta?
	@ManyToOne
	private Venta venta;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	

}
