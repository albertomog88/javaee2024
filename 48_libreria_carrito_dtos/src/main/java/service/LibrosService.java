package service;

import java.util.List;

import dao.LibrosDao;
import dao.TemasDao;
import dtos.LibroDto;
import dtos.TemaDto;
import mappers.Mapeador;

public class LibrosService {
	LibrosDao librosDao=new LibrosDao();
	TemasDao temasDao=new TemasDao();
	
	public List<TemaDto> getTemas(){
		return temasDao.findAll().stream()
				.map(t->Mapeador.temaEntityToDto(t))//Stream<TemaDto>
				.toList();
	}
	
	public List<LibroDto> librosTema(int idTema){
		
		if(idTema!=0) {
			return librosDao.findByIdTema(idTema).stream()
					.map(l->Mapeador.libroEntityToDto(l))
					.toList();
		}else{
			return librosDao.findAll().stream()
					.map(l->Mapeador.libroEntityToDto(l))
					.toList();
		}
			
	}
	public LibroDto getLibro(int isbn) {
		return Mapeador.libroEntityToDto(librosDao.findByIsbn(isbn));
	}
	
	public TemaDto getTema(int idTema) {
		return Mapeador.temaEntityToDto(temasDao.findById(idTema));
	}
}
