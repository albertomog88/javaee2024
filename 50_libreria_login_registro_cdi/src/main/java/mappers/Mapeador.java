package mappers;

import dao.TemasDao;
import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Libro;
import model.Tema;
@Named
public class Mapeador {
	@Inject
	TemasDao temasDao;
	public  TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(),tema.getTema());
	}
	public  LibroDto libroEntityToDto(Libro libro) {
		
		return new LibroDto(libro.getIsbn(),
						libro.getTitulo(),
						libro.getAutor(),
						libro.getPrecio(),
						libro.getPaginas(),
						temaEntityToDto(temasDao.findById(libro.getIdTema()))
						);
	}
	public  Libro libroDtoToEntity(LibroDto libro) {
		return new Libro(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				libro.getTemaDto().getIdTema()
				);
	}
}
