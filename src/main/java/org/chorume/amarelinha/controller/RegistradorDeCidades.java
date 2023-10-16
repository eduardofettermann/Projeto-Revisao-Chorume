package org.chorume.amarelinha.controller;

import org.chorume.amarelinha.model.Cidade;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

public class RegistradorDeCidades {
    /**
     * Retorna a um map chave: nome da cidade, chave: Objeto da cidade com outro map com as distâncias das outras cidades
     */
    public LinkedHashMap<String, Cidade> retornaMapDasCidadesDoArquivo(String caminhoDoArquivoCsv) {
        LinkedHashMap<String, Cidade> cidadesMap = new LinkedHashMap<>();
        try {
            Leitor leitor = new Leitor(caminhoDoArquivoCsv);
            String linhaDoCabecalho = leitor.retornaProximaLinha();
            String[] nomeDasCidades = linhaDoCabecalho.split(";");

            int iDaLinha = 0;
            String linha;

            while ((linha = leitor.retornaProximaLinha()) != null) {
                Cidade cidade = new Cidade();
                String cidadeNome = nomeDasCidades[iDaLinha];
                cidade.setNome(cidadeNome);
                String[] distanciasDaCidade = linha.split(";");

                for (int i = 0; i < distanciasDaCidade.length; i++) {
                    String nomeDaOutraCidade = nomeDasCidades[i];
                    int distanciaDaOutraCidade = Integer.parseInt(distanciasDaCidade[i]);
                    cidade.adicionaCidadeAsDistancias(nomeDaOutraCidade, distanciaDaOutraCidade);
                }
                cidadesMap.put(cidadeNome, cidade);
                iDaLinha++;
            }
            leitor.fechaLeitor();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo CSV não encontrado no caminho!");
        }

        return cidadesMap;
    }
}