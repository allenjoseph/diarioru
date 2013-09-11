/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.spring.test.integracion;

import com.diarioru.entidades.Usuario;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author dev-pai-20
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.diarioru.spring.test.integracion.ComentarioTest.class})
public class TestFixture {
    
    public static Usuario user;
        
    @BeforeClass
    public static void Setup(){
    }
    
    @AfterClass
    public static void TearDown(){
        
    }
    
    @Before
    public static void Setupp(){
    }
    
    
}