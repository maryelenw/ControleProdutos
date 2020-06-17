package com.produtos.apirest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "MEDIDA")
    private String medida;

    @Column(name = "PRECO")
    private long preco;

    @Column(name = "QUANTIDADE_DISPONIVEL")
    private long quantidadeDisponivel;

    @Column(name = "IMAGE")
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public long getPreco() {
        return preco;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }

    public long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void subtraiQuantidade() {
        this.quantidadeDisponivel = this.quantidadeDisponivel -1;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void copyAttributes (Produto produto){
        Field[] fieldsFromProdutoOld = this.getClass().getDeclaredFields();
        Field[] fieldsFromProdutoNew = produto.getClass().getDeclaredFields();

        for (Field currentfieldsFromProdutoOld : fieldsFromProdutoOld){
            for (Field currentfieldsFromProdutoNew : fieldsFromProdutoNew) {
                String nameOfTheFirstField = currentfieldsFromProdutoOld.getName();
                String nameOfTheSecondField = currentfieldsFromProdutoNew.getName();

                if (nameOfTheFirstField.equals(nameOfTheSecondField)) {
                    currentfieldsFromProdutoOld.setAccessible(true);
                    currentfieldsFromProdutoNew.setAccessible(true);

                    try {
                        currentfieldsFromProdutoOld.set(this, currentfieldsFromProdutoNew.get(produto));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
