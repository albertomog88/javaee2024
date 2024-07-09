package dao;

import java.util.List;

import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Resultado;

@Named("buscador1")
public class BuscadorDaoImpl implements BuscadorDao {
	private static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("buscador");
		eManager=factory.createEntityManager();
	}
	
	@Override
	public void save(Resultado resultado) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		try {
			eManager.persist(resultado);
			tx.commit();
		}catch(Exception ex) {
			tx.rollback();
		}
	}
	
	@Override
	public Resultado findByUrl(String url) {
		String jpql="select r from Resultado r where r.url=:url";
		TypedQuery<Resultado> query= eManager.createQuery(jpql, Resultado.class);
		query.setParameter("url", url);
		return query.getResultList().stream()
				.findFirst()
				.orElse(null);
	}
	
	@Override
	public Resultado findById(int idResultado) {
		return eManager.find(Resultado.class, idResultado);
	}
	
	@Override
	public void deleteById(int idResultado) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		eManager.remove(findById(idResultado));
		tx.commit();
	}
	@Override
	public List<Resultado> findByTematica(String tematica){
		String jpql="select r from Resultado r where r.tematica=:tem";
		TypedQuery<Resultado> query= eManager.createQuery(jpql, Resultado.class);
		query.setParameter("tem", tematica);
		return query.getResultList();
	}
}
