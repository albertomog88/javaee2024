package service;

import java.util.List;
import java.util.Optional;

import model.Resultado;

public interface BuscadorService {

	//si la url no está siendo utilizada por otro resultado, se dará de alta
	boolean altaResultado(Resultado resultado);

	Optional<Resultado> buscarResultadoPorId(int idResultado);

	Optional<Resultado> eliminarResultado(int idResultado);

	List<Resultado> resultadosPorTematica(String tematica);

}