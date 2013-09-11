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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allen
 */
@Service
public class ComentarioService implements ComentarioServiceInterface{
    
    @Autowired
    private ComentarioInterface comentarioInterface;    

    public ComentarioService() {
    }

    @Override
    public void insertar(Comentario comentario) {
        comentarioInterface.insertar(comentario);
    }

    @Override
    public List<ComentarioTO> listarItems(String usuario) {
        return comentarioInterface.listarItems(usuario);
    }

    @Override
    public List<Comentario> listarItems(Requerimiento requerimiento) {
        return comentarioInterface.listarItems(requerimiento);
    }

    @Override
    public Integer obtenerId() {
        return comentarioInterface.obtenerId();
    }

    @Override
    public List<Comentario> listarItems(String usuario_id, String requerimiento_id) {
        return comentarioInterface.listarItems(usuario_id, requerimiento_id);
    }

    public ComentarioInterface getDiarioInterface() {
        return comentarioInterface;
    }

    public void setDiarioInterface(ComentarioInterface diarioInterface) {
        this.comentarioInterface = diarioInterface;
    }

    @Override
    public void insertarSugerencias(List<Comentario> sugerencias) {
        comentarioInterface.insertarSugerencias(sugerencias);
    }

    @Override
    public List<Comentario> listarSugerencias() {
        return comentarioInterface.listarSugerencias();
    }
}
