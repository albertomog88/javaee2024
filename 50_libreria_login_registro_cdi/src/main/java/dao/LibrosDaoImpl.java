package dao;

import java.util.List;

import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
@Named
public class LibrosDaoImpl implements LibrosDao {
	static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		eManager=factory.createEntityManager();
	}
	@Override
	public List<Libro> findAll(){
		TypedQuery<Libro> query=eManager.createNamedQuery("Libro.findAll", Libro.class);
		return query.getResultList();
	}
	@Override
	public List<Libro> findByIdTema(int idTema){
		TypedQuery<Libro> query=eManager.createNamedQuery("Libro.findByIdTema", Libro.class);
		query.setParameter(1, idTema);
		return query.getResultList();
	}
	@Override
	public Libro findByIsbn(int isbn) {
		return eManager.find(Libro.class, isbn);
	}
	@Override
	public void save(Libro libro) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		eManager.persist(libro);
		tx.commit();
	}
}
