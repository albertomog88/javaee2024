package dao;



import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Cliente;
@Named
public class ClientesDaoImpl implements ClientesDao {
	static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		eManager=factory.createEntityManager();
	}
	@Override
	public void save(Cliente cliente) {
		EntityTransaction tx=eManager.getTransaction();
		tx.begin();
		eManager.persist(cliente);
		tx.commit();
	}

	@Override
	public Cliente findByUsuario(String usuario) {
		String jpql="select c from Cliente c where c.usuario=?1";
		TypedQuery<Cliente> query=eManager.createQuery(jpql,Cliente.class);
		query.setParameter(1, usuario);
		try {
			return query.getSingleResult();
		}
		catch(NoResultException ex) {
			return null;
		}
		catch(NonUniqueResultException ex) {
			return query.getResultList().get(0);
		}
				
	}

}
