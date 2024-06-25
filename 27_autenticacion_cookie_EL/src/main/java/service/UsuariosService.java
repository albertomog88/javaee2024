package service;

import java.util.ArrayList;
import java.util.List;

import model.Ficha;
import model.Usuario;

public class UsuariosService {
	List<Usuario> usuarios=new ArrayList<>(List.of(
			new Usuario("user1","pwd1"),
			new Usuario("user2","pwd2"),
			new Usuario("user3","pwd3"),
			new Usuario("user4","pwd4")
			));
	List<Ficha> fichas=List.of(new Ficha("user1",19,"aa@gmail.com"),
			new Ficha("user2",24,"admin@gmail.com"),
			new Ficha("user3",49,"jos@gmail.com"),
			new Ficha("user4",35,"ddd@gmail.com")
			);
	public boolean autenticar(String usuario, String pwd) {
		for(Usuario u:usuarios) {
			if(u.getUsuario().equals(usuario)&&u.getPassword().equals(pwd)) {
				return true;
			}
		}
		return false;
		
		/*return usuarios.stream()
				.anyMatch(u->u.getUsuario().equals(usuario)&&u.getPassword().equals(pwd));*/
	}
	public Ficha fichaUsuario(String usuario) {
		return fichas.stream()
				.filter(f->f.getUsuario().equals(usuario))
				.findFirst()
				.orElse(new Ficha());
	}
}
