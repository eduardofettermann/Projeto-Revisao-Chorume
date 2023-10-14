import org.chorume.amarelinha.GerenciadorDeCidades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GerenciadorDeCidadesTest {
    @Test
    void verificaSeRetornaADistanciaDeUmaCidadeParaAOutra() {
        GerenciadorDeCidades gerenciadorDeCidades = new GerenciadorDeCidades("src/main/java/org/chorume/amarelinha/DistanciasCidadesCSV.csv");

        int distanciaRetornada = gerenciadorDeCidades.retornaDistanciaDaRota("Porto alegre","Curitiba");
        int distanciaDePortoAlegreACuritiba = 2206;

        Assertions.assertEquals(distanciaDePortoAlegreACuritiba,distanciaRetornada);
    }
}
