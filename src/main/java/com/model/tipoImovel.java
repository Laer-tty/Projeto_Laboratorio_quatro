package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_imovel")
public class tipoImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        tipoImovel that = (tipoImovel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
