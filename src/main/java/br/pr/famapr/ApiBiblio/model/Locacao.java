package br.pr.famapr.ApiBiblio.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "locacoes")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_locacao")
    private Timestamp dataLocacao;
    @Column(name = "sub_total")
    private double subTotal;
    @Column(name = "valor_diarias")
    private double valorDiarias;
    @Column(name = "valor_total")
    private double valorTotal;
    @Column(name = "valor_recebido")
    private double valorRecebido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataLocacao(Timestamp dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getValorDiarias() {
        return valorDiarias;
    }

    public void setValorDiarias(double valorDiarias) {
        this.valorDiarias = valorDiarias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }
}
