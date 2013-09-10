/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.controladores;

import com.diarioru.entidades.Sprint;
import com.diarioru.entidades.Usuario;
import com.diarioru.servicios.UsuarioServiceInterface;
import com.diarioru.util.ExcepcionNegocio;
import com.diarioru.util.Helper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev-pai-20
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UsuarioServiceInterface usuarioService;

    @RequestMapping(value = "/usuarios.html")
    public ModelAndView inicio() {
        ModelAndView modelo = new ModelAndView("Usuario");
        Helper.agregarUsuario(modelo);
        modelo.addObject("usuario", new Usuario());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        return modelo;
    }

    @RequestMapping(value = "/sprints.html")
    public ModelAndView spring() {
        ModelAndView modelo = new ModelAndView("Sprint");
        Helper.agregarUsuario(modelo);
        modelo.addObject("sprint", new Sprint());
        modelo.addObject("sprints",null);
        return modelo;
    }

    @RequestMapping(value = "/add-usuario.html")
    public ModelAndView addUsuario(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView modelo = new ModelAndView("Usuario");
        Helper.agregarUsuario(modelo);
        modelo.addObject("usuario", new Usuario());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        try {
            usuarioService.insertarUsuario(Helper.validarUsuario(usuario));
        } catch (ExcepcionNegocio ex) {
            modelo.addObject("error", ex.getMessage());
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (DataAccessException ex) {
            modelo.addObject("error", "Error en Sistema, porfavor revisar log!");
            modelo.addObject("typeError", "error");
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return modelo;
    }

    @RequestMapping(value = "/listar-usuarios.html")
    public ModelAndView listarUsuarios() {
        ModelAndView modelo = new ModelAndView("ListarUsuarios");
        Helper.agregarUsuario(modelo);
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        return modelo;
    }

    @RequestMapping(value = "/update-password.html")
    public ModelAndView actualizarPassword(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView modelo = new ModelAndView("Usuario");
        Helper.agregarUsuario(modelo);
        modelo.addObject("usuario", new Usuario());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        try {
            if (!usuario.getCodigo().isEmpty() && !usuario.getPassword().isEmpty()) {
                usuarioService.insertarUsuario(usuario);
            } else {
                modelo.addObject("error", "Falta ingresar contaseña");
            }
        } catch (DataAccessException ex) {
            modelo.addObject("error", "Error en Sistema, porfavor revisar log!");
            modelo.addObject("typeError", "error");
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return modelo;
    }
}
