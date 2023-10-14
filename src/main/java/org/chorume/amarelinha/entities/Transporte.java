package org.chorume.amarelinha.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transporte {
    public HashMap<Produto, Integer> cargaTotal; // <Produto, Quantidade>, salva carga completa
    private HashMap<Produto, Integer> carga; // <Produto, Quantidade>, será manipulado para carregar os caminhões
    private List<Caminhao> caminhoes;

    //Construtor
    public Transporte(HashMap<Produto, Integer> carga) {
        this.cargaTotal = carga;
        this.carga = carga;
    }

    // Getters e Setters
    public HashMap<Produto, Integer> getCarga() {
        return carga;
    }

    public void setCarga(HashMap<Produto, Integer> carga) {
        this.carga = carga;
    }

    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(List<Caminhao> caminhoes) {
        this.caminhoes = caminhoes;
    }

    //Aqui vai a lógica do transporte (incompleto ainda)
//    public void adicionarProduto(Produto produto) {
//        carga.add(produto);
//    }

    public void adicionarCaminhao(Caminhao caminhao) {
        caminhoes.add(caminhao);
    }

//    public double calcularDistanciaTotal() {
//        // Lógica para calcular a distância total
//    }

    // Faz a divisão ideal da carga entre caminhões
    public void divideCarga() {
        while (somaPesoCarga(carga) > 8000) {
            carregaMaisPesado(10000);
            // Enche caminhões grandes
            while (somaPesoCarga(carga) > 8000) {
                caminhoes.add(new Caminhao("Grande",
                        29.21, 10000,
                        carregaMaisPesado(10000)));
            }
            while (somaPesoCarga(carga) > 2000) {
                caminhoes.add(new Caminhao("Médio",
                        13.42, 4000,
                        carregaMaisPesado(4000)));
            }
            while (somaPesoCarga(carga) > 0) {
                caminhoes.add(new Caminhao("Pequeno",
                        5.83, 1000,
                        carregaMaisPesado(1000)));
            }
        }
    }

    public HashMap<Produto, Integer> carregaMaisPesado(double pesoMax) {
        double pesoCarregado = 0.0;
        HashMap<Produto, Integer> objetosCarregados = new HashMap<>();
        List<Produto> produtos = new ArrayList<>(this.carga.keySet());

        while (!this.carga.isEmpty() || !produtos.isEmpty() || pesoCarregado != pesoMax) {
            Produto produtoMaisPesado = produtos.get(produtos.size() - 1);
            if (pesoCarregado + produtoMaisPesado.getPeso() < pesoMax) {
                pesoCarregado += produtoMaisPesado.getPeso();
                if (objetosCarregados.containsKey(produtoMaisPesado)) {
                    objetosCarregados.put(produtoMaisPesado, objetosCarregados.get(produtoMaisPesado) + 1);
                } else {
                    objetosCarregados.put(produtoMaisPesado, 1);
                }
                this.carga.put(produtoMaisPesado, this.carga.get(produtoMaisPesado) - 1);
                if (this.carga.get(produtoMaisPesado) == 0) {
                    this.carga.remove(produtoMaisPesado);
                    produtos.remove(produtoMaisPesado);
                }
            } else {
                produtos.remove(produtos.size() - 1);
            }
        }
        return objetosCarregados;
    }

    public double somaPesoCarga(HashMap<Produto, Integer> carga) {
        double total = 0;
        for (Map.Entry<Produto,Integer> produto : carga.entrySet()) {
            total += produto.getKey().getPeso() * produto.getValue();
        }
        return total;
    }

//    public double calcularCustoTotal() {
//        // Lógica para calcular o custo total
//    }

    //método toString da classe
    @Override
    public String toString() {
        return "Transporte{" +
                "produtos=" + cargaTotal +
                ", caminhoes=" + caminhoes +
                '}';
    }

}

