package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class controller {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;



    @PostMapping("/cadastro")
    public void cadastrar() {
        Categoria categoria = categoriaRepository.save(new Categoria("categoria"));
        Produto produto = produtoRepository.save(new Produto("nomeProduto", "descricaoProduto", new BigDecimal(10.0), categoria));
        Cliente cliente = clienteRepository.save(new Cliente("nome", "cpf"));


        Pedido pedido = pedidoRepository.save(new Pedido(cliente));
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));
    }
}
