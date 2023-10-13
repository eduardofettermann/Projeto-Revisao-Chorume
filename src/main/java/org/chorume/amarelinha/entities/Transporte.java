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

    //Aqui vai a lógica do transporte (incompleto ainda)
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void adicionarCaminhao(Caminhao caminhao) {
        caminhoes.add(caminhao);
    }

    public double calcularDistanciaTotal() {
        // Lógica para calcular a distância total
    }

    public Caminhao determinarCaminhaoAdequado() {
        // Lógica para determinar o caminhão adequado
    }

    public double calcularCustoTotal() {
        // Lógica para calcular o custo total
    }

    //método toString da classe
    @Override
    public String toString() {
        return "Transporte{" +
                "produtos=" + produtos +
                ", caminhoes=" + caminhoes +
                '}';
    }

}

