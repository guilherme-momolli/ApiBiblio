package br.pr.famapr.ApiBiblio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    @Column(name = "preco_locacao")
    private double precoLocacao;
    @Column(name = "horas_devolucao")
    private int horasDevolucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(double precoLocacao) {
        this.precoLocacao = precoLocacao;
    }

    public int getHorasDevolucao() {
        return horasDevolucao;
    }

    public void setHorasDevolucao(int horasDevolucao) {
        this.horasDevolucao = horasDevolucao;
    }
}
