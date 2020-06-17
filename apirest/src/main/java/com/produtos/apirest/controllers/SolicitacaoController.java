package com.produtos.apirest.controllers;

import com.produtos.apirest.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class SolicitacaoController {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

//    @GetMapping("/relatorio")
//    public ModelAndView geraRelatorio(){
//        ModelAndView mav = new ModelAndView("relatorio");
//        mav.addObject("solicitacoes", solicitacaoRepository.findAll());
//        return mav;
//    }

    @GetMapping("/relatorio")
    public ModelAndView geraRelatorio(HttpServletRequest request, RedirectAttributes rediect){
        if(        request.getSession().getAttribute("usuarioLogado")
                == null)
        {
            return new ModelAndView("login");
        }
        ModelAndView mav = new ModelAndView("relatorio");
        mav.addObject("solicitacoes", solicitacaoRepository.findAll());
        return mav;
    }



}





