package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaClientePedidoApplication implements CommandLineRunner {

    public JpaClientePedidoApplication(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository, PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaClientePedidoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria categoria = categoriaRepository.save(new Categoria("categoria"));
        Produto produto = produtoRepository.save(new Produto("nomeProduto", "descricaoProduto", new BigDecimal(10.0), categoria));
        Cliente cliente = clienteRepository.save(new Cliente("nome", "cpf"));


        Pedido pedido = pedidoRepository.save(new Pedido(cliente));
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));
    }
}
