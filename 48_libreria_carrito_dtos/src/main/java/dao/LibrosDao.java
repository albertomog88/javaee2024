package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
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
	public Libro findByIsbn(int isbn) {
		return eManager.find(Libro.class, isbn);
	}
	public void save(Libro libro) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		eManager.persist(libro);
		tx.commit();
	}
}
