package com.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "servicos_imovel")
public class servicoImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_servico")
    private Date dataServico;

    @Column(name = "valor_total")
    private double valorTotal;

    private String obs;
}
