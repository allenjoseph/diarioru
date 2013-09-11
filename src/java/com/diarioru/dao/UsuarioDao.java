/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.dao;

import com.diarioru.entidades.Usuario;
import java.util.List;
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
public class UsuarioDao extends HibernateDaoSupport implements UsuarioDaoInterface{

    @Autowired
    public UsuarioDao(SessionFactory sessionFactory) {
       super.setSessionFactory(sessionFactory);
    }
    
    @Transactional
    @Override
    public List<Usuario> getListUsuarios(){
        return getHibernateTemplate().find("select u from Usuario u");
    }

    @Override
    public void insertarEnBase(Usuario usuario) throws DataAccessException{
        Usuario user = (Usuario)getHibernateTemplate().find("select u from Usuario u where u.codigo = ?",usuario.getCodigo()).get(0);
        if(!usuario.getNombre().isEmpty())
            user.setNombre(usuario.getNombre());
        if(!usuario.getApellidoMaterno().isEmpty())
            user.setNombre(usuario.getApellidoMaterno());
        if(!usuario.getApellidoPaterno().isEmpty())
            user.setNombre(usuario.getApellidoPaterno());
        if(!usuario.getPassword().isEmpty())
            user.setNombre(usuario.getPassword());
        getHibernateTemplate().saveOrUpdate(user);
    }
    
}
