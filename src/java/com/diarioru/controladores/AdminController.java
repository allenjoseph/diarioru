/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.controladores;

import com.diarioru.entidades.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev-pai-20
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @RequestMapping("/admin.html")
    public ModelAndView inicio(){
        ModelAndView modelo = new ModelAndView("Admin");
        agregarUsuario(modelo);
        modelo.addObject("usuario", new Usuario());
        return modelo;
    }
    
    private void agregarUsuario(ModelAndView modelo) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();        
        modelo.addObject("user", user.getUsername());
        modelo.addObject("role", user.getAuthorities().iterator().next().getAuthority());
    }
}
