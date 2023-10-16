package org.chorume.amarelinha.controller;

import org.chorume.amarelinha.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.chorume.amarelinha.service.Amarelinha.SCANNER;

public class CadastroTransporte {
    public List<String> cidades = new ArrayList<>(); // Modificar para List<Cidade>
    private LinkedHashMap<Produto, Integer> carga = new LinkedHashMap<>();
    private int nCidades = cidades.size();

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

    public LinkedHashMap<Produto, Integer> getCarga() {
        return carga;
    }

    public void cadastraCidades() {
        String cidadeInput;
        // Cidade cidade;
        boolean listando = true;
        do {
            try {
                SCANNER.nextLine();
                System.out.printf("Digite a cidade %d (X para sair): ", nCidades + 1);
                cidadeInput = SCANNER.nextLine();
                if (!cidadeInput.equalsIgnoreCase("X")) {
                    // cidade = verificaCidade(cidadeInput); Substituir por método que verifica cidade
                    cidades.add(cidadeInput); // Substituir cidadeInput por cidade
                } else {
                    listando = false;
                }
            } catch (Exception e) { // Trocar por Exception de cidade inexistente
                System.out.println("Cidade inválida!");
            } finally {
                nCidades = cidades.size();
            }
        } while (listando);
    }

    public void imprimeCidades() {
    } // Implementar método que lista as cidades já cadastradas

    public void removeCidades() {
    } // Implementar método para remover cidade adicionada

    public void adicionarProdutos() {
        Produto produto;
        int quantidade;
        String produtoInput;
        boolean listando = true;
        do {
            SCANNER.nextLine();
            System.out.print("Digite o produto que deseja adicionar (X para sair): ");
            produtoInput = SCANNER.nextLine().toUpperCase();
            if (!produtoInput.equalsIgnoreCase("X")) {
                if (verificaProduto(produtoInput)) {
                    produto = new Produto(produtoInput, PRODUTOS_PERMITIDOS.get(produtoInput));

                    if (!carga.isEmpty() && carga.keySet().stream().toList().contains(produto)) {
                        System.out.println("Produto já adicionado, o valor inserido substituirá o anterior!");
                        System.out.printf("Atual -> %s: %d un.\n", produto.getNome(), carga.get(produto));
                        System.out.print("Qual quantidade deseja? ");
                        carga.put(produto, carga.get(produto) + 1);
                    } else {
                        System.out.print("Quantos deseja adicionar? ");
                        quantidade = SCANNER.nextInt();
                        carga.put(produto, quantidade);
                    }
                } else {
                    System.out.println("Produto inválido! Digite 'P' para ver os produtos permitidos");
                }
            } else {
                listando = false;
            }
        } while (listando);
    }

    public boolean verificaProduto(String produto) {
        List<String> nomesProdutos = PRODUTOS_PERMITIDOS.keySet().stream().toList();
        if (produto.equals("P")) {
            System.out.println("Lista de produtos válidos:");
            for (String nomeProduto : nomesProdutos) {
                System.out.printf("- %s\n", nomeProduto);
            }
            return true;
        }
        return nomesProdutos.contains(produto);
    }
}
