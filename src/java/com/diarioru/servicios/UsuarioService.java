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
public class UsuarioService {
    
    @Autowired
    private UsuarioInterface usuarioInterface;

    public UsuarioService() {
    }    
    
    public List<Usuario> listarUsuarios() {
        return usuarioInterface.listarUsuarios();
    }

    public UsuarioInterface getUsuarioInterface() {
        return usuarioInterface;
    }

    public void setUsuarioInterface(UsuarioInterface usuarioInterface) {
        this.usuarioInterface = usuarioInterface;
    }       
    
}
