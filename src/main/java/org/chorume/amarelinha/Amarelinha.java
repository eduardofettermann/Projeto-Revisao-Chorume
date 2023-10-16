package org.chorume.amarelinha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Amarelinha {
    public static Scanner scanner = new Scanner(System.in);

    public static void menuPrincipal() {
        int opcao = -1;
        imprimeMenuPrincipal();
        do {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Consultando trechos...");
                        imprimeMenuPrincipal();
                    }
                    case 2 -> {
                        menuCadastro();
                        imprimeMenuPrincipal();
                    }
                    case 3 -> {
                        System.out.println("Estatisticas...");
                        imprimeMenuPrincipal();
                    }
                    case 5 -> {
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
                scanner.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Digite 5 para ver as opções");
            }
        } while (opcao != 0);
    }

    public static void imprimeMenuPrincipal() {
        System.out.print("""
                ========= Amarelinha Transportes =========
                ||                                      ||
                ||  1- Consultar trechos e modalidades  ||
                ||  2- Cadastrar transporte             ||
                ||  3- Estatísticas                     ||
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
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Definindo cidades...");
                    }
                    case 2 -> {
                        System.out.println("Adicionando itens...");
                    }
                    case 3 -> {
                        System.out.println("Cadastrar transporte...");
                    }
                    case 5 -> {
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
                scanner.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Digite 5 para ver as opções");
            }
        } while (opcao != 0);
    }

    public static void imprimeMenuCadastro() {
        System.out.print("""
                ========== Cadastrar transporte ==========
                ||                                      ||
                ||  1- Definir cidades                  ||
                ||  2- Adicionar itens                  ||
                ||  3- Cadastrar transporte             ||
                ||  0- Voltar                           ||
                ||                                      ||
                ==========================================
                """
        );
    }
}
