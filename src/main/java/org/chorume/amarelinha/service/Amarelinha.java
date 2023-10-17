package org.chorume.amarelinha.service;

import org.chorume.amarelinha.controller.Transporte;
import org.chorume.amarelinha.model.Caminhao;
import org.chorume.amarelinha.model.Produto;

import java.util.*;

public class Amarelinha {
    private static DadosEstatisticos dadosEstatisticos = new DadosEstatisticos();

    public static final Scanner SCANNER = new Scanner(System.in);
    public static CadastroTransporte cadastroTransporte = new CadastroTransporte();
    public static List<Transporte> transportes = new ArrayList<>();

    public static void menuPrincipal() {
        MenuConsultarTrechosEModalidades menuConsultarTrechosEModalidades = new MenuConsultarTrechosEModalidades();
        int opcao = -1;
        imprimeMenuPrincipal();
        do {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (opcao) {
                    case 1 -> {
                        menuConsultarTrechosEModalidades.exibeMenuInicial();
                        imprimeMenuPrincipal();
                    }
                    case 2 -> {
                        menuCadastro();
                        imprimeMenuPrincipal();
                    }
                    case 3 -> {
                        imprimeTransportes();
                        imprimeMenuPrincipal();
                    }
                    case 4 -> {
                        dadosEstatisticos.exibirRelatorioEstatistico();
                        imprimeMenuPrincipal();
                    }
                    case 9 -> {
                        imprimeMenuPrincipal();
                    }
                    case 0 -> {
                        System.out.println("Fechando programa...");
                    }
                    default -> {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException ime) {
                SCANNER.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Digite 9 para ver as opções");
            }
        } while (opcao != 0);
    }

    public static void imprimeMenuPrincipal() {
        System.out.print("""
                ========= Amarelinha Transportes =========
                ||                                      ||
                ||  1- Consultar trechos e modalidades  ||
                ||  2- Cadastrar transporte             ||
                ||  3- Ver transportes cadastrados      ||
                ||  4- Estatísticas                     ||
                ||  0- Fechar programa                  ||
                ||                                      ||
                ==========================================
                """
        );
    }

    public static void menuCadastro() {
        int opcao = -1;
        imprimeMenuCadastro();
        do {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (opcao) {
                    case 1 -> {
                        cadastroTransporte.cadastraCidades();
                        imprimeMenuCadastro();
                    }
                    case 2 -> {
                        cadastroTransporte.imprimeCidades();
                        imprimeMenuCadastro();
                    }
                    case 3 -> {
                        cadastroTransporte.adicionarProdutos();
                        imprimeMenuCadastro();
                    }
                    case 4 -> {
                        cadastroTransporte.imprimeProdutosAdicionados();
                        imprimeMenuCadastro();
                    }
                    case 5 -> {
                        if (cadastroTransporte.cadastrarTransporte()) {
                            transportes.add(cadastroTransporte.salvaTransporte());
                            cadastroTransporte.limpaVar();
                        }
                        System.out.print("ENTER para voltar para o menu ");
                        System.out.println(SCANNER.nextLine());
                        System.out.println("Voltando para o menu principal...");
                        opcao = 0;
                    }
                    case 9 -> {
                        imprimeMenuCadastro();
                    }
                    case 0 -> {
                        System.out.println("Voltando para o menu principal...");
                    }
                    default -> {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException ime) {
                SCANNER.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Digite 9 para ver as opções");
            }
        } while (opcao != 0);
    }

    public static void imprimeMenuCadastro() {
        System.out.print("""
                ========== Cadastrar transporte ==========
                ||                                      ||
                ||  1- Definir cidades                  ||
                ||  2- Ver cidades definidas            ||
                ||  3- Adicionar itens                  ||
                ||  4- Ver itens adicionados            ||
                ||  5- Cadastrar transporte             ||
                ||  0- Voltar                           ||
                ||                                      ||
                ==========================================
                """
        );
    }

    public static void imprimeTransportes() {
        System.out.println("Transportes cadastrados:");
        for (int i = 0; i < transportes.size(); i++) {
            System.out.printf("%d- ", i + 1);
            for (int j = 0; j < transportes.get(i).getCidades().size() - 1; j++) {
                System.out.printf("%s -> ", transportes.get(i).getCidades().get(j).toUpperCase());
            }
            System.out.print(transportes.get(i).getCidades().get(transportes.get(i).getCidades().size() - 1).toUpperCase() + "\n");
            System.out.printf("\tDistância total: %dkm\n", transportes.get(i).getDistanciaTotal());
            System.out.printf("\tCusto total: R$ %.2f\n", transportes.get(i).getCustoTotal());
            System.out.println("\tCarga:");
            for (Map.Entry<Produto, Integer> produto : transportes.get(i).getCarga().entrySet()) {
                System.out.printf("\t\t- %s, %dun.\n", produto.getKey().getNome(), produto.getValue());
            }
            HashMap<String, Integer> nCaminhoes = new HashMap<>() {{
                put("Pequeno",0);
                put("Médio",0);
                put("Grande",0);
            }};
            for (Map.Entry<Caminhao, Double> caminhao : transportes.get(i).getCaminhoes().entrySet()) {
                switch (caminhao.getKey().getClassificacao()) {
                    case "Pequeno" -> nCaminhoes.put("Pequeno", nCaminhoes.get("Pequeno") + 1);
                    case "Médio" -> nCaminhoes.put("Médio", nCaminhoes.get("Médio") + 1);
                    case "Grande" -> nCaminhoes.put("Grande", nCaminhoes.get("Grande") + 1);
                }
            }
            System.out.println("\tCaminhões:");
            System.out.printf("\t\tGrandes: %d\n", nCaminhoes.get("Grande"));
            System.out.printf("\t\tMédios: %d\n", nCaminhoes.get("Médio"));
            System.out.printf("\t\tPequenos: %d\n", nCaminhoes.get("Pequeno"));
            System.out.println();
        }
        System.out.print("ENTER para voltar para o menu ");
        System.out.println(SCANNER.nextLine());
    }
}
