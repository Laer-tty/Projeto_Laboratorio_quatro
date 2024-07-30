package com.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String profissao;

    @Column(nullable = false)
    private String telefone1;

    private String telefone2;

    @Column(name = "valor_hora", precision = 10, scale = 2)
    private BigDecimal valorHora;

    private String obs;

}