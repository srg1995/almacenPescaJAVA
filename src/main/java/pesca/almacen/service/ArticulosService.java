package pesca.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;

import pesca.almacen.dto.ArticulosDto;
import pesca.almacen.mapper.ArticulosMapper;

/**
 * @author sergio
 *
 */
/**
 * @author sergio
 *
 */
public class ArticulosService {

	@Autowired
	private ArticulosMapper articulosMapper;

	/**
	 * getter
	 * 
	 * @return
	 */
	public ArticulosDto getArticulo(ArticulosDto articulosDto) {
		return articulosMapper.buscarArticulo(articulosDto);
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public ArticulosMapper getStockArticulos() {
		articulosMapper.buscarListadoArticulos();
		return articulosMapper;
	}


	/**
	 * getter
	 * 
	 * @return
	 */
	public void comprarArticulos(ArticulosDto articulosDto){
		articulosMapper.insertarArticulo(articulosDto);
	}
	
	/**
	 * getter
	 * 
	 * @return
	 */
	public void actualizarStockArticulo(ArticulosDto articulosDto){
		articulosMapper.actualizarArticulo(articulosDto);
	}
	
	/**
	 * @return
	 */
	public ArticulosMapper getArticulosMapper() {
		return articulosMapper;
	}
	
	public int ConocerExistencias(ArticulosDto articulosDto){
		return articulosMapper.getExistencias(articulosDto);
	}

	/**
	 * @param articulosMapper
	 */
	public void setArticulosMapper(ArticulosMapper articulosMapper) {
		this.articulosMapper = articulosMapper;
	}

}
