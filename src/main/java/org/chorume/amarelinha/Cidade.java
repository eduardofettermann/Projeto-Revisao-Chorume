package org.chorume.amarelinha;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cidade {
    private String nome;
    private LinkedHashMap<String, Integer> distancias;

    public Cidade() {
        distancias = new LinkedHashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LinkedHashMap<String, Integer> getDistancias() {
        return distancias;
    }
    public void adicionaCidadeAsDistancias(String nomeDaCidade,Integer distancia){
        getDistancias().put(nomeDaCidade,distancia);
    }

    public int retornaDistanciaDaCidade(String outraCidade) {
        return distancias.get(outraCidade);
    }

    public void setDistancias(LinkedHashMap<String, Integer> distancias) {
        this.distancias = distancias;
    }

    @Override
    public String toString() {
        String pulaLinha = "\n";
        String titulo = "Cidade: " + getNome();
        String subtitulo = "Nome - distância";
        StringBuilder cidades = new StringBuilder();
        for (Map.Entry<String, Integer> outraCidade : distancias.entrySet()) {
            String cidadeEDistancia = outraCidade.getKey() + " - " + outraCidade.getValue();
            cidades.append(cidadeEDistancia).append(pulaLinha);
        }
        return titulo + pulaLinha + subtitulo + pulaLinha + cidades;
    }
}
