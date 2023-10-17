package org.chorume.amarelinha.service;

import org.chorume.amarelinha.controller.GerenciadorDeCidades;
import org.chorume.amarelinha.controller.Transporte;
import org.chorume.amarelinha.model.Cidade;
import org.chorume.amarelinha.model.Produto;

import java.util.*;

import static org.chorume.amarelinha.service.Amarelinha.SCANNER;

public class CadastroTransporte {
    public List<String> cidades = new ArrayList<>();
    private LinkedHashMap<Produto, Integer> carga = new LinkedHashMap<>();
    private final static GerenciadorDeCidades GERENCIADOR_DE_CIDADES = new GerenciadorDeCidades();
    private LinkedHashMap<String, Cidade> cidadesLinkedHashMap;

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

    public void limpaVar() {
        cidades.clear();
        carga.clear();
    }

    public LinkedHashMap<Produto, Integer> getCarga() {
        return carga;
    }

    public void cadastraCidades() {
        cidadesLinkedHashMap = GERENCIADOR_DE_CIDADES.retornaLinkedHashMapDeCidades();
        String cidadeInput;
        boolean listando = true;
        do {
            System.out.printf("Digite a cidade %d (X para sair): ", cidades.size() + 1);
            cidadeInput = SCANNER.nextLine();
            if (!cidadeInput.equalsIgnoreCase("X")) {
                if ((!GERENCIADOR_DE_CIDADES.estaNaListaDeCidades(cidadeInput, cidadesLinkedHashMap))) {
                    System.out.println("Cidade não encontrada!");
                } else {
                    cidades.add(cidadeInput);
                }
            } else {
                listando = false;
            }
        } while (listando);
    }

    public void adicionarProdutos() {
        Produto produto;
        int quantidade;
        String produtoInput;
        boolean listando = true;
        do {
            System.out.print("Digite o produto que deseja adicionar (X para sair): ");
            produtoInput = SCANNER.nextLine().toUpperCase();
            switch (produtoInput) {
                case "X" -> listando = false;
                case "P" -> imprimeProdutosValidos();
                default -> {
                    if (verificaProduto(produtoInput)) {
                        produto = new Produto(produtoInput, PRODUTOS_PERMITIDOS.get(produtoInput));
                        if (!carga.isEmpty() && carga.keySet().stream().toList().contains(produto)) {
                            System.out.println("Produto já adicionado, o valor inserido substituirá o anterior!");
                            System.out.printf("Atual -> %s: %d un.\n", produto.getNome(), carga.get(produto));
                            System.out.print("Qual quantidade deseja? ");
                        } else {
                            System.out.print("Quantos deseja adicionar? ");
                        }
                        quantidade = SCANNER.nextInt();
                        carga.put(produto, quantidade);
                        SCANNER.nextLine();
                    } else {
                        System.out.println("Produto inválido! Digite 'P' para ver os produtos permitidos");
                    }
                }
            }
        } while (listando);
    }

    public boolean verificaProduto(String produto) {
        List<String> nomesProdutos = PRODUTOS_PERMITIDOS.keySet().stream().toList();
        return nomesProdutos.contains(produto);
    }

    public void imprimeProdutosAdicionados() {
        System.out.println("Produtos adicionados:");
        int i = 0;
        for (Map.Entry<Produto, Integer> produto : carga.entrySet()) {
            i++;
            System.out.printf("%d- %s, %dun.\n", i, produto.getKey().getNome(), produto.getValue());
        }
        System.out.print("ENTER para voltar para o menu ");
        System.out.println(SCANNER.nextLine());
    }

    public void imprimeProdutosValidos() {
        List<String> nomesProdutos = PRODUTOS_PERMITIDOS.keySet().stream().toList();
        System.out.println("Lista de produtos válidos:");
        for (String nomeProduto : nomesProdutos) {
            System.out.printf("- %s\n", nomeProduto);
        }
    }

    public boolean cadastrarTransporte() {
        if (cidades.size() < 2) {
            System.out.println("Transporte inválido! Defina pelo menos duas cidades!");
        } else if (carga.isEmpty()) {
            System.out.println("Transporte inválido! Carga vazia!");
        } else {
            return true;
        }
        System.out.print("ENTER para voltar para o menu ");
        System.out.println(SCANNER.nextLine());
        return false;
    }

    public Transporte salvaTransporte() {
        System.out.println("Transporte cadastrado!");
        return new Transporte(carga, cidades);
    }
}
