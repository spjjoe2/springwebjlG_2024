package service;

import java.util.List;

import model.Resultado;

public interface BuscadorService {
	List<Resultado> buscar(String tematica);
	boolean agregar(Resultado resultado);
}
