package com.baozistore.api.service;

import com.baozistore.api.entity.Cliente;

import java.util.List;

public interface ClienteService {
    void salvar(Cliente cliente);
    void editar(Cliente cliente);
    void excluir(Long id);
    Cliente buscar(Long id);
    List<Cliente> listar();
}
