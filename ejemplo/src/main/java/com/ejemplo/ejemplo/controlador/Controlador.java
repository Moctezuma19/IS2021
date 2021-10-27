package com.ejemplo.ejemplo.controlador;

import com.ejemplo.ejemplo.modelo.Nota;
import com.ejemplo.ejemplo.modelo.Usuario;
import com.ejemplo.ejemplo.repositorio.UsuariosRepositorio;
import com.ejemplo.ejemplo.servicio.NotasServicio;
import com.ejemplo.ejemplo.servicio.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class Controlador {

    @Autowired
    NotasServicio notasServicio;

    @Autowired
    UsuariosServicio usuariosServicio;

    @Autowired
    UsuariosRepositorio usuariosRepositorio;


    @RequestMapping("/")
    public String inicio() {
        return "index";
    }

    @RequestMapping("/registro")
    public String registro() {
        return "registro";
    }

    @RequestMapping("/iniciar-sesion")
    public String inciarSesion(Model model, String error, Principal principal) {


        if (error != null) {
            model.addAttribute("error", true);
        }

        if (principal != null) {
            return "redirect:/";
        }
        return "iniciar-sesion";
    }

    @PostMapping("/crea")
    public String crea(HttpServletRequest request, Model model) {
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave");
        Usuario nuevo = usuariosServicio.crea(nombre, clave);
        if (nuevo == null) {
            model.addAttribute("nombre", nombre);
            model.addAttribute("error", true);
            return "redirect:/registro";
        }
        return "info";
    }


    @PostMapping("/nueva")
    public String nueva(HttpServletRequest request, Model model, Principal principal) {
        Usuario usuario = usuariosRepositorio.findUsuarioByNombre(principal.getName());
        String nota = request.getParameter("nota");
        Nota _nota = notasServicio.agrega(usuario.getIdUsuario(), nota);
        model.addAttribute("creada", notasServicio.formatoFecha(_nota.getCreada()));
        model.addAttribute("nota", _nota.getNota());
        return "otra";
    }

    @GetMapping("/ver")
    public String ver(Model model, Principal principal) {
        Usuario usuario = usuariosRepositorio.findUsuarioByNombre(principal.getName());
        model.addAttribute("notas", notasServicio.notas(usuario.getIdUsuario()));
        return "ver";
    }

    @RequestMapping("/salir")
    public String saliendo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        for (Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }
        return "iniciar-sesion";
    }

}
