/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.dao.ComentarioDaoInterface;
import com.diarioru.entidades.Comentario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.entidades.Usuario;
import com.diarioru.to.ComentarioTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 */
@Component
public class ComentarioImplements implements ComentarioInterface {

    @Autowired
    private ComentarioDaoInterface comentarioDAO;
    
    @Autowired
    private SprintInterface sprintInterface;

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

    @Override
    public void insertarSugerencias(List<Comentario> sugerencias) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();        
        for(Comentario sugerencia : sugerencias){
            sugerencia.setUsuario(new Usuario(user.getUsername()));
            sugerencia.setPadreId(sprintInterface.obtenerSprint().getSprintPK().toString());
            comentarioDAO.insertarEnBase(sugerencia);
        }
    }

    @Override
    public List<Comentario> listarSugerencias() {
        String sprint = sprintInterface.obtenerSprint().getSprintPK().toString();
        return comentarioDAO.listarSugerencias(sprint);
    }
}
