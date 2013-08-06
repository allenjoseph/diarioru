/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.servicios;

import com.diarioru.entidades.Itemdiario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.negocio.ItemDiarioInterface;
import com.diarioru.to.ItemdiarioTO;
import java.util.List;

/**
 *
 * @author dev-pai-20
 */
public interface ItemDiarioServiceInterface {
    
    public void insertar(Itemdiario itemdiario);

    public List<ItemdiarioTO> listarItems(String usuario);

    public List<Itemdiario> listarItems(Requerimiento requerimiento);

    public Integer obtenerId();

    public List<Itemdiario> listarItems(String usuario_id, Integer requerimiento_id);
    
    public ItemDiarioInterface getDiarioInterface();

    public void setDiarioInterface(ItemDiarioInterface diarioInterface);
}
