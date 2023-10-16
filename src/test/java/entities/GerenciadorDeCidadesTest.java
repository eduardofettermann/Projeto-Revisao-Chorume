package entities;

import org.chorume.amarelinha.controller.GerenciadorDeCidades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GerenciadorDeCidadesTest {
    @Test
    void verificaSeRetornaADistanciaDeUmaCidadeParaAOutra() {
        GerenciadorDeCidades gerenciadorDeCidades = new GerenciadorDeCidades("DistanciasCidadesCSV.csv");

        int distanciaRetornada = gerenciadorDeCidades.retornaDistanciaDaRota("Porto alegre","Curitiba");
        int distanciaDePortoAlegreACuritiba = 711;

        Assertions.assertEquals(distanciaDePortoAlegreACuritiba,distanciaRetornada);
    }
}
