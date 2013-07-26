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
public class ItemDiarioService {
    
    @Autowired
    private ItemDiarioInterface diarioInterface;    

    public ItemDiarioService() {
    }

    public void insertar(Itemdiario itemdiario) {
        diarioInterface.insertar(itemdiario);
    }

    public List<ItemdiarioTO> listarItems(String usuario) {
        return diarioInterface.listarItems(usuario);
    }

    public List<Itemdiario> listarItems(Requerimiento requerimiento) {
        return diarioInterface.listarItems(requerimiento);
    }

    public Integer obtenerId() {
        return diarioInterface.obtenerId();
    }

    public List<Itemdiario> listarItems(String usuario_id, Integer requerimiento_id) {
        return diarioInterface.listarItems(usuario_id, requerimiento_id);
    }
    
    public ItemDiarioInterface getDiarioInterface() {
        return diarioInterface;
    }

    public void setDiarioInterface(ItemDiarioInterface diarioInterface) {
        this.diarioInterface = diarioInterface;
    }
}
