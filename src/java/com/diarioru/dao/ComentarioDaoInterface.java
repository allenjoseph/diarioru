/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Comentario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.to.ComentarioTO;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface ComentarioDaoInterface {
    
    public List<ComentarioTO> getListComentario(String usuario);

    public List<Comentario> getListComentario(Requerimiento requerimiento);
    
    public List<Comentario> getListComentario(String usuario_id,String requerimiento_id);

    public void insertarEnBase(Comentario comentario);

    public Integer obtenerId();
}
