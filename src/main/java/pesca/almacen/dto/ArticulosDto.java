package pesca.almacen.dto;

import java.io.Serializable;

public class ArticulosDto implements Serializable{
	
	private String nombre;
	
	private String talla;
	
	private int unidades;
	
	private String segundaMano;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getSegundaMano() {
		return segundaMano;
	}

	public void setSegundaMano(String segundaMano) {
		this.segundaMano = segundaMano;
	}
	
}
