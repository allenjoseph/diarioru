/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.controladores;

import com.diarioru.entidades.Itemdiario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.entidades.Usuario;
import com.diarioru.servicios.ItemDiarioServiceInterface;
import com.diarioru.servicios.MyBatisServiceInterface;
import com.diarioru.servicios.RequerimientoServiceInterface;
import com.diarioru.servicios.UsuarioServiceInterface;
import com.diarioru.to.UsuarioTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.diarioru.util.helper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private UsuarioServiceInterface usuarioService;
    @Autowired
    private RequerimientoServiceInterface requerimientoService;
    @Autowired
    private ItemDiarioServiceInterface itemDiarioService;
    @Autowired
    private MyBatisServiceInterface myBatisService;

    @PostConstruct
    void cargarDatos() {
    }
    
    @RequestMapping(value = "/diario.html", method = RequestMethod.GET)
    public ModelAndView itemdario() {        
        ModelAndView modelo = helper.crearModelo("NuevoItem");             
        modelo.addObject("item", new Itemdiario());
        modelo.addObject("item2", new Itemdiario());
        modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        return modelo;
    }

    @RequestMapping(value = "/requerimiento.html", method = RequestMethod.GET)
    public ModelAndView requerimiento() {
        ModelAndView modelo = helper.crearModelo("NuevoRequerimiento");     
        modelo.addObject("requerimiento", new Requerimiento());
        return modelo;
    }
    
    @RequestMapping(value = "/obtenerUsuarios.json", method = RequestMethod.GET)
    public @ResponseBody List<UsuarioTO> obtenerListaUsuarios(){   
        List<UsuarioTO> listaUsuarios = new ArrayList<UsuarioTO>();
         for(Usuario usuario : usuarioService.listarUsuarios()){
             UsuarioTO u = new UsuarioTO(usuario.getUsuarioId(),usuario.getNombre());
             listaUsuarios.add(u);
         }        
        return listaUsuarios;
    }

    @RequestMapping(value = "/listar-item.html", method = RequestMethod.POST)
    public ModelAndView listarItems(@ModelAttribute("item2") Itemdiario item) {
        ModelAndView modelo = helper.crearModelo("ListarItem");     
        modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        modelo.addObject("items", itemDiarioService.listarItems(item.getUsuario().getUsuarioId(),item.getRequerimiento().getRequerimientoId()));
        return modelo;
    }
    
    @RequestMapping(value = "/listar-requerimiento.html", method = RequestMethod.POST)
    public ModelAndView listarRequerimientos() {
        ModelAndView modelo = helper.crearModelo("ListarRequerimiento");     
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
