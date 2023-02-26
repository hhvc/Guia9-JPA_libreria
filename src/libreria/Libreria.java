package libreria;

import java.util.Scanner;
import libreria.servicios.AutoServicio;
import libreria.servicios.LibroServicio;

public class Libreria {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        AutoServicio aS = new AutoServicio();
        LibroServicio lS = new LibroServicio();
        boolean salir = false;
        
       
        do {
            System.out.println("*******************************************");
            System.out.println("*             MENÚ PRINCIPAL              *");
            System.out.println("*******************************************");     
            System.out.println("* 1) Menú Mantenimiento de AUTORES        *");
            System.out.println("* 2) Menú Mantenimiento de Editoriales    *");
            System.out.println("* 3) Menú Mantenimiento de Libros         *");
            System.out.println("* 4) Salir de la aplicación               *");            
            System.out.println("*******************************************");            
            
            int opcion = leer.nextInt();
            switch(opcion){
                case 1: aS.menuAutor(salir);
                    break;
                case 2: 
                    break;
                case 3:
                    lS.menuLibro(salir);
                    break;
                case 4: salir = true;
                    System.out.println("Gracias por usar nuestros servicios. Le enviaremos una encuesta rompehuevos por WS");
                break;
                default: System.out.println("Qué pusiste? probá de nuevo. Las opciones van del 1 al 4, pelmaso!");
                
            }
            
            
        } while (!salir);
 
        
        
        

    }
    
}
