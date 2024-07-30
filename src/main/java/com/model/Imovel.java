package com.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "imoveis")
public class Imovel {

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

    private Byte dormitorios;

    private Byte banheiros;

    private Byte suites;

    @Column(name = "valor_garagem")
    private Byte vagasGaragem;

    @Column(name = "valor_aluguel_sugerido", precision = 10, scale = 2)
    private BigDecimal valorAlugelSugerido;

    private String obs;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_tipo_imovel")
    private TipoImovel tipoImovel;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_proprietario")
    private Cliente cliente;
}