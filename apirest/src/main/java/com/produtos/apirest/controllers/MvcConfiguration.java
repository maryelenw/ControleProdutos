package com.produtos.apirest.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/templates/**").addResourceLocations("/templates/");
//        registry.addResourceHandler("/webapp/**").addResourceLocations("/webapp/");
    }

    @Override
//    public void configureViewResolvers(final ViewResolverRegistry registry) {
//        registry.jsp("/", ".html");
//    }
    public void configureViewResolvers(final ViewResolverRegistry registry) {

        registry.jsp("/", ".html");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/cadUsuario").setViewName("cadastroUsuario");
        registry.addViewController("/listagemProdutos").setViewName("listagemProdutos");
        registry.addViewController("/relatorio").setViewName("relatorio");
        registry.addViewController("/produto").setViewName("produto");
        registry.addViewController("/solicitacao").setViewName("solicitacao");
    }
}