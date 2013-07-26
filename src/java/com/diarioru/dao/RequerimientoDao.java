/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Requerimiento;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.SessionFactory;
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
public class RequerimientoDao extends HibernateDaoSupport {

    @Autowired
    public RequerimientoDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public List<Requerimiento> getListRequerimientos() {
        return getHibernateTemplate().find("select r from Requerimiento r order by r.fecha_creacion");
    }

    public Integer obtenerId() {
        return (Integer) (getHibernateTemplate().find("select max(r.requerimientoId) from Requerimiento r")).get(0) + 1;
    }

    public void insertar(Requerimiento requerimiento) {
        Integer correlativo = (Integer) getHibernateTemplate().find("select max(r.correlativo) from Requerimiento r where r.tipo = ?", requerimiento.getTipo()).get(0) + 1;
        requerimiento.setCorrelativo(correlativo);
        requerimiento.setAnio(Integer.parseInt((new SimpleDateFormat("yyyy")).format(requerimiento.getFecha_creacion())));
        requerimiento.setCodigo(requerimiento.getTipo() + "-" + String.format("%03d", requerimiento.getCorrelativo()) + "-" + requerimiento.getAnio());
        getHibernateTemplate().save(requerimiento);
    }

    public String obtenerCodigo(String tipo) {
        return "";
    }
}