package com.produtos.apirest.controllers;

import javax.servlet.http.HttpServletRequest;

import com.produtos.apirest.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.produtos.apirest.service.UsuarioService;


@Controller
public class LoginController {

    ModelAndView mavIndex = new ModelAndView("login.html");

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/")
    public ModelAndView index(
    ) {
        return mavIndex;
    }

    @RequestMapping(value = "cadastroUsuario")
    public ModelAndView cadUsuario(
    ) {
        ModelAndView mavIndex = new ModelAndView("cadastroUsuario");
        return mavIndex;
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, RedirectAttributes rediect) {
        String username = request.getParameter("account");
        String password = request.getParameter("password");

        Usuario usuario = usuarioService.findUserByLoginAndPassword(username, password);

        if(usuario == null)
        {
            return "redirect:/";
        }

        request.getSession().setAttribute("usuarioLogado", usuario);
        return "redirect:/api/produtos";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, RedirectAttributes rediect) {
        request.getSession().setAttribute("usuarioLogado", null);
        return "redirect:/";
    }

}
