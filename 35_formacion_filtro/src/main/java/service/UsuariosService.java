package service;

import dao.UsuariosDao;
import jakarta.persistence.TypedQuery;
import model.Usuario;

public class UsuariosService {
	UsuariosDao dao=new UsuariosDao();
	
	public boolean autenticar(String usuario, String pwd) {
		return dao.findByUsuarioAndPassword(usuario, pwd)!=null;
	}
}
