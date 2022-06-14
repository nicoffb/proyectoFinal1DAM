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
	//como hago para que correlacione?
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCompra;
	
	@Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="venta", fetch = FetchType.EAGER)
    private List<LineaVenta> lineas = new ArrayList<>();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String comprador;
}

//recuerda que para el admin debe salir editar y borrar , al usuario solo la opcion comprar dle carrito
//puedes redireccionar despues del carrito a pagar un total
// poner en la clase service el mapa y poner en Producto un objeto Service? es que no entiendo como vincular el mapa
//depende de como te logueas si eres admin o user ves mas o menos cosas , le quitas dos menus y ya eres user
//donde se mete lo de user y admin?


