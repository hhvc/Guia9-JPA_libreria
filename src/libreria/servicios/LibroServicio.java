package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Libro;
import persistencia.LibroDAO;

public class LibroServicio {
    
    
// 9) Búsqueda de un libro por ISBN.
//10) Búsqueda de un libro por Título.
//11) Búsqueda de un libro/s por nombre de Autor.
//12) Búsqueda de un libro/s por nombre de Editorial.
    
    
    Scanner leer = new Scanner(System.in);
    LibroDAO lD = new LibroDAO();
    
    
    public void menuBusquedaDeLibros(boolean salir){
        do {
            System.out.println("*******************************************");
            System.out.println("*       MENÚ BUSQUEDA DE LIBROS           *");
            System.out.println("*******************************************");     
            System.out.println("* 1) Consultar todos los libros           *");
            System.out.println("* 2) Búsqueda de un libro por ISBN        *");
            System.out.println("* 3) Búsqueda de un libro por Título      *");
            System.out.println("* 4) Busque libros por nombre de Autor    *"); 
            System.out.println("* 5) Busque libros por nombre de Editorial*");                
            System.out.println("* 5) Volver al Menú Libros                *");            
            System.out.println("*******************************************");            
            
            int opcion = leer.nextInt();
            switch(opcion){
                case 1: 
                    {
                    try {
                        List<Libro> libros = lD.listarTodo();
                        for (Libro libro : libros) {
                            if(libro.getAlta()){
                            System.out.println(libro);
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("No pudimos listar los libros. Revisa conexión y prueba de nuevo:");
                    }
                }
                    break;

//                case 2:
//
//                    System.out.println("Por favor, ingrese el nombre del autor");
//                    leer.nextLine();
//                    aD.guardar(new Autor(leer.nextLine(), true));
//                    
//                    break;
//                case 3:
//                        Autor autorAux;
//                        System.out.println("Deberá elegir el autor a modificar");
//                        System.out.println("Ésta es la lista de autores:");
//                        try {
//                            System.out.println(aD.listarTodo());
//                        } catch (Exception ex) {
//                            Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        System.out.println("ingrese el ID del autor a modificar");                  
//                        
//                        try {
//                            autorAux = aD.buscarPorId(leer.nextInt());
//                            System.out.println("Ingrese el nuevo nombre para el autor a modificar");
//                            leer.nextLine();
//                            autorAux.setNombre(leer.nextLine());
//                            aD.editarAutor(autorAux);
//                        } catch (Exception ex) {
//                            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
//                            System.out.println("Error al intentar leer o guardar nuevo nombre del autor");
//                        }
//                    break;
//
//                case 4:
//                        Autor autorAux2;
//                        System.out.println("Deberá elegir el autor a eliminar");
//                        System.out.println("Ésta es la lista de autores:");
//                        
//
//                        try {
//                            List<Autor> autores = aD.listarTodo();
//                            for (Autor autore : autores) {
//                                System.out.println(autore);
//                            }
//                        } catch (Exception ex) {
//                            Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
//                            System.out.println("No pudimos listar los autores. Pruebe conexión al servidor");
//                        }
//                        System.out.println("ingrese el ID del autor a eliminar");                  
//                        
//                        try {
//                             aD.eliminar(leer.nextInt());
//                        } catch (Exception ex) {
//                            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
//                            System.out.println("Error al intentar eliminar al autor. Los guardaespaldas se opusieron");
//                        }                    
//                    break;                    
                case 5: salir = true;
                break;
                default: System.out.println("Qué pusiste? probá de nuevo. Las opciones van del 1 al 4, pelmaso!");
                
            }
            
            
        } while (!salir);
        
    }
    
    
    public void menuLibro(boolean salir){
    
        do {
            System.out.println("*******************************************");
            System.out.println("*              MENÚ LIBROS                *");
            System.out.println("*******************************************");     
            System.out.println("* 1) Consultar libros existentes          *");
            System.out.println("* 2) Dar de alta nuevo libro              *");
            System.out.println("* 3) Actualizar datos de un libro         *");
            System.out.println("* 4) Eliminar libro (De la base de datos) *");
            System.out.println("* 5) Volver al Menú Principal             *");            
            System.out.println("*******************************************");            
            
            int opcion = leer.nextInt();
            switch(opcion){
                case 1: menuBusquedaDeLibros(salir);
                    break;
                case 2:
                       Libro libro = crearLibro();
                       lD.guardar(libro);
                    break;
                    
                case 3:
                        Libro libroAux;
                        System.out.println("Deberá elegir el libro a modificar por ISBN");
                        System.out.println("Ésta es la lista de libros:");
                        try {
                            System.out.println(lD.listarTodo());
                        } catch (Exception ex) {
                            System.out.println("No pudimos recuperar la lista de libros.\n Controle la conexión a la base de datos y pruebe de nuevo");;
                        }
                        System.out.println("ingrese el ISBN del libro a modificar");
                        try {
                            libroAux = lD.buscarPorIsbn(leer.nextLong());
                            System.out.println("Titulo actual: " + libroAux.getTitulo());
                            System.out.print("Ingrese el nuevo título:\n->");
                            leer.nextLine();
                            libroAux.setTitulo(leer.nextLine());
                            System.out.println("El año de edición es: " + libroAux.getAnio());
                            System.out.print("Ingrese el nuevo año de edicion: \n->");
                            libroAux.setAnio(leer.nextInt());
                            lD.editarLibro(libroAux);
                        } catch (Exception ex) {
                            System.out.println("Error al intentar leer o guardar cambios");
                        }
                    break;

                case 4:
//                        Libro libroAux2;
//                        System.out.println("Deberá elegir el autor a eliminar");
//                        System.out.println("Ésta es la lista de autores:");
//                        
//
//                        try {
//                            List<Autor> autores = aD.listarTodo();
//                            for (Autor autore : autores) {
//                                System.out.println(autore);
//                            }
//                        } catch (Exception ex) {
//                            Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
//                            System.out.println("No pudimos listar los autores. Pruebe conexión al servidor");
//                        }
//                        System.out.println("ingrese el ID del autor a eliminar");                  
//                        
//                        try {
//                             aD.eliminar(leer.nextInt());
//                        } catch (Exception ex) {
//                            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
//                            System.out.println("Error al intentar eliminar al autor. Los guardaespaldas se opusieron");
//                        }                    
//                    break;                    
                case 5: salir = true;
                    break;
                default: System.out.println("Qué pusiste? probá de nuevo. Las opciones van del 1 al 5, pelmaso!");
                
            }
            
            
        } while (!salir);   
        
}
            public Libro crearLibro(){
                       Libro libro = new Libro();
                       System.out.print("Vamos a crear un nuevo libro. \nPor favor, ingrese el ISBN\n->");
                       libro.setIsbn(leer.nextLong());
                       System.out.print("Ingrese el título del libro\n->");
                       leer.nextLine();
                       libro.setTitulo(leer.nextLine());
                       System.out.print("Ingrese cantidad de ejemplares disponibles\n->");
                       libro.setEjemplares(leer.nextInt());
                       System.out.print("Ingrese el año de edición: \n->");
                       libro.setAnio(leer.nextInt());
                       libro.setEjemplaresPrestados(0);
                       libro.setEjemplaresRestantes(libro.getEjemplares());
                       libro.setAlta(true);
                       return libro;
        }
    
}
