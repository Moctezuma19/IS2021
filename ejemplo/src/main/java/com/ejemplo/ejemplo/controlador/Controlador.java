package com.ejemplo.ejemplo.controlador;

import com.ejemplo.ejemplo.servicio.NotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Controlador {

    @Autowired
    NotasServicio notasServicio;

    @RequestMapping("/")
    public String inicio(){
        return "index";
    }

    @PostMapping("/agrega")
    public String agrega(HttpServletRequest request){
        String nota = request.getParameter("nota");
        notasServicio.agrega(nota);
        return "index";
    }

    @RequestMapping("/otrapagina")
    public String otraPagina(){
        return "otra";
    }

    @RequestMapping("/form")
    public String formulario(){
        return "formulario";
    }

    @PostMapping("/procesa")
    public String procesa(HttpServletRequest request){
        String parametro = request.getParameter("mensaje");
        System.out.println("parametro :" + parametro);
        return "index";
    }

}
