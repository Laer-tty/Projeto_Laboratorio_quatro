package com.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "servicos_imovel")
public class ServicoImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_servico")
    private Date dataServico;

    @Column(name = "valor_total", precision  = 10, scale = 2)
    private BigDecimal valorTotal;

    private String obs;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_imovel")
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_profissional")
    private Profissional profissional;
}
