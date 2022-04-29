/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Vanesa
 */
public class LibroServicios {
    private LibroDAO libroDao;

    public LibroServicios() {
        this.libroDao = new LibroDAO();
    }

    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) throws Exception{
         try{
            Libro libro = new Libro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, alta, autor, editorial);
            libroDao.guardarLibro(libro); 
        } catch(Exception e) {
            throw new Exception("Se produjo un error al guardar libro: " + e.getMessage());
        }
    }
    
    public void eliminarLibro(Integer Id) throws Exception{
        try{
            libroDao.eliminarLibro(Id);
        }catch(Exception e){
            throw new Exception("Se produjo un error al Eliminar libro " + e.getMessage());
        }
    }
    
    public void mostrarLibros() throws Exception{
        try{
           List<Libro> libroLista = libroDao.mostrarLibros();
           for(Libro libro: libroLista){
               
               System.out.println("id: " + libro.getId());
               System.out.println("isbn: " + libro.getIsbn());
               System.out.println("titulo: " + libro.getTitulo());
               System.out.println("año: " + libro.getAnio());
               System.out.println("ejemplares: " + libro.getEjemplares());
               System.out.println("ejemplares prestados: " + libro.getEjemplaresPrestados());
               System.out.println("ejemplares restantes: " + libro.getEjemplaresRestantes());
               System.out.println("alta: " + libro.isAlta());
               System.out.println("autor: " + libro.getAutor());
               System.out.println("editorial: " + libro.getEditorial());
               
               System.out.println("----------------------------------------------");
               System.out.println("");
           }
        }catch(Exception e){
            throw new Exception("Se produjo un error al mostrar lista de libros " + e.getMessage());
        }
    }
    
}
