package com.baozistore.api.service;

import com.baozistore.api.dto.PedidoRequest;
import com.baozistore.api.entity.Pedido;

import java.util.List;

public interface PedidoService {
    void salvar(PedidoRequest pedido);
    void editar(Pedido pedido);
    void excluir(Long id);
    Pedido buscar(Long id);
    List<Pedido> listar();
}
