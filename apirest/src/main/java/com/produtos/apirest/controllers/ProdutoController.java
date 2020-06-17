package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.models.Solicitacao;
import com.produtos.apirest.models.Usuario;
import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//Classe que vai receber as requisições HTTP
@RestController
@RequestMapping(value ="/api")
public class ProdutoController {
//    ModelAndView mavIndex = new ModelAndView("listagemProdutos");

    //    Ponto de injeção pra utilizar os métodos pra se conectar ao banco de dados
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    @GetMapping("/produtos")
    public ModelAndView listaProdutos(HttpServletRequest request, RedirectAttributes rediect){
        if(        request.getSession().getAttribute("usuarioLogado")
                == null)
        {
            return new ModelAndView("login");
        }
        ModelAndView mav = new ModelAndView("listagemProdutos");
        mav.addObject("produtos", produtoRepository.findAll());
        return mav;
    }

    @GetMapping("/produto/{nome}")
    public List<Produto> listaProdutoUnico(@PathVariable(value = "nome") String nome){
        return this.produtoRepository.findAllByNameContains(nome);
    }

    @PostMapping(path="/salvarProdutos")
    public void salvarProdutos(@Valid @RequestBody List<Produto> produtos ){
        for(Produto produto : produtos)
        {
            produtoRepository.save(produto);
        }
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<?> deleteProdutoId(@PathVariable(value = "id") Integer id) {
        Produto produto = this.produtoRepository.findById(id);
        this.produtoRepository.delete(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/prod/{id}")
    public ModelAndView getUmProdutoId(@PathVariable(value = "id") Integer id) {
        ModelAndView mav = new ModelAndView("solicitacao");
        mav.addObject("produto", this.produtoRepository.findById(id));
        return mav;
    }

//    @PostMapping("/produto/{id}")
    @RequestMapping(value = "/produto/{id}", method=RequestMethod.POST)
    public ModelAndView atualizaProduto(HttpServletRequest request, @PathVariable(value = "id") Integer id,
//                                   @Valid @RequestBody Produto produtoNovo
                                        @RequestParam("quantidadeDesejada") String valueOne)
    {
        Produto produtoAtualizar = this.produtoRepository.findById(id);
        long quantidadeDesejada = Long.parseLong(valueOne);
        if(quantidadeDesejada == 0 || produtoAtualizar.getQuantidadeDisponivel() >= quantidadeDesejada) {
            long novaQuantidade = produtoAtualizar.getQuantidadeDisponivel() - quantidadeDesejada;
            produtoAtualizar.setQuantidadeDisponivel(novaQuantidade);
            this.produtoRepository.save(produtoAtualizar);
            Solicitacao solicitacao = new Solicitacao();
            solicitacao.setProduto(produtoAtualizar);
            solicitacao.setQuantidadeSolicitada(quantidadeDesejada);
            solicitacao.setDtSolicitacao(new Date(System.currentTimeMillis()));
            Usuario usuarioLogado = (Usuario)request.getSession().getAttribute("usuarioLogado");
            solicitacao.setUsuario(usuarioLogado);
            solicitacaoRepository.save(solicitacao);
        }
        ModelAndView mav = new ModelAndView("solicitacao");
        mav.addObject("produto", produtoAtualizar);
        return mav;
    }

    @GetMapping("/subtrai/{id}")
    public Produto baixaDeProduto(@PathVariable(value = "id") Integer id) {
        Produto produto = this.produtoRepository.findById(id);
        produto.setQuantidadeDisponivel(produto.getQuantidadeDisponivel() - 1);
        return produto;
    }
}
