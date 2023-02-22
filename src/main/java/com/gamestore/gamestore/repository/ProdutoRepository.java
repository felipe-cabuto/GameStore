package com.gamestore.gamestore.repository;

import com.gamestore.gamestore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

    public List<Produto> findAllByConsole(@Param("console") String console);

    public List<Produto> findAllByQuantidade(@Param("quantidade") int quantidade);

    public List<Produto> findAllByPreco(@Param("preco") double preco);
}