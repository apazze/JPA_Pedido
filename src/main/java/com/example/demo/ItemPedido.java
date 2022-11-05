package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
@NoArgsConstructor
@Getter
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    private int quantidade;
    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;

    public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
        //this.precoUnitario = produto.getPreco(); // nao compila ???
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
