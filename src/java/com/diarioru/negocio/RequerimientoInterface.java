/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.entidades.Requerimiento;
import java.util.List;

/**
 *
 * @author allen
 */
public interface RequerimientoInterface {
    
    public List<Requerimiento> listarRequerimientos();

    public Integer obtenerId();

    public void insertar(Requerimiento requerimiento);
    
    public List<Requerimiento> filtrarRequerimientos(String usuario);

    public List<String> buscarRequerimiento(String texto);
    
}
