package org.chorume.amarelinha.controller;

import org.chorume.amarelinha.model.Cidade;

import java.util.LinkedHashMap;

public class GerenciadorDeCidades {
    private RegistradorDeCidades registradorDeCidades = new RegistradorDeCidades();
    private PesquisadorDeDistancias pesquisadorDeDistancias = new PesquisadorDeDistancias();
    private String caminhoDoArquivoCSV;

    /**
     * Retorna a distância entre a cidade origem e a cidade destino
     */
    public int retornaDistanciaDaRota(String cidadeOrigem, String cidadeDestino) {
        LinkedHashMap<String, Cidade> cidades = null;

        cidades = registradorDeCidades.retornaMapDasCidadesDoArquivo(caminhoDoArquivoCSV);

        int distancia = pesquisadorDeDistancias.retornaDistanciaDaRota(cidadeOrigem, cidadeDestino, cidades);
        return distancia;
    }

    public GerenciadorDeCidades(String caminhoDoArquivoCSV) {
        this.caminhoDoArquivoCSV = caminhoDoArquivoCSV;
    }
}
