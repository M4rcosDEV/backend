package com.baozistore.api.service;

import com.baozistore.api.entity.Cliente;
import com.baozistore.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Cliente buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }
}
