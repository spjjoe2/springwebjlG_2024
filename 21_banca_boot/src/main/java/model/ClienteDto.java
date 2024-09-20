package model;

import jakarta.persistence.Id;

public class ClienteDto {
	
	@Id
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	
	public ClienteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteDto(int dni, String nombre, String direccion, int telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	

}
