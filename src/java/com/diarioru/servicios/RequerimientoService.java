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
public class RequerimientoService implements RequerimientoServiceInterface{

    @Autowired
    private RequerimientoInterface requerimientoInterface;

    public RequerimientoService() {
    }

    @Override
    public List<Requerimiento> listarRequerimientos() {
        return requerimientoInterface.listarRequerimientos();
    }

    @Override
    public Integer obtenerId() {
        return this.requerimientoInterface.obtenerId();
    }

    @Override
    public RequerimientoInterface getRequerimientoInterface() {
        return requerimientoInterface;
    }

    @Override
    public void setRequerimientoInterface(RequerimientoInterface requerimientoInterface) {
        this.requerimientoInterface = requerimientoInterface;
    }

    @Override
    public void insertar(Requerimiento requerimiento) {
        this.requerimientoInterface.insertar(requerimiento);        
    }
}
