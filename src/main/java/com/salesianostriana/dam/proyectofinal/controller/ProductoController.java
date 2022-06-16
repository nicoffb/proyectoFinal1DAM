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
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.model.BuscarBean;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;
import com.salesianostriana.dam.proyectofinal.servicio.VentaServicio;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class ProductoController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private final ProductoServicio productoServicio;
	
	private final VentaServicio ventaServicio;
	
	@GetMapping("/indexAdmin")
    String inicio() {
        return "index";
    }
	
	
	@GetMapping("/indexUsuario")
    String inicioUsuario() {
        return "indexUsuario";
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
	
	
	
	
	//METODO PARA INDEX
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listaProductos", productoServicio.findAll());
		model.addAttribute("buscarForm", new BuscarBean());
		
		return "index";
	}
	
		
	//METODO PARA INVOCAR ATRIBUTOS POR ID
	@GetMapping("/detalle/{id}")
	public String detail(Model model, @PathVariable Long id) {
		
		Optional<Producto> p = productoServicio.findById(id);
		
		if (p.isPresent()) {
			model.addAttribute("producto", p.get());
			return "productoDetalle";			
		} else {
			return "redirect:/lista";
		}
		
		//tendria q tener otro controller para cuando sea el usuario
		//redirect lleva a otro controller, sin redirect al html
		
		//que es lo de redirect, porque producto detail, pq detalle si lo q quiero es mostrar especificamente
		//los atributos de un solo id
		
	}
	
	
//AÑADIR
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("producto", new Producto());
		return "formularioProducto";
	}
	
	//submitear nuevo producto
	@PostMapping( "/submit")
	public String procesarFormulario(@ModelAttribute("producto") Producto producto) {
		productoServicio.save(producto);
		return "redirect:/lista";
	}


	
//EDITAR
	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") long id, Model model) {

		Optional<Producto> producto = productoServicio.findById(id);

		if (producto.isPresent()) {
			model.addAttribute("producto", producto.get());
			return "formularioProducto";
		} else {
			return "redirect:/lista";
		}

	}

	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("producto") Producto p) {
		productoServicio.edit(p);
		return "redirect:/lista";//Volvemos a redirigir la listado a través del controller para pintar la lista actualizada con la modificación hecha
	}
	
	
	
	
//BORRAR	
	
	@GetMapping("/borrar/{id}")
	public String borrarCategoria(@PathVariable("id") long id, Model model) {
		
		Optional<Producto> producto = productoServicio.findById(id);
		
		if (producto.isPresent() ) {
			productoServicio.deleteById(id);
			return "redirect:/lista";
			} else {
				
				return "redirect:/formularioProducto";	
				
			}
		
	}
		
		
		
		
	@PostMapping("/buscar")
	  public String buscarProducto(@ModelAttribute("buscarForm") BuscarBean buscarBean,
			 Model model){
	  	model.addAttribute("productos", productoServicio.findByNombre(buscarBean.getBuscar()));
	  
	  return "index";
	  }
		
		
		
		
		
/*		
 * @GetMapping("/actualizar/{id}")
		public String actualizarProducto(@PathVariable("id") long id,  Model model) {
			model.addAttribute("productos", productoServicio.findAll());
			model.addAttribute("producto", productoServicio.findById(id).get());
			model.addAttribute("mostrarFormulario", true);
			return "producto";
		}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
			Optional<Producto> producto = productoServicio.findById(id);
		
		if (producto != null ) {
			
			if (productoServicio.recogerIdentificador(producto).get(1)== {1,2,3}) {
			productoServicio.deleteById(id);
			return "redirect:/lista";
			} else {
				return "redirect:/?error=true";
			}
			}return "redirect:/formularioProducto";	
		
	}
}

*/		
		
		
	}
	




