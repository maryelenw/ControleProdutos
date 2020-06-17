package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.models.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    Produto findById(long id);
}
