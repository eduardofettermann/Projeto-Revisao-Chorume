package org.chorume.amarelinha.service;

import org.chorume.amarelinha.controller.GerenciadorDeCidades;
import org.chorume.amarelinha.model.Cidade;

import java.util.LinkedHashMap;


import static org.chorume.amarelinha.service.Amarelinha.SCANNER;
import static org.chorume.amarelinha.service.Amarelinha.menuPrincipal;

public class MenuConsultarTrechosEModalidades {
    GerenciadorDeCidades gerenciadorDeCidades = new GerenciadorDeCidades();
    LinkedHashMap<String, Cidade> cidades = gerenciadorDeCidades.retornaLinkedHashMapDeCidades();
    private String tamanhoDoCaminhaoEscolhido;

    public void exibeMenuSimulacaoTrajeto() {
        String cidadeDeOrigem = perguntaERetornaCidadeOrigem();
        String cidadeDeDestino = perguntaERetornaCidadeDestino();
        int distanciaEntreCidades = gerenciadorDeCidades.retornaDistanciaDaRota(cidadeDeOrigem, cidadeDeDestino);
        double precoPorKm = perguntaERetornaPrecoPorKmDoCaminhao();
        double custoTotal = distanciaEntreCidades * precoPorKm;
        System.out.printf("""
                Distância de %s e %s: %d
                Custo total da viagem com Caminhão %s: R$%.2f
                """, cidadeDeOrigem, cidadeDeDestino, distanciaEntreCidades, getTamanhoDoCaminhaoEscolhido(), custoTotal);
    }

    public void exibeMenuInicial() {
        System.out.println("""
                Digite a opção que deseja realizar:
                (1) - Consultar trechos
                (2) - Simular trecho
                                
                (0) - Sair
                                
                """);
        int opcao = SCANNER.nextInt();
        SCANNER.nextLine();
        switch (opcao) {
            case (1) -> {
                gerenciadorDeCidades.exibeListaDeCidades();
                exibeMenuInicial();
            }
            case (2) -> exibeMenuSimulacaoTrajeto();
            case (0) -> menuPrincipal();
        }
    }

    public String perguntaERetornaCidadeOrigem() {
        System.out.println("Digite o nome da cidade de origem:");
        String cidadeDeOrigem = SCANNER.nextLine();
        boolean cidadeEncontrada = gerenciadorDeCidades.estaNaListaDeCidades(cidadeDeOrigem, cidades);

        if (!cidadeEncontrada) {
            System.out.println("Cidade não encontrada! Verifique se digitou corretamente");
            perguntaERetornaCidadeOrigem();
        }
        return cidadeDeOrigem;
    }

    public String perguntaERetornaCidadeDestino() {
        System.out.println("Digite o nome da cidade de destino:");
        String cidadeDeDestino = SCANNER.nextLine();
        boolean cidadeEncontrada = gerenciadorDeCidades.estaNaListaDeCidades(cidadeDeDestino, cidades);

        if (!cidadeEncontrada) {
            System.out.println("Cidade não encontrada! Verifique se digitou corretamente");
        }
        return cidadeDeDestino;
    }

    public double perguntaERetornaPrecoPorKmDoCaminhao() {
        double precoPorKm = 0;
        System.out.println("""
                Qual o tipo de caminhão que realizará o transporte?
                (1) - P (Pequeno)
                (2) - M (Médio)
                (3) - G (Grande)
                """);
        int digitado = SCANNER.nextInt();
        SCANNER.nextLine();
        switch (digitado) {
            case (1) -> {
                setTamanhoDoCaminhaoEscolhido("Pequeno");
                precoPorKm = 5.83;
            }
            case (2) -> {
                setTamanhoDoCaminhaoEscolhido("Médio");
                precoPorKm = 13.42;
            }
            case (3) -> {
                setTamanhoDoCaminhaoEscolhido("Grande");
                precoPorKm = 29.21;
            }
        }
        return precoPorKm;
    }

    public String getTamanhoDoCaminhaoEscolhido() {
        return tamanhoDoCaminhaoEscolhido;
    }

    public void setTamanhoDoCaminhaoEscolhido(String tamanhoDoCaminhaoEscolhido) {
        this.tamanhoDoCaminhaoEscolhido = tamanhoDoCaminhaoEscolhido;
    }
}
