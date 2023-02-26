package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Autor;
import persistencia.AutorDAO;

public class AutoServicio {
    
    Scanner leer = new Scanner(System.in);
    AutorDAO aD = new AutorDAO();
    
    public void menuAutor(boolean salir){
    
        do {
            System.out.println("*******************************************");
            System.out.println("*              MENÚ AUTORES               *");
            System.out.println("*******************************************");     
            System.out.println("* 1) Consultar autores registrados        *");
            System.out.println("* 2) Dar de alta nuevo autor              *");
            System.out.println("* 3) Actualizar datos de autor            *");
            System.out.println("* 4) Eliminar autor (De la base de datos) *");
            System.out.println("* 5) Buscar autor por nombre              *");              
            System.out.println("* 6) Volver al Menú Principal             *");            
            System.out.println("*******************************************");            
            
            int opcion = leer.nextInt();
            switch(opcion){
                case 1: 
                {
                    try {
                        List<Autor> autores = aD.listarTodo();
                        for (Autor autore : autores) {
                            if(autore.getAlta()){
                            System.out.println(autore);
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("No funcionó. Probá otra cosa.\n Esto es lo que arroja JAVA:");
                        Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("El show debe continuar. ¿Qué más podemos intentar?");
                    }
                }
                    break;

                case 2:

                    System.out.println("Por favor, ingrese el nombre del autor");
                    leer.nextLine();
                    aD.guardar(new Autor(leer.nextLine(), true));
                    
                    break;
                case 3:
                        Autor autorAux;
                        System.out.println("Deberá elegir el autor a modificar");
                        System.out.println("Ésta es la lista de autores:");
                        try {
                            System.out.println(aD.listarTodo());
                        } catch (Exception ex) {
                            Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("ingrese el ID del autor a modificar");                  
                        
                        try {
                            autorAux = aD.buscarPorId(leer.nextInt());
                            System.out.println("Ingrese el nuevo nombre para el autor a modificar");
                            leer.nextLine();
                            autorAux.setNombre(leer.nextLine());
                            aD.editarAutor(autorAux);
                        } catch (Exception ex) {
                            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error al intentar leer o guardar nuevo nombre del autor");
                        }
                    break;

                case 4:
                        Autor autorAux2;
                        System.out.println("Deberá elegir el autor a eliminar");
                        System.out.println("Ésta es la lista de autores:");
                        

                        try {
                            List<Autor> autores = aD.listarTodo();
                            for (Autor autore : autores) {
                                System.out.println(autore);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("No pudimos listar los autores. Pruebe conexión al servidor");
                        }
                        System.out.println("ingrese el ID del autor a eliminar");                  
                        
                        try {
                             aD.eliminar(leer.nextInt());
                        } catch (Exception ex) {
                            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error al intentar eliminar al autor. Los guardaespaldas se opusieron");
                        }                    
                    break;    
                
                    
                case 5:{ // estamos trayendo toda la base de autores y luego mostrando el que tiene nombre coincidente. Se puede hacer consultando la base con when
                    System.out.println("Por favor, ingrese el nombre del autor a buscar");
                    String nombreAutor = leer.nextLine();
                    try {
                            List<Autor> autores = aD.listarTodo();
                            for (Autor autore : autores) {
                                if(autore.getAlta() && autore.getNombre().equalsIgnoreCase(nombreAutor)){
                                System.out.println(autore);
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("No funcionó. Probá otra cosa.\n Esto es lo que arroja JAVA:");
                            Logger.getLogger(AutoServicio.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("El show debe continuar. ¿Qué más podemos intentar?");
                        }
                        }
                        break;
                    
                    
                case 6: salir = true;
                break;
                default: System.out.println("Qué pusiste? probá de nuevo. Las opciones van del 1 al 4, pelmaso!");
                
            }
            
            
        } while (!salir);
    
}
    
}
