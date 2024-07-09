package service;

import java.util.List;

import dao.LibrosDao;
import dao.TemasDao;
import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mappers.Mapeador;
@Named
public class LibrosServiceImpl implements LibrosService {
	@Inject
	LibrosDao librosDao;
	@Inject
	TemasDao temasDao;
	@Inject
	Mapeador mapeador;
	@Override
	public List<TemaDto> getTemas(){
		return temasDao.findAll().stream()
				.map(t->mapeador.temaEntityToDto(t))//Stream<TemaDto>
				.toList();
	}
	
	@Override
	public List<LibroDto> librosTema(int idTema){
		
		if(idTema!=0) {
			return librosDao.findByIdTema(idTema).stream()
					.map(l->mapeador.libroEntityToDto(l))
					.toList();
		}else{
			return librosDao.findAll().stream()
					.map(l->mapeador.libroEntityToDto(l))
					.toList();
		}
			
	}
	@Override
	public LibroDto getLibro(int isbn) {
		return mapeador.libroEntityToDto(librosDao.findByIsbn(isbn));
	}
	
	@Override
	public TemaDto getTema(int idTema) {
		return mapeador.temaEntityToDto(temasDao.findById(idTema));
	}
	
	@Override
	public boolean guardarLibro(LibroDto libro) {
		if(librosDao.findByIsbn(libro.getIsbn())!=null) {
			return false;
		}
		librosDao.save(mapeador.libroDtoToEntity(libro));
		return true;
	}
}
