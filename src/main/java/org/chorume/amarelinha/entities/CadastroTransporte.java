package org.chorume.amarelinha.entities;

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
        }
    }
}