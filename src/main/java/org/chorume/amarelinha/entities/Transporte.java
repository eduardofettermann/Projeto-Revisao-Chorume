package org.chorume.amarelinha.entities;

import java.util.*;

public class Transporte {
    private LinkedHashMap<Produto, Integer> cargaTotal; // <Produto, Quantidade>, salva carga completa
    private LinkedHashMap<Produto, Integer> carga; // <Produto, Quantidade>, será manipulado para carregar os caminhões
    private List<Caminhao> caminhoes = new ArrayList<>();

    //Construtor
    public Transporte(LinkedHashMap<Produto, Integer> carga) {
        carga = ordenaCarga(carga);
        this.cargaTotal = new LinkedHashMap<>(carga);
        this.carga = new LinkedHashMap<>(carga);
        this.divideCarga();
    }

    // Getters e Setters
    public LinkedHashMap<Produto, Integer> getCarga() {
        return cargaTotal;
    }

    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    //Aqui vai a lógica do transporte (incompleto ainda)
    public void adicionarProduto() {
    }

//    public double calcularDistanciaTotal() {
//        // Lógica para calcular a distância total
//    }

    // Faz a divisão ideal da carga entre caminhões
    public void divideCarga() {
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


    public LinkedHashMap<Produto, Integer> carregaMaisPesado(double pesoMax) {
        double pesoCarregado = 0.0;
        LinkedHashMap<Produto, Integer> objetosCarregados = new LinkedHashMap<>();
        List<Produto> produtos = new ArrayList<>(this.carga.keySet());

        while (!this.carga.isEmpty() && !produtos.isEmpty() && pesoCarregado != pesoMax) {
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

    public double somaPesoCarga(LinkedHashMap<Produto, Integer> carga) {
        double total = 0;
        for (Map.Entry<Produto, Integer> produto : carga.entrySet()) {
            total += produto.getKey().getPeso() * produto.getValue();
        }
        return total;
    }

    public static LinkedHashMap<Produto, Integer> ordenaCarga(LinkedHashMap<Produto, Integer> carga) {
        LinkedHashMap<Produto, Integer> cargaOrdenada = new LinkedHashMap<>();

        List<Produto> produtos = new ArrayList<>(carga.keySet());
        produtos.sort(Comparator.comparingDouble(Produto::getPeso));
        for (Produto produto : produtos) {
            cargaOrdenada.put(produto, carga.get(produto));
        }
        return cargaOrdenada;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transporte transporte = (Transporte) o;
        return Objects.equals(cargaTotal, transporte.cargaTotal) &&
                Objects.equals(caminhoes, transporte.caminhoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargaTotal, caminhoes);
    }

}

