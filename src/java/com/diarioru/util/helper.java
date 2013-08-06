/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev-pai-20
 */
public class helper {
    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    static String formatearFecha(Calendar fecha){
        return dateFormat.format(fecha);
    }
    
    public static ModelAndView crearModelo(String view) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelo = new ModelAndView(view);               
        modelo.addObject("user", user.getUsername());
        modelo.addObject("role", user.getAuthorities().iterator().next().getAuthority());
        
        return modelo;
    }
}
