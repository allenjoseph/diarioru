/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.controladores;

import com.diarioru.entidades.Itemdiario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.servicios.ItemDiarioService;
import com.diarioru.servicios.MyBatisService;
import com.diarioru.servicios.RequerimientoService;
import com.diarioru.servicios.UsuarioService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author allen
 */
@Controller
public class BaseController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RequerimientoService requerimientoService;
    @Autowired
    private ItemDiarioService itemDiarioService;
    @Autowired
    private MyBatisService myBatisService;

    @PostConstruct
    void cargarDatos() {
    }
    
    @RequestMapping(value = "/diario.html", method = RequestMethod.GET)
    public ModelAndView itemdario() {
        ModelAndView modelo = new ModelAndView("NuevoItem");
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        modelo.addObject("user", user.getUsername());
        modelo.addObject("role", user.getAuthorities().iterator().next().getAuthority());
        modelo.addObject("item", new Itemdiario());
        modelo.addObject("item2", new Itemdiario());
        modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        return modelo;
    }

    @RequestMapping(value = "/requerimiento.html", method = RequestMethod.GET)
    public ModelAndView requerimiento() {
        ModelAndView modelo = new ModelAndView("NuevoRequerimiento");
        modelo.addObject("requerimiento", new Requerimiento());
        return modelo;
    }

    @RequestMapping(value = "/listar-item.html", method = RequestMethod.POST)
    public ModelAndView listarItems(@ModelAttribute("item2") Itemdiario item) {
        ModelAndView modelo = new ModelAndView("ListarItem");
        modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        modelo.addObject("items", itemDiarioService.listarItems(item.getUsuario().getUsuarioId(),item.getRequerimiento().getRequerimientoId()));
        return modelo;
    }
    
    @RequestMapping(value = "/listar-requerimiento.html", method = RequestMethod.POST)
    public ModelAndView listarRequerimientos() {
        ModelAndView modelo = new ModelAndView("ListarRequerimiento");
        modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        return modelo;
    }

    @RequestMapping(value = "/diario-item.html", method = RequestMethod.POST)
    public View insertarItemdiario(@ModelAttribute("item") Itemdiario item) {
        item.setItemdiarioId(myBatisService.ObtenerId("itemdiario"));
        itemDiarioService.insertar(item);
        return new RedirectView("diario.html");
    }

    @RequestMapping(value = "/requerimiento-item.html", method = RequestMethod.POST)
    public View insertarRequerimiento(@ModelAttribute("requerimiento") Requerimiento requerimiento) {
        requerimiento.setRequerimientoId(myBatisService.ObtenerId("requerimiento"));     
        requerimiento.setCorrelativo(myBatisService.SiguienteCorrelativo(requerimiento.getTipo()));
        requerimientoService.insertar(requerimiento);
        return new RedirectView("requerimiento.html");
    }
}
