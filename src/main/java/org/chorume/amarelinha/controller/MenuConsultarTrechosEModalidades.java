package org.chorume.amarelinha.controller;

import org.chorume.amarelinha.model.Cidade;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class MenuConsultarTrechosEModalidades {
    GerenciadorDeCidades gerenciadorDeCidades = new GerenciadorDeCidades();
    LinkedHashMap<String, Cidade> cidades = gerenciadorDeCidades.retornaLinkedHashMapDeCidades();
    Scanner scanner = new Scanner(System.in);
    private String tamanhoDoCaminhaoEscolhido;

    public void exibeMenuConsultarTrechosEModalidades() {
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

    public String perguntaERetornaCidadeOrigem() {
        System.out.println("Digite o nome da cidade de origem:");
        String cidadeDeOrigem = scanner.nextLine();
        boolean cidadeEncontrada = gerenciadorDeCidades.estaNaListaDeCidades(cidadeDeOrigem, cidades);

        if (!cidadeEncontrada) {
            System.out.println("Cidade não encontrada! Verifique se digitou corretamente");
        }
        return cidadeDeOrigem;
    }

    public String perguntaERetornaCidadeDestino() {
        System.out.println("Digite o nome da cidade de destino:");
        String cidadeDeDestino = scanner.nextLine();
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
        int digitado = scanner.nextInt();
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
