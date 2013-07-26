/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.entidades.Itemdiario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.to.ItemdiarioTO;
import java.util.List;

/**
 *
 * @author allen
 */
public interface ItemDiarioInterface {
    
    public Integer obtenerId();
    
    public void insertar(Itemdiario itemdiario);
    
    public List<ItemdiarioTO> listarItems(String usuario);
    
    public List<Itemdiario> listarItems(Requerimiento requerimiento);
    
    public List<Itemdiario> listarItems(String usuario_id, Integer requerimiento_id);
    
}
