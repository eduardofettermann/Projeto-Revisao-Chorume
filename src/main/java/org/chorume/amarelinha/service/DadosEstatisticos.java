package org.chorume.amarelinha.service;
import org.chorume.amarelinha.controller.Transporte;
import org.chorume.amarelinha.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DadosEstatisticos {

    private static final HashMap<String, Object> PRODUTOS_PERMITIDOS = new HashMap<>() ;
    private List<Transporte> transportes;

    public DadosEstatisticos() {
        this.transportes = new ArrayList<>();
    }

    public void adicionarTransporte(Transporte transporte) {
        transportes.add(transporte);
    }

    public double calcularCustoTotal() {
        double custoTotal = 0;
        for (Transporte transporte : transportes) {
            // acessar os dados do transporte e calcular o custo total
        }
        return custoTotal;
    }

    public double calcularCustoMedioPorKm() {
        double distanciaTotal = 0;
        for (Transporte transporte : transportes) {
            distanciaTotal += transporte.getDistanciaTotal();
        }
        return calcularCustoTotal() / distanciaTotal;
    }

    public double calcularCustoMedioPorTipoProduto(String tipoProduto) {
        int totalItens = 0;
        double totalCustoProduto = 0;

        for (Transporte transporte : transportes) {
            LinkedHashMap<Produto, Integer> carga = transporte.getCarga();
            for (Produto produto : carga.keySet()) {
                if (produto.getNome().equalsIgnoreCase(tipoProduto)) {
                    totalItens += carga.get(produto);
                    totalCustoProduto += carga.get(produto) * produto.getPeso();
                }
            }
        }

        return totalCustoProduto / totalItens;
    }

    public HashMap<String, Double> calcularCustoPorTipoProduto() {
        HashMap<String, Double> custoPorTipoProduto = new HashMap<>();
        for (String tipoProduto : PRODUTOS_PERMITIDOS.keySet()) {
            custoPorTipoProduto.put(tipoProduto, calcularCustoMedioPorTipoProduto(tipoProduto));
        }
        return custoPorTipoProduto;
    }

    // Métodos para calcular outras estatísticas

    public void exibirRelatorioEstatistico() {
        System.out.println("===== Dados Estatísticos dos Transportes =====");
        System.out.printf("Custo total: R$ %.2f%n", calcularCustoTotal());
        System.out.printf("Custo médio por km: R$ %.2f%n", calcularCustoMedioPorKm());

        HashMap<String, Double> custoPorTipoProduto = calcularCustoPorTipoProduto();
        System.out.println("Custo médio por tipo de produto:");
        for (String tipoProduto : custoPorTipoProduto.keySet()) {
            System.out.printf("- %s: R$ %.2f%n", tipoProduto, custoPorTipoProduto.get(tipoProduto));
        }

        // Adicionaremos aqui os cálculos para outras estatísticas...

        System.out.println("===============================================");
    }
}