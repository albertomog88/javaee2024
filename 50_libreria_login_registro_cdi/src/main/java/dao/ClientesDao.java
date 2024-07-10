package dao;

import model.Cliente;

public interface ClientesDao {
	public void save(Cliente cliente);
	public Cliente findByUsuario(String usuario);
}
