package com.baozistore.api.service;

import com.baozistore.api.dto.PedidoRequest;
import com.baozistore.api.entity.Cliente;
import com.baozistore.api.entity.Pedido;
import com.baozistore.api.entity.Produto;
import com.baozistore.api.repository.ClienteRepository;
import com.baozistore.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

    private final PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(PedidoRequest dto) {
        Pedido pedido = this.transformarPedido(dto);
        repository.save(pedido);
    }

    @Override
    public void editar(Pedido pedido) {
        repository.save(pedido);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Pedido buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @Override
    public List<Pedido> listar() {
        return repository.findAll();
    }

    private Pedido transformarPedido(PedidoRequest pedidoRequest) {
        Cliente cliente = new Cliente();
        cliente.setId(pedidoRequest.getClienteId());

        Produto produto = new Produto();
        produto.setId(pedidoRequest.getProdutoId());

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);

        pedido.setQuantidade(pedidoRequest.getQuantidade());

        return pedido;
    }
}
