package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imoveis")
public class imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cep;

    private int metragem;

    private int dormitorios;

    private int banheiros;

    private int suites;

    @Column(name = "valor_garagem")
    private int vagasGaragem;

    @Column(name = "valor_aluguel_sugerido")
    private double valorAlugelSugerido;

    private String obs;


}
