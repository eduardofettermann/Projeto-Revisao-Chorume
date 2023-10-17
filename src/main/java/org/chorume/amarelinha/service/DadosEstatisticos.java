package org.chorume.amarelinha.service;

import org.chorume.amarelinha.controller.Transporte;
import org.chorume.amarelinha.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.chorume.amarelinha.service.Amarelinha.SCANNER;

public class DadosEstatisticos {

    private final HashMap<String, Double> PRODUTOS_PERMITIDOS = new HashMap<>() {{
        put("CELULAR", 0.7);
        put("GELADEIRA", 50.0);
        put("AIR FRYER", 3.5);
        put("CADEIRA", 5.0);
        put("LUMINARIA", 0.8);
        put("LAVADORA DE ROUPA", 15.0);
        put("PLAYSTATION 5", 3.9);
        put("NINTENDO SWITCH", 0.3);
    }};
    private List<Transporte> transportes;

    public void adicionarTransporte(Transporte transporte) {
        transportes.add(transporte);
    }

    public double calcularCustoTotal() {
        double custoTotal = 0;
        for (Transporte transporte : transportes) {
            custoTotal += transporte.getCustoTotal();
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

    public void exibirRelatorioEstatistico(List<Transporte> transportes) {
        this.transportes = new ArrayList<>(transportes);
        System.out.println("===== Dados Estatísticos dos Transportes =====");
        System.out.printf("Custo total: R$ %.2f%n", calcularCustoTotal());
        System.out.printf("Custo médio por km: R$ %.2f%n", calcularCustoMedioPorKm());

        HashMap<String, Double> custoPorTipoProduto = calcularCustoPorTipoProduto();
        System.out.println("Custo médio por tipo de produto:");
        for (String tipoProduto : custoPorTipoProduto.keySet()) {
            if (!custoPorTipoProduto.get(tipoProduto).isNaN()) {
                System.out.printf("- %s: R$ %.2f%n", tipoProduto, custoPorTipoProduto.get(tipoProduto));
            }
        }

        // Adicionaremos aqui os cálculos para outras estatísticas...

        System.out.println("===============================================");
        System.out.print("ENTER para voltar para o menu ");
        System.out.println(SCANNER.nextLine());
    }
}