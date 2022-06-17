package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.servicio.VentaServicio;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VentaController {

	@Autowired
	private VentaServicio ventaServicio;

	@GetMapping("/listaVentas")
	public String listaVentas(Model model) {

		model.addAttribute("listaVentas", ventaServicio.findAll());
		model.addAttribute("recaudado", ventaServicio.calcularRecaudadoMes());

		return "ventas";
	}

	@GetMapping("/nuevaVenta")
	public String nuevaVenta(Model model) {
		model.addAttribute("venta", new Venta());
		return "formularioVenta";
	}

	@PostMapping("/nuevaVenta/submit")
	public String submitNuevaVenta(@ModelAttribute("venta") Venta venta, Model model) {

		ventaServicio.save(venta);

		// En el redirect hay que poner la ruta completa del controller al que queremos
		// ir,
		// incluyendo lo escrito dentro del @RequestMapping del comienzo de la clase
		return "redirect:/listaVentas/";
	}

	@GetMapping("/editarVenta/{id}")
	public String editarVenta(@PathVariable("id") long id, Model model) {

		Optional<Venta> venta = ventaServicio.findById(id);

		if (venta.isPresent()) {
			model.addAttribute("venta", venta.get());
			model.addAttribute("listaLineas", venta.get().getLineas());
			return "lineas";
		} else {
			return "redirect:/listaVenta";
		}

	}
	// 58 es el id de la venta que tiene 2 lineas

	@GetMapping("/borrarVenta/{id}")
	public String borrarVenta(@PathVariable("id") Long id, Model model) {

		Optional<Venta> venta = ventaServicio.findById(id);

		if (venta.isPresent()) {
			ventaServicio.deleteById(id);
			return "redirect:/listaVentas";
		} else {

			return "redirect:/listaVentas";
		}

	}

}
