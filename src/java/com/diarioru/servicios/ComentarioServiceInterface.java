/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Comentario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.negocio.ComentarioInterface;
import com.diarioru.to.ComentarioTO;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface ComentarioServiceInterface {
    
    public void insertar(Comentario comentario);

    public List<ComentarioTO> listarItems(String usuario);

    public List<Comentario> listarItems(Requerimiento requerimiento);

    public Integer obtenerId();

    public List<Comentario> listarItems(String usuario_id, String requerimiento_id);

}
