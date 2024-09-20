package model;

import java.time.LocalDateTime;

import entities.Cuenta;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MovimientoDto {
	 
	private int idMovimiento;
	private LocalDateTime fecha;
	private double cantidad;
	private String operacion;
 
	private int numeroCuenta;

	public MovimientoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovimientoDto(int idMovimiento, int numeroCuenta,LocalDateTime fecha, double cantidad, String operacion) {
		this.idMovimiento = idMovimiento;
		this.numeroCuenta = numeroCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	 
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
}	
	
