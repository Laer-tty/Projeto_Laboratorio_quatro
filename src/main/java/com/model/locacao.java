package com.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "valor_aluguel")
    private double valorAluguel;

    @Column(name = "percentual_multa")
    private double percentualMulta;

    @Column(nullable = false, name = "dia_vencimento")
    private int diaVencimento;

    @Column(nullable = false, name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(nullable = false)
    private Boolean ativo;

    private String obs;


}
