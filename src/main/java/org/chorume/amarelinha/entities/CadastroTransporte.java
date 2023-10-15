package org.chorume.amarelinha.entities;

import java.util.Scanner;

public class CadastroTransporte {

    // menu para interação com o usuário
    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        //variavel booleana para conduzir laço
        boolean i = true;

        //iniciando loop do para exibir o menu ao usuário
        while(i) {
            System.out.println("************* MENU *************");
            System.out.println("1 - Adicionar caminhão");
            System.out.println("2 - Calcular distância total");
            System.out.println("3 - Fazer divisão de carga entre caminhões");
            System.out.println("4 - Verificar carga produtos");
            System.out.println("5 - Somar peso da carga");
            System.out.println("6 - Calcular custo total");
            System.out.println("7 - Sair");
            int opcao = scanner.nextInt();

            //determinar qual ação realizar
            switch(opcao) {
                case 1 -> {
                    System.out.println("Função para adicionar caminhão");
                    adicionarCaminhao();
                } case 2 -> {
                    System.out.println("Calcular distância total");
                    calcularDistanciaTotal();
                } case 3 -> {
                    System.out.println("Divisão de cargas entre caminhões");
                    divideCarga();
                } case 4 -> {
                    System.out.println("Verifica produtos");
                    carregaMaisPesado();
                } case 5 -> {
                    System.out.println("Somar peso das cargas");
                    somaPesoCarga();
                } case 6 -> {
                    System.out.println("Calcular custo total");
                    calcularCustoTotal();
                } case 6 -> {
                    System.out.println("Fechando programa...");
                    i = false;
                } default ->
                        System.out.println("Essa opção não existe! Por favor, digite uma opção válida!");
            }
        }
    }
}