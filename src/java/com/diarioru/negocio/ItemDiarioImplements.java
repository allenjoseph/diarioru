/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.negocio;

import com.diarioru.dao.ItemdiarioDao;
import com.diarioru.entidades.Itemdiario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.entidades.Usuario;
import com.diarioru.to.ItemdiarioTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 */
@Component
public class ItemDiarioImplements implements ItemDiarioInterface {

    @Autowired
    private ItemdiarioDao itemDiarioDAO;

    @Override
    public void insertar(Itemdiario itemdiario) {
        itemDiarioDAO.insertarEnBase(itemdiario);
    }

    @Override
    public List<ItemdiarioTO> listarItems(String usuario) {
        return itemDiarioDAO.getListItemdiario(usuario);
    }

    @Override
    public List<Itemdiario> listarItems(Requerimiento requerimiento) {
        return itemDiarioDAO.getListItemdiario(requerimiento);
    }

    @Override
    public List<Itemdiario> listarItems(String usuario_id, Integer requerimiento_id) {
        return itemDiarioDAO.getListItemdiario(usuario_id, requerimiento_id);
    }

    @Override
    public Integer obtenerId() {
        return itemDiarioDAO.obtenerId();
    }
}
