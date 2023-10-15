package org.chorume.amarelinha.entities;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Caminhao {
    private String classificacao;  // Pequeno, Médio, Grande
    private double precoPorKm;     // Preço por quilômetro (R$/km)
    private double capacidadeMaxima; // Capacidade máxima em toneladas
    private LinkedHashMap<Produto, Integer> carga;

    // Construtor
    public Caminhao(String classificacao, double precoPorKm, double capacidadeMaxima, HashMap<Produto, Integer> carga) {
        this.classificacao = classificacao;
        this.precoPorKm = precoPorKm;
        this.capacidadeMaxima = capacidadeMaxima;
        this.carga = carga;
    }

    // Getters e Setters
    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getPrecoPorKm() {
        return precoPorKm;
    }

    public void setPrecoPorKm(double precoPorKm) {
        this.precoPorKm = precoPorKm;
    }

    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    // Método toString para representação em string
    @Override
    public String toString() {
        return "Caminhao{" +
                "classificacao='" + classificacao + '\'' +
                ", precoPorKm=" + precoPorKm +
                ", capacidadeMaxima=" + capacidadeMaxima +
                '}';
    }

}