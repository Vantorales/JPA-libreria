/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

/**
 *
 * @author Vanesa
 */
public class EditorialDAO extends DAO <Editorial> {
    
    public void guardarEditorial(Editorial editorial){
        super.guardar(editorial);
    }
        
    public List<Editorial> buscarEditorialPorNombre(String nombre){
        conectar();
        List<Editorial> listaDeEditoriales = em.createQuery("SELECT a FROM Editorial a WHERE a.nombre= :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return listaDeEditoriales;
    }
    
     public Editorial buscarPorID(Integer id){
         conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }
    
    public void eliminarEditorial(Integer id){
        Editorial editorial = new Editorial();
        editorial = buscarPorID(id);
        super.eliminar(editorial);
    }
    
    public void actualizarEditorial(Editorial editorial){
        super.actualizar(editorial);
    }
    
    public List<Editorial> mostrarEditoriales(){
        conectar();
        List<Editorial> listaDeEditoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return listaDeEditoriales;
        
    }
}
