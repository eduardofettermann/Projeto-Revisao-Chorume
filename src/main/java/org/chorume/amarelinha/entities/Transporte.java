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

}

