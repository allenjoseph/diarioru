/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.dao.RequerimientoDao;
import com.diarioru.entidades.Requerimiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 */
@Component
public class RequerimientoImplements implements RequerimientoInterface{
    
    @Autowired
    private RequerimientoDao requerimientoDAO;

    @Override
    public List<Requerimiento> listarRequerimientos() {
        return requerimientoDAO.getListRequerimientos();
    }    

    @Override
    public Integer obtenerId() {
        return requerimientoDAO.obtenerId();
    }

    @Override
    public void insertar(Requerimiento requerimiento) {
        requerimientoDAO.insertar(requerimiento);
    }
    
}
