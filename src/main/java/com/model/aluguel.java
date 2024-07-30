package com.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "alugueis")
public class aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "data_vencimento")
    private Date dataVencimento;

    @Column(name = "valor_pago")
    private double valorPago;

    @Column(name = "data_pagamento")
    private Date dataPagamento;

    private String obs;

}
