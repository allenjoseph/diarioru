/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Requerimiento;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface RequerimientoDaoInterface {

    public List<Requerimiento> getListRequerimientos();

    public Integer obtenerId();

    public void insertar(Requerimiento requerimiento);

    public String obtenerCodigo(String tipo);
}
