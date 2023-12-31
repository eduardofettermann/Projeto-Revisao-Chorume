package entities;

import org.chorume.amarelinha.model.Cidade;
import org.chorume.amarelinha.controller.RegistradorDeCidades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class RegistradorDeCidadesTest {
    @Test
    void verificaSeRetornaLinkedHashMapComAsCidadesDoArquivoPassado() {
        RegistradorDeCidades registradorDeCidades = new RegistradorDeCidades();

        LinkedHashMap<String, Cidade> cidades = registradorDeCidades.retornaMapDasCidadesDoArquivo();

        Assertions.assertEquals(0, cidades.get("PORTO ALEGRE").getDistancias().get("PORTO ALEGRE"));
    }
}
