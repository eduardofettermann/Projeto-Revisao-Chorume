package org.chorume.amarelinha.entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

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
        this.carga = new LinkedHashMap<>(carga);
    }

    // Getters e Setters

    public LinkedHashMap<Produto, Integer> getCarga() {
        return carga;
    }

    // Método toString para representação em string
    @Override
    public String toString() {
        return "Caminhao{" +
                "classificacao='" + classificacao + '\'' +
                ", precoPorKm=" + precoPorKm +
                ", capacidadeMaxima=" + capacidadeMaxima +
                ", carga=" + carga +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caminhao caminhao = (Caminhao) o;
        return Double.compare(caminhao.precoPorKm, precoPorKm) == 0 &&
                Double.compare(caminhao.capacidadeMaxima, capacidadeMaxima) == 0 &&
                Objects.equals(classificacao, caminhao.classificacao) &&
                Objects.equals(carga, caminhao.carga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classificacao, precoPorKm, capacidadeMaxima, carga);
    }


}