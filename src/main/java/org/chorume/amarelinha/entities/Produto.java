package org.chorume.amarelinha.entities;

public class Produto {
    private String nome;
    private double peso; // Peso em kg

    public Produto(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}