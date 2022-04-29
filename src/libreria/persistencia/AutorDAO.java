/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

/**
 *
 * @author Vanesa
 */
public class AutorDAO extends DAO<Autor> {

    public void guardarAutor(Autor autor) {
        super.guardar(autor); //invoca un metodo de la clase padre DAO
    }

    public List<Autor> buscarAutorPorNombre(String nombre) {
        conectar();
        List<Autor> listaDeAutores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre= :nombre").setParameter("nombre", nombre).getResultList(); //devuelve una lista con los autores con el nombre
        desconectar();
        return listaDeAutores;
    }
    
    public Autor buscarPorID(Integer id){
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }
    
    public void eliminarAutor(Integer id){
        Autor autor = new Autor();
        autor = buscarPorID(id);
        super.eliminar(autor);
    }
    
    public void actualizarAutor(Autor autor){
        super.actualizar(autor);
    }

    public List<Autor> mostrarAutores(){
        conectar();
        List<Autor> listaDeAutores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return listaDeAutores;
        
    }
}
