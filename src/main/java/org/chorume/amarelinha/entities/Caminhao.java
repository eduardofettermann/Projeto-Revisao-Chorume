package org.chorume.amarelinha.entities;

public class Caminhao {
    private String classificacao;  // Pequeno, Médio, Grande
    private double precoPorKm;     // Preço por quilômetro (R$/km)
    private double capacidadeMaxima; // Capacidade máxima em toneladas

    // Construtor
    public Caminhao(String classificacao, double precoPorKm, double capacidadeMaxima) {
        this.classificacao = classificacao;
        this.precoPorKm = precoPorKm;
        this.capacidadeMaxima = capacidadeMaxima;
    }
}