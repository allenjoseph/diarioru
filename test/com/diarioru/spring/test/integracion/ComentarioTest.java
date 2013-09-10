/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.spring.test.integracion;

import com.diarioru.dao.ComentarioDaoInterface;
import com.diarioru.dao.RequerimientoDaoInterface;
import com.diarioru.dao.UsuarioDaoInterface;
import com.diarioru.entidades.Usuario;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author dev-pai-20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ComentarioTest {
        
    private ComentarioDaoInterface comentarioDAO;
    private UsuarioDaoInterface usuarioDAO;
    private RequerimientoDaoInterface requerimientoDAO;

    public ComentarioTest() {
    }
    
    @Autowired
    public void setDAO(ComentarioDaoInterface comentarioDAO){
        this.comentarioDAO = comentarioDAO;
    }
    
    @Autowired
    public void setDAO(UsuarioDaoInterface usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }
    
    @Test
    public void testUsuario(){        
        usuarioDAO.insertarEnBase(TestFixture.user);        
        List<Usuario> userBase = usuarioDAO.getListUsuarios();                
        Assert.assertTrue(userBase.contains(TestFixture.user));
    }
}
