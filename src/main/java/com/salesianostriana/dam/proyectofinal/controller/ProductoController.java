package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/sumar")
    String aniadirProducto() {
        return "formularioProducto";
    }
	
	@GetMapping("/auth-error")
    String error() {
        return "auto-error";
    }
	
	
	@GetMapping("/lista")
    public String listaProductos(Model model) {
		model.addAttribute("listaProductos", productoServicio.findAll());
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
	
	
	//nuevo producto
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("producto", new Producto());
		return "formularioProducto";
	}
	
	//submitear nuevo producto
	@PostMapping({ "/submit", "/submit/{id}" })
	public String procesarFormulario(@ModelAttribute("producto") Producto producto) {
		
		productoServicio.save(producto);
		return "redirect:/products";
	}

	

	
	
/*La siguiente línea viene del último método, 
 * que se dedica a buscar, para que este método, 
 * muestre también el listado de productos cuando se han buscado, 
 * añadimos al model el objeto tipo bean de búsqueda cuando se está 
 * buscando algún producto
		
		
		model.addAttribute("searchForm", new SearchBean());
		return "list";
		
	}
	

	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {

		Optional<Producto> producto = productoServicio.findById(id);

		if (producto != null) {
			model.addAttribute("producto", producto);
			//model.addAttribute("categorias", categoriaService.findAll());
			return "/sumar";
		} else {
			return "redirect:/admin/producto/";
		}

	}
	
	//many to one 9
	//te lleva a editar con datos rellenos
	
	
	//necesito post mapping
	
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Optional<Producto> producto = productoServicio.findById(id);

		if (producto != null) {
			productoServicio.delete(producto);
		}

		return "redirect:/admin/producto/";

	}
*/
}
