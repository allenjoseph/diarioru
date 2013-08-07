/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Requerimiento;
import com.diarioru.negocio.RequerimientoInterface;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface RequerimientoServiceInterface {

    public List<Requerimiento> listarRequerimientos();

    public Integer obtenerId();

    public RequerimientoInterface getRequerimientoInterface();

    public void setRequerimientoInterface(RequerimientoInterface requerimientoInterface);

    public void insertar(Requerimiento requerimiento);
}
