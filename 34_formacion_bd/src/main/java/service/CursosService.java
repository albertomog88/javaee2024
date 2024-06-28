package service;

import java.util.List;

import dao.CursosDao;
import model.Curso;

public class CursosService{
	CursosDao dao=new CursosDao();
	
	
	public boolean nuevo(Curso curso) {		
		if(dao.findByNombre(curso.getNombre())==null) { //si es null, el curso no existe y se añade
			dao.save(curso);
			return true;
		}
		return false;
		
	}
	
	
	
	public List<Curso> preciosCursoMax(double precioMax){
		return dao.findByPrecioMax(precioMax);
	}
	
	public boolean eliminarCurso(String nombre) {
		if(dao.findByNombre(nombre)!=null) { //si es null, el curso no existe y se añade
			dao.deleteByNombre(nombre);
			return true;
		}
		return false;
		
	}
	
	public boolean modificarDuracion(String nombre, int nuevaDuracion) {
		if(dao.findByNombre(nombre)!=null) { //si es null, el curso no existe y se añade
			dao.updateDuracion(nombre, nuevaDuracion);
			return true;
		}
		return false;
	}
}
