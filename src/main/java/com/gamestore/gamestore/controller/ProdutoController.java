package com.gamestore.gamestore.controller;

import com.gamestore.gamestore.model.Produto;
import com.gamestore.gamestore.repository.CategoriaRepository;
import com.gamestore.gamestore.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    //retorna todos os produtos
    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    //buscar por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    //buscar por console
    @GetMapping("/console/{console}")
    public ResponseEntity<List<Produto>> getByConsole(@PathVariable String console) {
        return ResponseEntity.ok(produtoRepository.findAllByConsole(console));
    }

    //buscar por quantidade
    @GetMapping("/quantidade/{quantidade}")
    public ResponseEntity<List<Produto>> getByQuantidade(@PathVariable int quantidade) {
        return ResponseEntity.ok(produtoRepository.findAllByQuantidade(quantidade));
    }

    //buscar por preço
    @GetMapping("/preco/{preco}")
    public ResponseEntity<List<Produto>> getByPreco(@PathVariable double preco) {
        return ResponseEntity.ok(produtoRepository.findAllByPreco(preco));
    }

    //retorna produto por id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    //post
    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
        if(categoriaRepository.existsById(produto.getCategoria().getId()))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(produtoRepository.save(produto));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //put
    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto) {
        if(produtoRepository.existsById(produto.getId())) {
            if (categoriaRepository.existsById(produto.getCategoria().getId()))
                return ResponseEntity.status(HttpStatus.OK)
                        .body(produtoRepository.save(produto));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        produtoRepository.deleteById(id);
    }
}
