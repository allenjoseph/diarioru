/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.to;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author dev-pai-20
 */
public class ComentarioTO implements Serializable {

    private BigDecimal id;
    private String fecha;
    private String comentario;
    private String usuario_id;
    private String requerimiento_codigo;

    public ComentarioTO() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
  
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getRequerimiento_codigo() {
        return requerimiento_codigo;
    }

    public void setRequerimiento_codigo(String requerimiento_codigo) {
        this.requerimiento_codigo = requerimiento_codigo;
    }

       
    
}
