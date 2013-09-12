/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diarioru.controladores;

import com.diarioru.entidades.Comentario;
import com.diarioru.entidades.Requerimiento;
import com.diarioru.entidades.Usuario;
import com.diarioru.servicios.ComentarioServiceInterface;
import com.diarioru.servicios.MyBatisService;
import com.diarioru.servicios.RequerimientoServiceInterface;
import com.diarioru.servicios.UsuarioServiceInterface;
import com.diarioru.to.SugerenciaForm;
import com.diarioru.to.UsuarioTO;
import com.diarioru.util.Helper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    private ComentarioServiceInterface comentarioService;
    @Autowired
    private MyBatisService myBatisService;
    private List<Usuario> usuarios;

    @PostConstruct
    void cargarDatos() {
        usuarios = usuarioService.listarUsuarios();
    }

    /*PRINCIPALES- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    @RequestMapping(value = "/requerimiento.html", method = RequestMethod.GET)
    public ModelAndView requerimiento() {
        ModelAndView modelo = new ModelAndView("Requerimiento");
        Helper.agregarUsuario(modelo);
        modelo.addObject("requerimiento", new Requerimiento());
        return modelo;
    }

    @RequestMapping(value = "/comentar-requerimiento.html", method = RequestMethod.GET)
    public ModelAndView comentarRequerimiento() {
        ModelAndView modelo = new ModelAndView("Comentario");
        Helper.agregarUsuario(modelo);
        modelo.addObject("comentario", new Comentario());
        modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        return modelo;
    }

    @RequestMapping(value = "/sugerencias.html", method = RequestMethod.GET)
    public ModelAndView comentarRetrospectiva() {
        ModelAndView modelo = new ModelAndView("Sugerencia");
        Helper.agregarUsuario(modelo);
        return modelo;
    }

    /*LISTAS - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    @RequestMapping(value = "/listar-item.html", method = RequestMethod.POST)
    public ModelAndView listarItems(@ModelAttribute("item2") Comentario item) {
        ModelAndView modelo = new ModelAndView("ListarComentario");
        Helper.agregarUsuario(modelo);
        modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        modelo.addObject("items", comentarioService.listarItems(item.getUsuario().getCodigo(), item.getPadreId()));
        return modelo;
    }

    @RequestMapping(value = "/listar-requerimiento.html", method = RequestMethod.POST)
    public ModelAndView listarRequerimientos(@ModelAttribute("item1") Requerimiento requerimiento) {
        ModelAndView modelo = new ModelAndView("ListarRequerimiento");
        Helper.agregarUsuario(modelo);
        if (requerimiento.getUsuario() == null) {
            modelo.addObject("requerimientos", requerimientoService.listarRequerimientos());
        } else {
            modelo.addObject("requerimientos", requerimientoService.filtrarRequerimientos(requerimiento.getUsuario().getCodigo()));
        }
        modelo.addObject("usuarios", usuarioService.listarUsuarios());
        return modelo;
    }

    @RequestMapping(value = "/listar-sugerencias.html", method = RequestMethod.POST)
    public ModelAndView listarSugerencias() {
        ModelAndView modelo = new ModelAndView("ListarSugerencias");
        Helper.agregarUsuario(modelo);
        modelo.addObject("sugerencias", comentarioService.listarSugerencias());
        return modelo;
    }
    
    /*INSERTS- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    @RequestMapping(value = "/add-comentario.html", method = RequestMethod.POST)
    public View insertarComentario(@ModelAttribute("comentario") Comentario comentario) {
        comentarioService.insertar(comentario);
        return new RedirectView("comentar-requerimiento.html");
    }

    @RequestMapping(value = "/add-sugerencia.html", method = RequestMethod.POST)
    public View insertarSugerencia(@ModelAttribute("sugerencias") SugerenciaForm sugerencias) {
        comentarioService.insertarSugerencias(sugerencias.getSugerencias());
        return new RedirectView("sugerencias.html");
    }

    @RequestMapping(value = "/add-requerimiento.html", method = RequestMethod.POST)
    public View insertarRequerimiento(@ModelAttribute("requerimiento") Requerimiento requerimiento) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (Usuario u : usuarios) {
            if (u.getCodigo().equals(user.getUsername())) {
                requerimiento.setUsuario(u);
                break;
            }
        }
        requerimientoService.insertar(requerimiento);
        return new RedirectView("requerimiento.html");
    }

    /*EJEMPLO JSON - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    @RequestMapping(value = "/obtenerUsuarios.json", method = RequestMethod.GET)
    public @ResponseBody
    List<UsuarioTO> obtenerListaUsuarios() {
        List<UsuarioTO> listaUsuarios = new ArrayList<UsuarioTO>();
        for (Usuario usuario : usuarioService.listarUsuarios()) {
            UsuarioTO u = new UsuarioTO(usuario.getCodigo(), usuario.getNombre());
            listaUsuarios.add(u);
        }
        return listaUsuarios;
    }
}
