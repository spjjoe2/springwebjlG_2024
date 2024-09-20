package model;

public class CursoDto {
	private String nombre;
	private String tematica;
	private int duracion;
	private double precio;
	public CursoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoDto(String nombre, String tematica, int duracion, double precio) {
		this.nombre = nombre;
		this.tematica = tematica;
		this.duracion = duracion;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
 
	
	
}
