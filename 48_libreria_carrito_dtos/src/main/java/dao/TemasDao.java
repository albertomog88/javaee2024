package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Tema;

public class TemasDao {
	static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		eManager=factory.createEntityManager();
	}
	
	public List<Tema> findAll(){
		TypedQuery<Tema> query=eManager.createNamedQuery("Tema.findAll", Tema.class);
		return query.getResultList();
	}
	public Tema findById(int idTema) {
		return eManager.find(Tema.class, idTema);
	}
}
