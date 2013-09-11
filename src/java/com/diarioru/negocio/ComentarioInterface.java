/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.entidades.Comentario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.to.ComentarioTO;
import java.util.List;

/**
 *
 * @author allen
 */
public interface ComentarioInterface {
    
    public Integer obtenerId();
    
    public void insertar(Comentario comentario);
    
    public List<ComentarioTO> listarItems(String usuario);
    
    public List<Comentario> listarItems(Requerimiento requerimiento);
    
    public List<Comentario> listarItems(String usuario_id, String requerimiento_id);

    public void insertarSugerencias(List<Comentario> sugerencias);

    public List<Comentario> listarSugerencias();
    
}
