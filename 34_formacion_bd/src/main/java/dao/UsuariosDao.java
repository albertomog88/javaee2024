package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Usuario;

public class UsuariosDao {
	private static EntityManager eManager;
	static {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursosPU");
		eManager= factory.createEntityManager();
	}
	public Usuario findByUsuarioAndPassword(String usuario, String pwd) {
		String jpql="select u from Usuario u where u.usuario=?1 and u.password=?2";
		TypedQuery<Usuario> query=eManager.createQuery(jpql,Usuario.class);
		query.setParameter(1, usuario);
		query.setParameter(2, pwd);
		//return query.getResultList().size()>0?query.getResultList().get(0):null;
		return query.getResultList().stream()
				.findFirst()
				.orElse(null);
	}
}
