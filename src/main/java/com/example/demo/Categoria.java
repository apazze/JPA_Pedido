package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
@NoArgsConstructor
@Getter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }
}
