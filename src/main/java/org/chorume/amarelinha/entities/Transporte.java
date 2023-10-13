package org.chorume.amarelinha.entities;
import java.util.List;
public class Transporte {
    private List<Produto> produtos;
    private List<Caminhao> caminhoes;

    //Construtor
    public Transporte(List<Produto> produtos, List<Caminhao> caminhoes) {
        this.produtos = produtos;
        this.caminhoes = caminhoes;
    }

    // Getters e Setters
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(List<Caminhao> caminhoes) {
        this.caminhoes = caminhoes;
    }
}

