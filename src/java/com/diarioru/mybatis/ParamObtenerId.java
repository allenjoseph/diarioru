/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.mybatis;

/**
 *
 * @author dev-pai-20
 */
public class ParamObtenerId {
    private String nombre_tabla;
    private Integer next_val;

    public ParamObtenerId() {
    }

    public String getNombre_tabla() {
        return nombre_tabla;
    }

    public void setNombre_tabla(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
    }

    public Integer getNext_val() {
        return next_val;
    }

    public void setNext_val(Integer next_val) {
        this.next_val = next_val;
    }

}
