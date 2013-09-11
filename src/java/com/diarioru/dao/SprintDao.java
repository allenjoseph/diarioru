/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Sprint;
import com.diarioru.entidades.embedded.SprintPK;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dev-pai-20
 */
@Repository
public class SprintDao extends HibernateDaoSupport implements SprintDaoInterface {

    @Autowired
    public SprintDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public Sprint obtenerSprint() {
        Session sesion = getHibernateTemplate().getSessionFactory().openSession();
        Query query = sesion.createSQLQuery("select max(release) release, max(numero) sprint from utp.sprint");
        List<Object[]> rows = query.list();
        System.out.println();

        int release = Integer.parseInt(rows.get(0)[0].toString());
        int sprint = Integer.parseInt(rows.get(0)[1].toString());
        SprintPK pk = new SprintPK("SYSONE", release, sprint);

        return (Sprint) getHibernateTemplate().find("select s from Sprint s where s.sprintPK.release = ? and s.sprintPK.numero = ?", release, sprint).get(0);
    }

    @Override
    public List<Sprint> listarSprints() {
        return getHibernateTemplate().find("select s from Sprint s");
    }
}
