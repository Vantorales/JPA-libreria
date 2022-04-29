/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author Vanesa
 */
public class LibroDAO extends DAO <Libro>{
    
    public void guardarLibro(Libro libro){
        super.guardar(libro);
    }
    
    public List<Libro> buscarLibroPorNombre(String nombre){
        conectar();
        List<Libro> listaDeLibros =  em.createQuery("SELECT a FROM Libro a WHERE a.nombre= :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return listaDeLibros;
    }
    
    public Libro buscarPorID(Integer Id){
        Libro libro =  em.find(Libro.class, Id);
        return libro;
    }
    
    public void eliminarLibro(Integer Id){
        Libro libro = new Libro();
        libro = buscarPorID(Id);
        super.eliminar(libro);
    }
    
    public List<Libro> mostrarLibros(){
        conectar();
        List<Libro> listaDeLibros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return listaDeLibros;
        
    }
    
}
