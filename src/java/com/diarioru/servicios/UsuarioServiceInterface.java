/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Usuario;
import com.diarioru.negocio.UsuarioInterface;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface UsuarioServiceInterface {
    
    public List<Usuario> listarUsuarios();

    public UsuarioInterface getUsuarioInterface();

    public void setUsuarioInterface(UsuarioInterface usuarioInterface);
}
