/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Vanesa
 */
public class AutorServicios {
    private AutorDAO autorDao;

    public AutorServicios() {
        this.autorDao = new AutorDAO();
    }

    public void crearAutor(String nombre, boolean alta) throws Exception{
        try{
            Autor autor = new Autor(nombre, alta);
            autorDao.guardarAutor(autor); //guardar el autor
        } catch(Exception e) {
            throw new Exception("Se produjo un error en guardarAutor: " + e.getMessage());
        }
    }
    
    public void eliminarAutor(Integer id) throws Exception{
        try{
           autorDao.eliminarAutor(id);
        } catch(Exception e){
            throw new Exception("Se produjo un error al EliminarAutor: " + e.getMessage());
        }
    }
    
    public void actualizarAutor(String nombre, String nuevoNombre, boolean nuevaAlta) throws Exception{
        try{
            Autor autorBuscado = new Autor();
            autorBuscado = autorDao.buscarAutorPorNombre(nombre).get(0);
            autorBuscado.setNombre(nuevoNombre);
            autorBuscado.setAlta(nuevaAlta);
            autorDao.actualizarAutor(autorBuscado);
            
        } catch(Exception e){
            throw new Exception("Se produjo un error al actualzar: " + e.getMessage());
        }
    }
    
    public void mostrarAutores() throws Exception{
        try{
           List<Autor> autorLista = autorDao.mostrarAutores();
           for(Autor autor: autorLista){
               System.out.println("id: " + autor.getId());
               System.out.println("Nombre: " + autor.getNombre());
               System.out.println("Alta " + autor.isAlta());
               System.out.println("----------------------------------------------");
               System.out.println("");
           }
        }catch(Exception e){
            throw new Exception("Se produjo un error al mostrar lista de autores " + e.getMessage());
        }
    }
    
    public Autor buscarAutorPorID(Integer id) throws Exception{
        try{
            Autor autorSeleccionado = new Autor();
            autorSeleccionado = autorDao.buscarPorID(id);
            autorSeleccionado.getId();
            return autorSeleccionado;
            
        }catch(Exception e){
            throw new Exception ("Se produjo un error al buscarAutorPorID" + e.getMessage());
        }
    }
    
    
    
}
