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
    private ComentarioInterface diarioInterface;    

    public ComentarioService() {
    }

    @Override
    public void insertar(Comentario comentario) {
        diarioInterface.insertar(comentario);
    }

    @Override
    public List<ComentarioTO> listarItems(String usuario) {
        return diarioInterface.listarItems(usuario);
    }

    @Override
    public List<Comentario> listarItems(Requerimiento requerimiento) {
        return diarioInterface.listarItems(requerimiento);
    }

    @Override
    public Integer obtenerId() {
        return diarioInterface.obtenerId();
    }

    @Override
    public List<Comentario> listarItems(String usuario_id, String requerimiento_id) {
        return diarioInterface.listarItems(usuario_id, requerimiento_id);
    }

    public ComentarioInterface getDiarioInterface() {
        return diarioInterface;
    }

    public void setDiarioInterface(ComentarioInterface diarioInterface) {
        this.diarioInterface = diarioInterface;
    }
}
