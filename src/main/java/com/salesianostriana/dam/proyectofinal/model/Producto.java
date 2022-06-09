package com.salesianostriana.dam.proyectofinal.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
	
	
	private String nombre;
	@Lob
	private String descripcion;
	private String imagen;
	private double pvp;
	private double descuento;
	@Id
	@Column(name = "id")
	@SequenceGenerator(initialValue=500, 
	                   allocationSize=1,
	                        name = "id", 
	                        sequenceName="id")
	@GeneratedValue(generator="id")
	private long id;
	 
	 
		//@Id
		//@GeneratedValue(strategy=GenerationType.AUTO)
	
		
	
	
}
