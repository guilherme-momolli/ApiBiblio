package br.pr.famapr.ApiBiblio.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Pessoa{

    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String rg;
    @Column(name = "data_nascimento")
    private Timestamp dataNascimento;
    private int idade;
    @Column(name = "limite_credito")
    private double limiteCredito;
    private double saldo;
    private boolean ativo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
