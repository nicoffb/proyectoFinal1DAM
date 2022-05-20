package com.salesianostriana.dam.proyectofinal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;



@Controller
public class ProductoController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping("/indexAdmin")
    String inicio() {
        return "index";
    }
	
	
	@GetMapping("/indexUsuario")
    String inicioUsuario() {
        return "indexUsuario.html";
    }
	
	@GetMapping("/aniadirProducto")
    String aniadirProducto() {
        return "add-product.html";
    }
	
	/*

	//METODO PARA LOGIN
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
