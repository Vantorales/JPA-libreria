
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.servicios.AutorServicios;
import libreria.servicios.EditorialServicios;
import libreria.servicios.LibroServicios;

/**
 * @author Vanesa
 */
public class Main {

    
    public static void main(String[] args) throws Exception {
         Scanner leer = new Scanner(System.in). useDelimiter("\n");
        AutorServicios autorServicios = new AutorServicios();
        EditorialServicios editorialServicios = new EditorialServicios();
        LibroServicios libroServicios = new LibroServicios();
        int opcion = 0;
        while (opcion!=13) {
            System.out.println("MENU");
            System.out.println("Elija una de las siguientes opciones");
            System.out.println("1- Cargar un nuevo autor ");
            System.out.println("2- Eliminar autor / dar de baja");
            System.out.println("3- Modificar autor");
            System.out.println("4- Listar autores ");
            System.out.println("5- Cargar una nueva editorial ");
            System.out.println("6- Eliminar editorial / dar de baja");
            System.out.println("7- Modificar datos de editorial");
            System.out.println("8- Listar editoriales ");
            System.out.println("9- Cargar un nuevo libro ");
            System.out.println("10- Eliminar libro / dar de baja");
            System.out.println("11- Modificar datos de un libro");
            System.out.println("12- Listar libros ");
            System.out.println("13-Salir del menu");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del autor");
                    String nombreAutor =leer.next();
                    System.out.println("¿El autor está dado de alta? (true/false)");
                    boolean altaAutor = Boolean.parseBoolean(leer.next());
                    autorServicios.crearAutor(nombreAutor, altaAutor);
                    break;
                case 2:
                    System.out.println("¿Qué autor desea eliminar? A continuación se mostrará una lista de autores");
                    autorServicios.mostrarAutores();
                    System.out.println("Ingrese el ID del autor que desea eliminar");
                    Integer idAutor = leer.nextInt();
                    autorServicios.eliminarAutor(idAutor);
                    break;
                case 3:
                    modificarAutor();
                    break;
                case 4:
                    autorServicios.mostrarAutores();
                    break;
                case 5:
                    System.out.println("Ingrese el nombre de la editorial");
                    String nombreEditorial =leer.next();
                    System.out.println("¿La editorial está dada de alta? (true/false)");
                    boolean altaEditorial = Boolean.parseBoolean(leer.next());
                    editorialServicios.crearEditorial(nombreEditorial, altaEditorial);
                    break;
                case 6:
                    System.out.println("¿Qué editorial desea eliminar? A continuación se mostrará una lista de editoriales");
                    editorialServicios.mostrarEditoriales();
                    System.out.println("Ingrese el ID de la editorial que desea eliminar");
                    Integer idEditorial = leer.nextInt();
                    editorialServicios.eliminarEditorial(idEditorial);  
                    break;
                case 7:
                    modificarEditorial();
                    break;
                case 8:
                    editorialServicios.mostrarEditoriales();
                    break;
                case 9:
                    System.out.println("Ingrese el isbn del libro");
                    Long isbn = leer.nextLong();
                    System.out.println("Ingrese el titulo del libro");
                    String titulo = leer.next();
                    System.out.println("Ingrese el año del libro");
                    Integer anio = leer.nextInt();
                    System.out.println("Ingrese la cantidad de ejemplares");
                    Integer ejemplares = leer.nextInt();
                    System.out.println("Ingrese la cantidad de ejemplares prestados");
                    Integer ejemplaresPrestados = leer.nextInt();
                    Integer ejemplaresRestantes;
                    ejemplaresRestantes = (ejemplares - ejemplaresPrestados);
                    System.out.println("Los ejemplares restantes son: " + ejemplaresRestantes);
                    System.out.println("¿El libro está dado de alta? (true/false)");
                    boolean altaLibro = Boolean.parseBoolean(leer.next());
                    System.out.println("¿Quien es el autor? A continuación se mostrará una lista de autores");
                    autorServicios.mostrarAutores();
                    System.out.println("Ingrese ID de autor");
                    Integer idASeleccionado = leer.nextInt();
                    Autor autorBuscado = new Autor();
                    autorBuscado = autorServicios.buscarAutorPorID(idASeleccionado);
                    System.out.println("¿Cual es la editorial? A continuacion se mostrará una lista de editoriales");
                    editorialServicios.mostrarEditoriales();
                    System.out.println("Ingrese ID de editorial");
                    Integer idESeleccionado = leer.nextInt();
                    Editorial editorialBuscada = new Editorial();
                    editorialBuscada = editorialServicios.buscarEditorialPorID(idESeleccionado);
                    libroServicios.crearLibro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, altaLibro, autorBuscado, editorialBuscada);
                    break;
                case 10:
                    System.out.println("¿Qué libro desea eliminar? A continuación se mostrará una lista de libros");
                    libroServicios.mostrarLibros();
                    System.out.println("Ingrese el id del libro que desea eliminar");
                    Integer idLibro = leer.nextInt();
                    libroServicios.eliminarLibro(idLibro);
                case 11:
                    
                    
                    
                    default:
                    System.out.println("Opción inválida");
            }

    }

 
}
    
     private static void modificarAutor() throws Exception{
            Scanner leer = new Scanner(System.in). useDelimiter("\n");
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            
            System.out.println("Ingrese el nuevo nombre");
            String nuevoNombre = leer.next();
            
            System.out.println("Modifique el alta");
             boolean nuevaAlta = Boolean.parseBoolean(leer.next());
             
             
             AutorServicios autorServicios = new AutorServicios();
             autorServicios.actualizarAutor(nombre,nuevoNombre,nuevaAlta);
        }
    
    private static void modificarEditorial() throws Exception{
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.next();
        
        System.out.println("Ingrese el nuevo nombre");
        String nuevoNombre = leer.next();
        
        System.out.println("Modifique el alta");
        boolean nuevaAlta = Boolean.parseBoolean(leer.next());
        
        EditorialServicios editorialServicios = new EditorialServicios();
        editorialServicios.actualizarEditorial(nombre, nuevoNombre, nuevaAlta);
        
    }
}