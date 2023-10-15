package entities;

import org.chorume.amarelinha.entities.Cidade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class CidadeTest {
    @Test
    void retornaDistanciaDaCidadeInserida(){
        // Arrange
        Cidade cidade = new Cidade();
        cidade.setNome("ARACAJU");
        LinkedHashMap<String,Integer> distancias = new LinkedHashMap<>();
        distancias.put("ARACAJU",0);
        distancias.put("BELEM",2079);
        cidade.setDistancias(distancias);
        // Act
        String outraCidade = String.format("Belem").toUpperCase();
        int distanciaDeOutraCidade = cidade.retornaDistanciaDaCidade(outraCidade);
        // Assert
        Assertions.assertEquals(2079,distanciaDeOutraCidade);
    }
}
