package persistencia;

import java.util.List;
import libreria.entidades.Libro;

public class LibroDAO extends DAO<Libro> {
    
    @Override
    public void guardar(Libro libro){
        super.guardar(libro);
    }
    
        public void editarLibro(Libro libro){

            try {
                super.editar(libro);
                System.out.println("Datos actualizados con éxito");
            } catch (Exception ex) {
                System.out.println("No pudimos guardar los cambios");
            }
        
    }
    
    public void eliminar(Long isbn) throws Exception{
        Libro libro = buscarPorIsbn(isbn);
        super.eliminar(libro);
    }
    
    public Libro buscarPorIsbn(Long isbn) throws Exception{
        conectar();
        Libro libro = em.find(Libro.class, isbn);
        desconectar();
        return libro;
    }
    
    public List<Libro> listarTodo() throws Exception{
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;
    }
    
    
    
}
