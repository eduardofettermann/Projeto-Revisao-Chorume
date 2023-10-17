package org.chorume.amarelinha.amarelinha;

import java.util.Scanner;

public class main {
    public static void menu() {
        Scanner amarelinha = new Scanner(System.in);
        int opcao = 0;
        boolean continuar = true; // Variável para controlar a execução do programa

        while (continuar) {
            System.out.println("1 - Consultar Trechos e Modalidades");
            System.out.println("2 - Cadastrar transporte");
            System.out.println("3 - Dados estatísticos");
            System.out.println("4 - Finalizar o programa");
            opcao = amarelinha.nextInt();
            switch (opcao) {
                case 1:
                    // Coloque aqui o código para a opção 1
                    break;
                case 2:
                    // Coloque aqui o código para a opção 2
                    break;
                case 3:
                    // Coloque aqui o código para a opção 3
                    break;
                case 4:
                    continuar = false; // Define a variável continuar como false para sair do loop
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}