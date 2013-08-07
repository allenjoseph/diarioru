/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.controladores;

import com.diarioru.entidades.Usuario;
import com.diarioru.util.helper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author allen
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @RequestMapping(value = "/usuario.html")
    public ModelAndView usuario(){
        ModelAndView modelo = helper.crearModelo("AdminUsuario");  
        modelo.addObject("usuario", new Usuario());
        return modelo;
    }
}
