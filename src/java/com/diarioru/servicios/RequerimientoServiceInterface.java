/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Requerimiento;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface RequerimientoServiceInterface {

    public List<Requerimiento> listarRequerimientos();

    public Integer obtenerId();

    public void insertar(Requerimiento requerimiento);
    
    public List<Requerimiento> filtrarRequerimientos(String usuario);
}
