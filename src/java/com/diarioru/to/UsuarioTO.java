/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.to;

/**
 *
 * @author dev-pai-20
 */
public class UsuarioTO {
    
    private String usuarioId;    
    private String nombre;

    public UsuarioTO() {
    }
    
    public UsuarioTO(String usuarioId, String nombre) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
