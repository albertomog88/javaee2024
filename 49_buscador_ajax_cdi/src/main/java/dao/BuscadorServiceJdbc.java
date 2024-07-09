package dao;

import java.util.List;


import jakarta.inject.Named;
import model.Resultado;

@Named("buscador2")
public class BuscadorServiceJdbc implements BuscadorDao {

	@Override
	public void save(Resultado resultado) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resultado findByUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado findById(int idResultado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int idResultado) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Resultado> findByTematica(String tematica) {
		// TODO Auto-generated method stub
		return null;
	}

}
