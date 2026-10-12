package com.baozistore.api.service;

import com.baozistore.api.entity.Produto;

import java.util.List;

public interface ProdutoService {
    void salvar(Produto produto);
    void editar(Produto produto);
    void excluir(Long id);
    Produto buscar(Long id);
    List<Produto> listar();
}
