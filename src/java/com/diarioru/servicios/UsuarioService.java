/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Usuario;
import com.diarioru.negocio.UsuarioInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allen
 */
@Service
public class UsuarioService implements UsuarioServiceInterface{
    
    @Autowired
    private UsuarioInterface usuarioInterface;

    public UsuarioService() {
    }    
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioInterface.listarUsuarios();
    }

    @Override
    public UsuarioInterface getUsuarioInterface() {
        return usuarioInterface;
    }

    @Override
    public void setUsuarioInterface(UsuarioInterface usuarioInterface) {
        this.usuarioInterface = usuarioInterface;
    }       
    
}
