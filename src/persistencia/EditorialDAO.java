package persistencia;

import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial>{
    
    @Override
    public void guardar(Editorial editorial){
        super.guardar(editorial);
    }
    
    public void eliminar(Integer id) throws Exception{
        Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    }
    
    public Editorial buscarPorId(Integer id) throws Exception{
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }
    
    public List<Editorial> listarTodo() throws Exception{
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;
    }
}



