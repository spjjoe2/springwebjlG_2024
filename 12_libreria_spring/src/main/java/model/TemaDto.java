package model;

public class TemaDto {
	private int idTema;
	private String nombreTema;
	public TemaDto(int idTema, String nombreTema) {
		super();
		this.idTema = idTema;
		this.nombreTema = nombreTema;
	}
	
	
	
	public TemaDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public String getNombreTema() {
		return nombreTema;
	}
	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}
	
}
