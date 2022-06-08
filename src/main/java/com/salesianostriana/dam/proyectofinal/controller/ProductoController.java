package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class ProductoController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private final ProductoServicio productoServicio;
	
	@GetMapping("/indexAdmin")
    String inicio() {
        return "index";
    }
	
	
	@GetMapping("/indexUsuario")
    String inicioUsuario() {
        return "indexUsuario";
    }
	
	@GetMapping("/aniadirProducto")
    String aniadirProducto() {
        return "add-product";
    }
	
	@GetMapping("/auth-error")
    String error() {
        return "auto-error";
    }
	
	@GetMapping("/lista")
    String listaProductos() {
        return "products";
    }
	
	
	//METODO PARA INVOCAR LA LISTA DE PRODUCTOS a partir de la base de datos
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listaProductos", productoServicio.findAll());
	
		
		return "index";
	}
	
	//METODO PARA INVOCAR ATRIBUTOS POR ID
	@GetMapping("/detalle/{id}")
	public String detail(Model model, @PathVariable Long id) {
		
		Optional<Producto> result = productoServicio.findById(id);
		
		if (result.isPresent()) {
			model.addAttribute("producto", result.get());
			return "productoDetalle";			
		} else {
			return "redirect:/lista";
		}
		
		//tendria q tener otro controller para cuando sea el usuario
		//redirect lleva a otro controller, sin redirect al html
		
		//que es lo de redirect, porque producto detail, pq detalle si lo q quiero es mostrar especificamente
		//los atributos de un solo id
		
	}
	
	
	
	/*

	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("producto", new Producto());
		return "formularioProducto";
	}
	
	
	@GetMapping({"/list"})
	public String productList(Model model) {
		
		model.addAttribute("productos", productServicio.findAllProducts());

/*La siguiente línea viene del último método, 
 * que se dedica a buscar, para que este método, 
 * muestre también el listado de productos cuando se han buscado, 
 * añadimos al model el objeto tipo bean de búsqueda cuando se está 
 * buscando algún producto
		
		
		model.addAttribute("searchForm", new SearchBean());
		return "list";
		
		
		
	}
	*/

}
