/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Requerimiento;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
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
public class RequerimientoDao extends HibernateDaoSupport implements RequerimientoDaoInterface{

    @Autowired
    public RequerimientoDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Requerimiento> getListRequerimientos() {
        return getHibernateTemplate().find("select r from Requerimiento r order by r.fecha_creacion desc");
    }
    
    @Override
    public List<Requerimiento> filtrarRequerimientos(String usuario) {
        return getHibernateTemplate().find("select r from Requerimiento r  where r.usuario.codigo = ? order by r.fecha_creacion desc",usuario);
    }

    @Override
    public Integer obtenerId() {
        return (Integer) (getHibernateTemplate().find("select max(r.requerimientoId) from Requerimiento r")).get(0) + 1;
    }

    @Override
    public void insertar(Requerimiento requerimiento) {
        Calendar hoy = Calendar.getInstance();
        Session sesion = getHibernateTemplate().getSessionFactory().openSession();
        Query query = sesion.createSQLQuery("select ultimo from REQ_SIG where tipo = ?")
                .setParameter(0, requerimiento.getTipo());
        int ultimoId = query.list().size() > 0 ? Integer.parseInt(query.list().get(0).toString()) : 1;
        String nextId = String.format("%03d",ultimoId);
        
        requerimiento.setCodigo(String.format("%s-%s-%d",requerimiento.getTipo(),nextId,hoy.get(Calendar.YEAR)));
        requerimiento.setFecha_creacion(new Date());
        
        getHibernateTemplate().save(requerimiento);
        Query query2 = sesion.createSQLQuery(ultimoId > 1 ? "update REQ_SIG set ultimo = ? where tipo = ?":"insert into REQ_SIG (ultimo,tipo) values(?,?)")
                .setParameter(0, ultimoId)
                .setParameter(1, requerimiento.getTipo());
        query2.executeUpdate();  
    }

    @Override
    public String obtenerCodigo(String tipo) {
        return "";
    }
}
