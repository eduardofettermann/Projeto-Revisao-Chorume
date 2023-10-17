package org.chorume.amarelinha.controller;

import org.chorume.amarelinha.model.Cidade;

import java.util.LinkedHashMap;

public class GerenciadorDeCidades {
    private RegistradorDeCidades registradorDeCidades = new RegistradorDeCidades();
    private PesquisadorDeDistancias pesquisadorDeDistancias = new PesquisadorDeDistancias();

    /**
     * Retorna a distância entre a cidade origem e a cidade destino
     */
    public int retornaDistanciaDaRota(String cidadeOrigem, String cidadeDestino) {
        LinkedHashMap<String, Cidade> cidades = null;

        cidades = registradorDeCidades.retornaMapDasCidadesDoArquivo();

        int distancia = pesquisadorDeDistancias.retornaDistanciaDaRota(cidadeOrigem, cidadeDestino, cidades);
        return distancia;
    }

    public LinkedHashMap<String,Cidade> retornaLinkedHashMapDeCidades(){
        return registradorDeCidades.retornaMapDasCidadesDoArquivo();
    }

    public boolean estaNaListaDeCidades(String nomeDaCidade,LinkedHashMap<String,Cidade> linkedHashMapDeCidades){
        String nomeDaCidadeMaiusculo = nomeDaCidade.toUpperCase();
        return linkedHashMapDeCidades.containsKey(nomeDaCidadeMaiusculo);
    }

    public void exibeListaDeCidades(){
        System.out.println("Lista de cidades disponíveis:");
        LinkedHashMap<String,Cidade> cidades = retornaLinkedHashMapDeCidades();
        cidades.forEach((nome, cidade) -> System.out.println(nome));
    }
}
