/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.to;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dev-pai-20
 */
public class RequerimientoTO implements Serializable{
    private Integer id;
    private String codigo;
    private String titulo;
    private Date fecha_creacion;

    public RequerimientoTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    
}
