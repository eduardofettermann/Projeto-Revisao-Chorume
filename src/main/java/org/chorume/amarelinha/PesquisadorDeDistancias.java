package org.chorume.amarelinha;

import java.util.LinkedHashMap;

public class PesquisadorDeDistancias {

/** Retorna a distância entre a cidade origem e a cidade destino com base na LinkedHashMap passada*/
    public int retornaDistanciaDaRota(String cidadeOrigem, String cidadeDestino, LinkedHashMap<String, Cidade> cidades) {
        String cidadeOrigemUpperCase = cidadeOrigem.toUpperCase();
        String cidadeDestinoUpperCase = cidadeDestino.toUpperCase();
        int distancia = cidades.get(cidadeOrigemUpperCase).getDistancias().get(cidadeDestinoUpperCase);
        return distancia;
    }
}
