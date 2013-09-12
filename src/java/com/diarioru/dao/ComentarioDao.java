/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Comentario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.to.ComentarioTO;
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
public class ComentarioDao extends HibernateDaoSupport implements ComentarioDaoInterface {

    @Autowired
    public ComentarioDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<ComentarioTO> getListComentario(String usuario) {
//        //UTILIZANDO OBJETOS TO PARA LISTAR LOS ITEMS DIARIOS
//        Session session = getHibernateTemplate().getSessionFactory().openSession();
//        Query consulta = session.createSQLQuery("SELECT i.comentario_id AS \"id\",\n"
//                + "       i.comentario AS \"comentario\",\n"
//                + "       to_char(i.fecha) AS \"fecha\",\n"
//                + "       r.codigo AS \"requerimiento_codigo\",\n"
//                + "       i.usuario_id AS \"usuario_id\"\n"
//                + "FROM   avelasco.comentario i,\n"
//                + "       avelasco.requerimiento r \n"
//                + "WHERE  r.requerimiento_id = i.requerimiento_id\n"
//                + "       AND i.usuario_id = ?")
//                .setParameter(0, usuario)
//                .setResultTransformer(Transformers.aliasToBean(ComentarioTO.class));
//        return consulta.list();
        return getHibernateTemplate().find("select i from Comentario i where i.usuario.codigo = ?", usuario);
    }

    @Override
    public List<Comentario> getListComentario(Requerimiento requerimiento) {
        return getHibernateTemplate().find("select i from Comentario i where i.padreId = ?", requerimiento.getCodigo());
    }

    @Override
    public List<Comentario> getListComentario(String usuario_id, String padre_id) {
        return getHibernateTemplate().find("select i from Comentario i where i.padreId = ? and i.usuario.codigo = ?", padre_id, usuario_id);
    }

    @Override
    public void insertarEnBase(Comentario comentario) {
        comentario.setComentarioId(nextId());
        getHibernateTemplate().save(comentario);
    }

    @Override
    public Integer obtenerId() {
        return (Integer) (getHibernateTemplate().find("select max(i.comentarioId) from Comentario i")).get(0) + 1;
    }

    private int nextId() {
        Session sesion = getHibernateTemplate().getSessionFactory().openSession();
        Query query = sesion.createSQLQuery("select max(comentario_id) from utp.comentario");
        return query.list().get(0) == null ? 1 : Integer.parseInt(query.list().get(0).toString()) + 1;
    }

    @Override
    public List<Comentario> listarSugerencias(String sprint) {
        return getHibernateTemplate().find("select c from Comentario c where c.padreId = ?", sprint);
    }
}
