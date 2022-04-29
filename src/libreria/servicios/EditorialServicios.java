/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author Vanesa
 */
public class EditorialServicios {
    private EditorialDAO editorialDao;

    public EditorialServicios() {
        this.editorialDao = new EditorialDAO();
    }

    
    public void crearEditorial(String nombre, boolean alta) throws Exception{
        try{
            Editorial editorial = new Editorial(nombre, alta);
            editorialDao.guardarEditorial(editorial);
        }catch(Exception e){
            throw new Exception("Se produjo un error al guadar editorial: " + e.getMessage());
        }
    }
    
    public void eliminarEditorial(Integer id) throws Exception{
        try{
            editorialDao.eliminarEditorial(id);
        }catch(Exception e){
            throw new Exception("Se produjo un error al Eliminar editorial: " + e.getMessage());
        }
    }
    
    public void actualizarEditorial(String nombre, String nuevoNombre, boolean nuevaAlta) throws Exception{
        try{
            Editorial editorialBuscado = new Editorial();
            editorialBuscado = editorialDao.buscarEditorialPorNombre(nombre).get(0);
            editorialBuscado.setNombre(nuevoNombre);
            editorialBuscado.setAlta(nuevaAlta);
            editorialDao.actualizarEditorial(editorialBuscado);
            
        } catch(Exception e){
            throw new Exception("Se produjo un error al actualzar: " + e.getMessage());
        }
    }
    
    public void mostrarEditoriales() throws Exception{
        try{
           List<Editorial> editorialLista = editorialDao.mostrarEditoriales();
           for(Editorial editorial: editorialLista){
               System.out.println("id: " + editorial.getId());
               System.out.println("Nombre: " + editorial.getNombre());
               System.out.println("Alta " + editorial.isAlta());
               System.out.println("----------------------------------------------");
               System.out.println("");
           }
        }catch(Exception e){
            throw new Exception("Se produjo un error al mostrar lista de editoriales" + e.getMessage());
        }
    }
    
    public Editorial buscarEditorialPorID(Integer id) throws Exception{
        try{
            Editorial editorialSeleccionada = new Editorial();
            editorialSeleccionada = editorialDao.buscarPorID(id);
           editorialSeleccionada.getId();
            return editorialSeleccionada;
            
        }catch(Exception e){
            throw new Exception ("Se produjo un error al buscarAutorPorID" + e.getMessage());
        }
    }
    
}
