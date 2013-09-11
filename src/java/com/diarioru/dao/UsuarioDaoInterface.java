/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Usuario;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface UsuarioDaoInterface {

    public List<Usuario> getListUsuarios();
    
    public void insertarEnBase(Usuario usuario);
}
