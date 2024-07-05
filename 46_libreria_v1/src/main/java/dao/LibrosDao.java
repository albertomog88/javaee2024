package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;

public class LibrosDao {
	static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		eManager=factory.createEntityManager();
	}
	public List<Libro> findAll(){
		TypedQuery<Libro> query=eManager.createNamedQuery("Libro.findAll", Libro.class);
		return query.getResultList();
	}
	public List<Libro> findByIdTema(int idTema){
		TypedQuery<Libro> query=eManager.createNamedQuery("Libro.findByIdTema", Libro.class);
		query.setParameter(1, idTema);
		return query.getResultList();
	}
}
