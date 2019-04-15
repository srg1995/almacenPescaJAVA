package pesca.almacen.mapper;

import java.util.List;

import pesca.almacen.dto.ArticulosDto;

public interface ArticulosMapper {

	/**
	 * busca un articulo
	 */
	public ArticulosDto buscarArticulo(ArticulosDto articulosDto);
	
	/**
	 * busca un articulos
	 */
	public List<ArticulosDto> buscarListadoArticulos();
	
	/**
	 * comprar un articulo
	 */
	public void insertarArticulo(ArticulosDto articulosDto);
	
	/**
	 * vender un articulo
	 */
	public void actualizarArticulo(ArticulosDto articulosDto);
	
	/**
	 * conocer existencias 
	 * @param articulosDto
	 */
	public int getExistencias(ArticulosDto articulosDto);
	
}
