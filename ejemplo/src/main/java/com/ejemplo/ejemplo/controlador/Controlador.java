package com.ejemplo.ejemplo.controlador;

import com.ejemplo.ejemplo.modelo.Nota;
import com.ejemplo.ejemplo.servicio.NotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Controlador {

    @Autowired
    NotasServicio notasServicio;

    @RequestMapping("/")
    public String inicio() {
        return "index";
    }

    @PostMapping("/nueva")
    public String nueva(HttpServletRequest request, Model model) {
        String nota = request.getParameter("nota");
        Nota _nota = notasServicio.agrega(nota);
        model.addAttribute("creada", notasServicio.formatoFecha(_nota.getCreada()));
        model.addAttribute("nota", _nota.getNota());
        return "otra";
    }

    @GetMapping("/ver")
    public String ver(Model model) {
        model.addAttribute("notas", notasServicio.notas());
        return "ver";
    }

}
