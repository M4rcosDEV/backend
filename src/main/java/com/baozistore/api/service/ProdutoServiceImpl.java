package com.baozistore.api.service;

import com.baozistore.api.entity.Produto;
import com.baozistore.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(Produto produto) {
        repository.save(produto);
    }

    @Override
    public void editar(Produto produto) {
        repository.save(produto);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Produto buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Override
    public List<Produto> listar() {
        return repository.findAll();
    }
}
