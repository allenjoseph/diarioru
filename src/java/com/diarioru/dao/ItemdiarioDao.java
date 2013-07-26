/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Itemdiario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.entidades.Usuario;
import com.diarioru.to.ItemdiarioTO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author allen
 */
@Repository
@Transactional
public class ItemdiarioDao extends HibernateDaoSupport {

    @Autowired
    public ItemdiarioDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public List<ItemdiarioTO> getListItemdiario(String usuario) {
        //UTILIZANDO OBJETOS TO PARA LISTAR LOS ITEMS DIARIOS
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Query consulta = session.createSQLQuery("SELECT i.itemdiario_id AS \"id\",\n"
                + "       i.comentario AS \"comentario\",\n"
                + "       to_char(i.fecha) AS \"fecha\",\n"
                + "       r.codigo AS \"requerimiento_codigo\",\n"
                + "       i.usuario_id AS \"usuario_id\"\n"
                + "FROM   avelasco.itemdiario i,\n"
                + "       avelasco.requerimiento r \n"
                + "WHERE  r.requerimiento_id = i.requerimiento_id\n"
                + "       AND i.usuario_id = ?")
                .setParameter(0, usuario)
                .setResultTransformer(Transformers.aliasToBean(ItemdiarioTO.class));
        return consulta.list();
    }

    public List<Itemdiario> getListItemdiario(Requerimiento requerimiento) {
        return getHibernateTemplate().find("select i from Itemdiario i where i.requerimiento = ?", requerimiento);
    }
    
    public List<Itemdiario> getListItemdiario(String usuario_id,Integer requerimiento_id) {
        return getHibernateTemplate().find("select i from Itemdiario i where i.requerimiento.requerimientoId = ? and i.usuario.usuarioId = ?", requerimiento_id,usuario_id);
    }

    public void insertarEnBase(Itemdiario itemdiario) {
        getHibernateTemplate().save(itemdiario);
    }

    public Integer obtenerId() {
        return (Integer) (getHibernateTemplate().find("select max(i.itemdiarioId) from Itemdiario i")).get(0) + 1;
    }
}
