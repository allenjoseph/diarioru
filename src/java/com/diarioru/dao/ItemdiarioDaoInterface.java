/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Itemdiario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.to.ItemdiarioTO;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface ItemdiarioDaoInterface {
    
    public List<ItemdiarioTO> getListItemdiario(String usuario);

    public List<Itemdiario> getListItemdiario(Requerimiento requerimiento);
    
    public List<Itemdiario> getListItemdiario(String usuario_id,Integer requerimiento_id);

    public void insertarEnBase(Itemdiario itemdiario);

    public Integer obtenerId();
}
