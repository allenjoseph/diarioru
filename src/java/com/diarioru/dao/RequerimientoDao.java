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
public class RequerimientoDao extends HibernateDaoSupport implements RequerimientoDaoInterface {

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
        return getHibernateTemplate().find("select r from Requerimiento r  where r.usuario.codigo = ? order by r.fecha_creacion desc", usuario);
    }

    @Override
    public Integer obtenerId() {
        return (Integer) (getHibernateTemplate().find("select max(r.requerimientoId) from Requerimiento r")).get(0) + 1;
    }

    @Override
    public void insertar(Requerimiento requerimiento) {
        Calendar hoy = Calendar.getInstance();
        Session sesion = getHibernateTemplate().getSessionFactory().openSession();
        String nextId = String.format("%03d", nextId(sesion,requerimiento.getTipo()));
        
        requerimiento.setCodigo(String.format("%s-%s-%d",requerimiento.getTipo(),nextId,hoy.get(Calendar.YEAR)));
        requerimiento.setEstado("S");
        requerimiento.setFecha_creacion(new Date());
        getHibernateTemplate().save(requerimiento);
        
        Query update = sesion.createSQLQuery("update utp.pases set n_numcor = ? where n_codano = ? and c_codreq = ?")
                .setParameter(0, nextId)
                .setParameter(1, hoy.get(Calendar.YEAR))
                .setParameter(2, requerimiento.getTipo());
        update.executeUpdate();        
    }

    @Override
    public String obtenerCodigo(String tipo) {
        return "";
    }
    
    private int nextId(Session sesion, String tipo){
        Calendar hoy = Calendar.getInstance();        
        Query query = sesion.createSQLQuery("SELECT t_pases.n_numcor + 1\n"
                + "FROM   utp.pases t_pases\n"
                + "WHERE  t_pases.n_codano = ?\n"
                + "       AND t_pases.c_codreq = ?")
                .setParameter(0, hoy.get(Calendar.YEAR))
                .setParameter(1, tipo);
        return Integer.parseInt(query.list().get(0).toString());
    }
}
