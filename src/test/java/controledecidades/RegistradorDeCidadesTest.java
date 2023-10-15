package controledecidades;

import org.chorume.amarelinha.entities.Cidade;
import org.chorume.amarelinha.controledecidades.RegistradorDeCidades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class RegistradorDeCidadesTest {
    @Test
    void verificaSeRetornaLinkedHashMapComAsCidadesDoArquivoPassado(){
        RegistradorDeCidades registradorDeCidades = new RegistradorDeCidades();
        String caminhoComArquivoCSV = "src/main/java/org/chorume/amarelinha/DistanciasCidadesCSV.csv";

        LinkedHashMap<String, Cidade> cidades = registradorDeCidades.retornaMapDasCidadesDoArquivo(caminhoComArquivoCSV);

        Assertions.assertEquals(0,cidades.get("PORTO ALEGRE").getDistancias().get("PORTO ALEGRE"));
    }
}
