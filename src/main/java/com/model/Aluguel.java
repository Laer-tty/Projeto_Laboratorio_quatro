package com.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "alugueis")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "data_vencimento")
    private Date dataVencimento;

    @Column(name = "valor_pago", precision  = 10, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "data_pagamento")
    private Date dataPagamento;

    private String obs;

    @ManyToOne
    @JoinColumn(nullable = false,name = "id_locacao")
    private Locacao locacao;
}
