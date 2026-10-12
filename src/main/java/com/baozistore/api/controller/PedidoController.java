package com.baozistore.api.controller;

import com.baozistore.api.dto.PedidoRequest;
import com.baozistore.api.entity.Pedido;
import com.baozistore.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        Pedido pedido = service.buscar(id);
        if  (pedido != null) {
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){
        List<Pedido> pedidos = service.listar();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody PedidoRequest pedido){
        service.salvar(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> editar(@PathVariable Long id, @RequestBody Pedido pedido){
        pedido.setId(id);
        service.editar(pedido);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
