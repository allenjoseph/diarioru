/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.dao.UsuarioDaoInterface;
import com.diarioru.entidades.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 */
@Component
public class UsuarioImplements implements UsuarioInterface{

    @Autowired
    private UsuarioDaoInterface usuarioDAO;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.getListUsuarios();
    }   
    
}
