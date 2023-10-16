package org.chorume.amarelinha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Amarelinha {
    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int opcao = -1;
        imprimeMenu();
        do {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();
                if (opcao < 0 || opcao > 3 && opcao != 5) {
                    throw new InputMismatchException();
                }
                if (opcao == 5) {
                    imprimeMenu();
                }

            } catch (InputMismatchException ime) {
                opcao = -1;
                System.out.println("Opção inválida! Digite 5 para ver as opções");
            } finally {
                scanner.nextLine();
            }
        } while (opcao != 0);
    }

    public static void imprimeMenu() {
        System.out.print("========= Amarelinha Transportes =========\n" +
                "||                                      ||\n" +
                "||  1- Consultar trechos e modalidades  ||\n" +
                "||  2- Cadastrar transporte             ||\n" +
                "||  3- Estatísticas                     ||\n" +
                "||  0- Fechar programa                  ||\n" +
                "||                                      ||\n" +
                "==========================================\n"
        );
    }
}
