/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.dao.ComentarioDaoInterface;
import com.diarioru.entidades.Comentario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.to.ComentarioTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 */
@Component
public class ComentarioImplements implements ComentarioInterface {

    @Autowired
    private ComentarioDaoInterface comentarioDAO;

    @Override
    public void insertar(Comentario comentario) {
        comentarioDAO.insertarEnBase(comentario);
    }

    @Override
    public List<ComentarioTO> listarItems(String usuario) {
        return comentarioDAO.getListComentario(usuario);
    }

    @Override
    public List<Comentario> listarItems(Requerimiento requerimiento) {
        return comentarioDAO.getListComentario(requerimiento);
    }

    @Override
    public List<Comentario> listarItems(String usuario_id, String requerimiento_id) {
        return comentarioDAO.getListComentario(usuario_id, requerimiento_id);
    }

    @Override
    public Integer obtenerId() {
        return comentarioDAO.obtenerId();
    }
}
