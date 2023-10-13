package org.chorume.amarelinha.entities;

public class Produto {
    private String nome;
    private double peso; // Peso em kg

    //Construtor
    public Produto(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Método toString para mostrar em string
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", peso=" + peso +
                '}';
    }
}