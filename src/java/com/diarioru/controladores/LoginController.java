/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.controladores;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev-pai-20
 */
@Controller
public class LoginController {
        
    @RequestMapping(value = "/logon.html", method = RequestMethod.GET)
    public ModelAndView logon(HttpServletRequest request){
        String error = request.getParameter("login_error");
        ModelAndView modelo = new ModelAndView("Login");
        modelo.addObject("error", error);
        return modelo;
    }
}
