package entities;

import org.chorume.amarelinha.model.Cidade;
import org.chorume.amarelinha.controller.PesquisadorDeDistancias;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class PesquisadorDeDistanciasTest {
@Test
    void verificaSeRetornaADistanciaCorretaDeUmaCidadeParaOutra() {
        PesquisadorDeDistancias pesquisadorDeDistancias = new PesquisadorDeDistancias();

        Cidade portoAlegre = new Cidade();
        LinkedHashMap<String, Integer> distanciasPortoAlegre = new LinkedHashMap<>();
        distanciasPortoAlegre.put("PORTO ALEGRE", 0);
        distanciasPortoAlegre.put("CURITIBA", 2206);
        portoAlegre.setDistancias(distanciasPortoAlegre);

        Cidade curitiba = new Cidade();
        LinkedHashMap<String, Integer> distanciasCuritiba = new LinkedHashMap<>();
        distanciasCuritiba.put("CURITIBA", 2206);
        distanciasCuritiba.put("PORTO ALEGRE", 0);
        curitiba.setDistancias(distanciasCuritiba);

        LinkedHashMap<String, Cidade> cidades = new LinkedHashMap<>();
        cidades.put("PORTO ALEGRE", portoAlegre);
        cidades.put("CURITIBA", curitiba);


        int distanciaRetornada = pesquisadorDeDistancias.retornaDistanciaDaRota("porto alegre", "curitiba", cidades);
        int distanciaEsperada = 2206;

        Assertions.assertEquals(distanciaEsperada, distanciaRetornada);
    }
}
