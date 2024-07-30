package com.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;


@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "valor_aluguel",precision  = 10, scale = 4)
    private BigDecimal valorAluguel;

    @Column(name = "percentual_multa",precision  = 5, scale = 2)
    private BigDecimal percentualMulta;

    @Column(nullable = false, name = "dia_vencimento")
    private Byte diaVencimento;

    @Column(nullable = false, name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(nullable = false)
    private Boolean ativo;

    private String obs;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_imovel")
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_inquilino")
    private Cliente cliente;

}
