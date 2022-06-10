package com.salesianostriana.dam.proyectofinal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.LineaVentaRepository;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Inicio {
	@Autowired
	private  ProductoRepository productoRepository;
	

	@PostConstruct

	public void run() {
		
		Producto p = Producto.builder()
				.nombre("God of war")
				.descripcion("Siéntete como un dios en está épica aventura en la que te sumergiras de lleno en la cultura y mitología nórdica")
				.pvp(29.99)
				.descuento(50)
				.imagen("https://d1x7zurbps6occ.cloudfront.net/product/xlarge/756271-203321.jpg")
				.build();
		productoRepository.save(p);
		
		

		Producto p2 = Producto.builder()
				.nombre("Jedi The Fallen Order")
				.descripcion("Embárcate con tu sable láser en una historia digna de la mítica saga de Star Wars")
				.pvp(16.99)
				.descuento(30)
				.imagen("https://static.wikia.nocookie.net/esstarwars/images/5/57/Fallen-Order-Box-Art.jpg")
				.build();
		productoRepository.save(p2);
		

		Producto p3 = Producto.builder()
				.nombre("The Legend of Zelda")
				.descripcion("Link despierta tras un profundo sueño de 100 años en un misterioso templo en el reino de Hyrule; junto a él, deberemos descubrir su pasado mientras escuchamos una voz que nos incita a enfrentarnos a un malvado ser que provocó el llamado cataclismo: Ganon.")
				.pvp(59.99)
				.descuento(0)
				.imagen("https://www.zelda.com/breath-of-the-wild/assets/media/wallpapers/tablet-1.jpg")
				.build();
		productoRepository.save(p3);
		
	}
	//hacer esto con los 3 productos
	//me da error en que no tiene id , tiene q ser floato o double?
}




		