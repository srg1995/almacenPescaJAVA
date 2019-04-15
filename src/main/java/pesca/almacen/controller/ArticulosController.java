package pesca.almacen.controller;

import java.util.ArrayList;

import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pesca.almacen.dto.ArticulosDto;
import pesca.almacen.service.ArticulosService;

@Controller
public class ArticulosController {
	
	
	@Autowired
	private ArticulosService articulosService;
	
	@RequestMapping(value = "/")
	public String cargaInicial() {
		return "index";
	}
	
	@RequestMapping(value = "/ver-stock")
	public String verStock(ArticulosDto articulosDto, Model modelo, Errors errores) {
		ArrayList almacen = (ArrayList)articulosService.getStockArticulos().buscarListadoArticulos();
		modelo.addAttribute("existencias", almacen);
		return "existencias";
	}
	
	@RequestMapping(value = "/carga-existencias", method=RequestMethod.GET)
	public String reducirStockArticulo(@ModelAttribute ArticulosDto articulosDto, Model modelo, @RequestParam(defaultValue = "compra") String accion) {
		
		switch(accion) {
			case "compra":
				modelo.addAttribute("modificarExistencias", articulosDto);
				accion = "comprarArticulos";
				break;
			case "venta":
				modelo.addAttribute("modificarExistencias", articulosDto);
				accion = "venderArticulos";
				break;
			case "busca":
				modelo.addAttribute("buscarExistencias", articulosDto);
				accion = "buscarArticulo";
				break;
			case "insertar":
				modelo.addAttribute("insertarExistencias", articulosDto);
				accion = "insertarArticulo";
				break;
			default:
				accion = "index";
		}
		return accion;

	}
	
	@RequestMapping(value = "/buscar-articulo")
	public String buscarArticulo(@ModelAttribute ArticulosDto articulosDto, Model modelo, Errors errores) {
		if(null != articulosService.getArticulo(articulosDto)) {
			modelo.addAttribute("buscarExistencias", articulosDto);
			modelo.addAttribute("articulo", articulosService.getArticulo(articulosDto));
		}else{
			modelo.addAttribute("buscarExistencias", articulosDto);
			modelo.addAttribute("errores", "no existe ese producto en el almacen");
		}
		return "buscarArticulo";
	}
	
	@RequestMapping(value = "/insertar-articulo")
	public String insertarArticulo(@ModelAttribute ArticulosDto articulosDto, Model modelo, Errors errores) throws DuplicateKeyException{
		try {
			articulosService.comprarArticulos(articulosDto);
		}catch(DuplicateKeyException de) {
			modelo.addAttribute("insertarExistencias", articulosDto);
			modelo.addAttribute("errores", "este producto ya existe modifique sus exitencias");
			return "insertarArticulo";
		}
		return "index";
	}

	@RequestMapping(value = "/aumentar-stock")
	public String aumentarStockArticulo(@ModelAttribute ArticulosDto articulosDto, Model modelo, Errors errores) {
		try {
			int stockAlmacen = articulosService.ConocerExistencias(articulosDto); 
			articulosDto.setUnidades(stockAlmacen + articulosDto.getUnidades());
			articulosService.actualizarStockArticulo(articulosDto);
			return "index";			
		}catch(BindingException be) {
			modelo.addAttribute("modificarExistencias", articulosDto);
			modelo.addAttribute("errores", "no existe ese producto en el almacen");
		}
		return "comprarArticulos";
	}
	
	@RequestMapping(value = "/reducir-stock")
	public String reducirStockArticulo(@ModelAttribute ArticulosDto articulosDto, Model modelo, Errors errores) {
		try {
			int stockAlmacen = articulosService.ConocerExistencias(articulosDto); 
			if(stockAlmacen > articulosDto.getUnidades()) {
				articulosDto.setUnidades(stockAlmacen - articulosDto.getUnidades());
				articulosService.actualizarStockArticulo(articulosDto);
				return "index";
			}else {
				modelo.addAttribute("modificarExistencias", articulosDto);
				modelo.addAttribute("errores", "no hay stock suficiente");
				errores.rejectValue("unidades", "no hay stock suficiente");
			}		
			
		}catch(BindingException be) {
			modelo.addAttribute("modificarExistencias", articulosDto);
			modelo.addAttribute("errores", "no existe ese producto en el almacen");
		}
		return "venderArticulos";
	}
	
}
