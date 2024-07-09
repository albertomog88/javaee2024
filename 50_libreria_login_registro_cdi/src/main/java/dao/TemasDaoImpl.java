package dao;

import java.util.List;

import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Tema;
@Named
public class TemasDaoImpl implements TemasDao {
	static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		eManager=factory.createEntityManager();
	}
	
	@Override
	public List<Tema> findAll(){
		TypedQuery<Tema> query=eManager.createNamedQuery("Tema.findAll", Tema.class);
		return query.getResultList();
	}
	@Override
	public Tema findById(int idTema) {
		return eManager.find(Tema.class, idTema);
	}
}
