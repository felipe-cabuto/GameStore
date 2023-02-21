package com.gamestore.gamestore.repository;

import com.gamestore.gamestore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

    public List<Produto> findAllByValor(@Param("console") String console);

    public List<Produto> findAllByQuantidade(@Param("quantidade") int quantidade);

    public List<Produto> findAllByPeso(@Param("preco") double preco);
}