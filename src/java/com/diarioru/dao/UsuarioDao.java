/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Usuario;
import com.diarioru.util.Helper;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author allen
 */
@Repository
public class UsuarioDao extends HibernateDaoSupport implements UsuarioDaoInterface {

    @Autowired
    public UsuarioDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Transactional
    @Override
    public List<Usuario> getListUsuarios() {
        return getHibernateTemplate().find("select u from Usuario u");
    }

    @Override
    public void insertarEnBase(Usuario usuario) throws DataAccessException {
        
        List<Usuario> query = getHibernateTemplate().find("select u from Usuario u where u.codigo = ?", usuario.getCodigo());

        if (query != null && query.size() > 0) {
            Usuario user = (Usuario) query.get(0);
            
            if (usuario.getNombre() != null) {
                user.setNombre(usuario.getNombre());
            }
            if (usuario.getApellidoMaterno() != null) {
                user.setApellidoMaterno(usuario.getApellidoMaterno());
            }
            if (usuario.getApellidoPaterno() != null) {
                user.setApellidoPaterno(usuario.getApellidoPaterno());
            }
            if (usuario.getPassword() != null) {
                user.setPassword(Helper.md5(usuario.getPassword()));
            }
            getHibernateTemplate().saveOrUpdate(user);
        } else {
            usuario.setPassword(Helper.md5(usuario.getPassword()));
            getHibernateTemplate().save(usuario);
            Session session = getHibernateTemplate().getSessionFactory().openSession();
            Query consulta = session.createSQLQuery("insert into ROL_USUARIO (rol_id,usuario_id) values(2,?)")
                    .setParameter(0, usuario.getCodigo());
            consulta.executeUpdate();            
        }
    }
}
