package service;

import dao.ClientesDao;
import dtos.ClienteDto;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mappers.Mapeador;
import model.Cliente;
@Named
public class ClientesServiceImpl implements ClientesService {
	@Inject
	ClientesDao clientesDao;
	
	@Inject
	Mapeador mapeador;

	@Override
	public boolean autenticar(String usuario, String password) {
		Cliente cliente=clientesDao.findByUsuario(usuario);
		return cliente!=null&&cliente.getPassword().equals(password);
	}

	@Override
	public boolean registrar(ClienteDto cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {//si no encuentra cliente con ese usuario, lo guarda
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;
	}

}
