package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;

//possui métodos que facilitam, fica mais fácil fazer persistência no banco de dados,
// não precisar criar DAO. O JPA facilita utilizando esse JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Produto findById(long id);

    @Query("SELECT p from Produto p where p.nome like %:nome%")
    List<Produto> findAllByNameContains(@Param("nome") String nome);
}
