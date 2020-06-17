package com.produtos.apirest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SOLICITACAO")

public class Solicitacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SOLICITACAO")
    private long idSolicitacao;

    @Column(name = "ID_PRODUTO")
    private Produto produto;

    @Column(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "DT_SOLICITACAO")
    private Date dtSolicitacao;

    @Column(name = "QT_SOLICITADA")
    private long quantidadeSolicitada;

    public long getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(long idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDtSolicitacao() {
        return dtSolicitacao;
    }

    public void setDtSolicitacao(Date dtSolicitacao) {
        this.dtSolicitacao = dtSolicitacao;
    }

    public long getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(long quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }
}
