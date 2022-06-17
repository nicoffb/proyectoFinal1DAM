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
				.nombre("Nier Automata")
				.descripcion("En un futuro distante, los invasores de otro mundo lanzan un ataque bajo una nueva amenaza: un arma mitad organismo vivo, mitad máquina. A la vista de este suceso, los humanos son conducidos a abandonar el planeta Tierra y buscar refugio en la Luna. Tras los acontecimientos, el Consejo de la Humanidad organiza una resistencia formada por soldados androide en un esfuerzo por recuperar su planeta natal, desplegando una nueva unidad de infantería llamada YoRHa.")
				.pvp(9.99)
				.descuento(50)
				.imagen("https://image.api.playstation.com/cdn/EP0082/CUSA04480_00/P4ZghxHW2EEiwxim3ZZIG28aJB8LgebN.png")
				.build();
		productoRepository.save(p);
		
		

		Producto p2 = Producto.builder()
				.nombre("Horizon Forbidden West ")
				.descripcion("Horizon Zero Dawn sigue el viaje de Aloy mientras intenta descubrir su pasado misterioso y los orígenes olvidados de su mundo. Ella vive en una versión futurista del planeta Tierra, planeta invadido por bestias mecánicas mientras los humanos se ven obligados a vivir en pequeñas tribus dispersas. Aloy posee un dispositivo llamado Focus, que le otorga habilidades sensoriales únicas que le ayudan en este planeta hostil.")
				.pvp(79.99)
				.descuento(10)
				.imagen("https://sm.ign.com/ign_es/game/h/horizon-fo/horizon-forbidden-west_2v57.jpg")
				.build();
		productoRepository.save(p2);
		

		Producto p3 = Producto.builder()
				.nombre("Genshin Impact")
				.descripcion("Los jugadores asumirán el papel de un misterioso «viajero», que emprende un viaje para encontrar a su hermano/a perdido/a y a la vez también desentrañar los misterios que esconde el continente de Teyvat.")
				.pvp(5)
				.descuento(0)
				.imagen("https://media.vandal.net/m/75962/genshin-impact-20209417573364_1.jpg")
				.build();
		productoRepository.save(p3);
		
	}
	//hacer esto con los 3 productos
	//me da error en que no tiene id , tiene q ser floato o double?
}




		