package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@NoArgsConstructor
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    private LocalDate data = LocalDate.now();
    @ManyToOne
    private Cliente cliente;

// mapeamento simples só com id das que ela referencia
//    @ManyToMany
//    @JoinTable(name = "NomeTabelaJoinPersonalizado")
//    private List<Produto> produtos;


    //Criar nova entidade no case desta tabela de join necessitar possuir mais colunas. Ex:
    // Qtd de itens, ValorUnitario (valor pode sofrer atualizacao), etc.

    //Neste lado (OneToMany passar o atributo do outro lado para gerar o relacionamento bidirecional)
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // se eu deletar o pedido, deleta tbm todos os item_pedido e vice-versa, um nao existe sem o outro
    private List<ItemPedido> itens = new ArrayList<>(); // boa pratica, inicializar a lista com uma coleção vazia pois senao estará nula!

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item){
        item.setPedido(this); // para nao esquecer de add no outro lado do relacionamento
        this.itens.add(item); // add???? ou seria save ?????
    }
}
