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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allen
 */
@Service
public class ItemDiarioService implements ItemDiarioServiceInterface{
    
    @Autowired
    private ItemDiarioInterface diarioInterface;    

    public ItemDiarioService() {
    }

    @Override
    public void insertar(Itemdiario itemdiario) {
        diarioInterface.insertar(itemdiario);
    }

    @Override
    public List<ItemdiarioTO> listarItems(String usuario) {
        return diarioInterface.listarItems(usuario);
    }

    @Override
    public List<Itemdiario> listarItems(Requerimiento requerimiento) {
        return diarioInterface.listarItems(requerimiento);
    }

    @Override
    public Integer obtenerId() {
        return diarioInterface.obtenerId();
    }

    @Override
    public List<Itemdiario> listarItems(String usuario_id, Integer requerimiento_id) {
        return diarioInterface.listarItems(usuario_id, requerimiento_id);
    }
    
    @Override
    public ItemDiarioInterface getDiarioInterface() {
        return diarioInterface;
    }

    @Override
    public void setDiarioInterface(ItemDiarioInterface diarioInterface) {
        this.diarioInterface = diarioInterface;
    }
}
