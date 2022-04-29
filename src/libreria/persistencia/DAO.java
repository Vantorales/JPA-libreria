/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanesa
 * @param <T>
 */
public class DAO<T> {

    //el entity nos permitira crear un entity manager
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPA_exerPU");
    protected EntityManager em = EMF.createEntityManager(); //NOS PERMITE REALIZAR LAS CONSULTAS CON LA DB

    protected void conectar() {
        // verifico que no exista una conexion
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    //INSERT INTO - persistir un registro en la DB
    protected void guardar(T objeto) {
        conectar();
        em.getTransaction().begin(); //le da inicio a la transaccion
        em.persist(objeto); //persisto/guardo un registro completo
        em.getTransaction().commit(); //guarda los cambios en la DB y los finaliza
        desconectar();
    }
    
    //UPDATE - actualizar datos en un registro
    protected void actualizar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit(); 
        desconectar();
    }

    //DELETE - borra un registro/fila de una tabla
    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        if (!em.contains(objeto)) {
    objeto = em.merge(objeto);
}
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    
    
   
    
    
}