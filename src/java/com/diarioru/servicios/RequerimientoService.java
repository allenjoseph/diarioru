/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Requerimiento;
import com.diarioru.negocio.RequerimientoInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allen
 */
@Service
public class RequerimientoService {

    @Autowired
    private RequerimientoInterface requerimientoInterface;

    public RequerimientoService() {
    }

    public List<Requerimiento> listarRequerimientos() {
        return requerimientoInterface.listarRequerimientos();
    }

    public Integer obtenerId() {
        return this.requerimientoInterface.obtenerId();
    }

    public RequerimientoInterface getRequerimientoInterface() {
        return requerimientoInterface;
    }

    public void setRequerimientoInterface(RequerimientoInterface requerimientoInterface) {
        this.requerimientoInterface = requerimientoInterface;
    }

    public void insertar(Requerimiento requerimiento) {
        this.requerimientoInterface.insertar(requerimiento);        
    }
}
