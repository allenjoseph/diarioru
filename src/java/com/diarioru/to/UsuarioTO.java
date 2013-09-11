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
    
    private String codigo;    
    private String nombre;

    public UsuarioTO() {
    }
    
    public UsuarioTO(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
