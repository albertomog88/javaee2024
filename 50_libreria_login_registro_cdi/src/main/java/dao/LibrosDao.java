package dao;

import java.util.List;

import model.Libro;

public interface LibrosDao {

	List<Libro> findAll();

	List<Libro> findByIdTema(int idTema);

	Libro findByIsbn(int isbn);

	void save(Libro libro);

}