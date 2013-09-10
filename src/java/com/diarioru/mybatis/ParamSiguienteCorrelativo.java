/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.mybatis;

/**
 *
 * @author dev-pai-20
 */
public class ParamSiguienteCorrelativo {
    private String tipo_requerimiento;
    private Integer siguiente_correlativo;

    public ParamSiguienteCorrelativo() {
    }

    public String getTipo_requerimiento() {
        return tipo_requerimiento;
    }

    public void setTipo_requerimiento(String tipo_requerimiento) {
        this.tipo_requerimiento = tipo_requerimiento;
    }

    public Integer getSiguiente_correlativo() {
        return siguiente_correlativo;
    }

    public void setSiguiente_correlativo(Integer siguiente_correlativo) {
        this.siguiente_correlativo = siguiente_correlativo;
    }
    
    
}
