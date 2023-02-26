package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Autor;

public class AutorDAO extends DAO<Autor>{
    
        @Override
    public void guardar(Autor autor){
        super.guardar(autor);
    }
    
    public void eliminar(Integer id) throws Exception{ //Esta función llama a editar y modifica atributo boolean "alta"
        
        Autor autorAux = buscarPorId(id);
        autorAux.setAlta(Boolean.FALSE);
        editarAutor(autorAux);
//        super.eliminar(buscarPorId(id));   // Con esta línea podríamos eliminar el elemento en vez de desactivarlo
    }
    
    public Autor buscarPorId(Integer id) throws Exception{
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }
    
    public List<Autor> listarTodo() throws Exception{
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;
    }
    
    public void editarAutor(Autor autor){

            try {
                super.editar(autor);
                System.out.println("Datos actualizados con éxito");
            } catch (Exception ex) {
                Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No pudimos guardar los cambios");
            }
        
    }
    
}
