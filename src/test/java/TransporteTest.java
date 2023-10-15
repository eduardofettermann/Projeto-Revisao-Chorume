import org.chorume.amarelinha.entities.Produto;
import org.chorume.amarelinha.entities.Transporte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class TransporteTest {
//    @Test
//    public void ordenaCarga() {
//        LinkedHashMap<Produto, Integer> carga1 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("PlayStation 5", 3.90), 13);
//            put(new Produto("Geladeira", 50.00), 38);
//            put(new Produto("Luminária", 0.80), 5);
//            put(new Produto("Lavadora de roupa", 15.00), 36);
//        }};
//        LinkedHashMap<Produto, Integer> carga2 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("Air Fryer", 3.50), 14);
//            put(new Produto("Nintendo Switch", 0.30), 14);
//            put(new Produto("Celular", 0.70), 27);
//            put(new Produto("Cadeira", 5.00), 23);
//        }};
//        LinkedHashMap<Produto, Integer> carga3 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("Lavadora de roupa", 15.00), 36);
//            put(new Produto("Geladeira", 50.00), 38);
//            put(new Produto("Cadeira", 5.00), 23);
//            put(new Produto("PlayStation 5", 3.90), 13);
//        }};
//
//        LinkedHashMap<Produto, Integer> cargaOrdenadaMetodo1 = Transporte.ordenaCarga(carga1);
//        LinkedHashMap<Produto, Integer> cargaOrdenadaMetodo2 = Transporte.ordenaCarga(carga2);
//        LinkedHashMap<Produto, Integer> cargaOrdenadaMetodo3 = Transporte.ordenaCarga(carga3);
//
//        LinkedHashMap<Produto, Integer> cargaOrdenada1 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("Luminária", 0.80), 5);
//            put(new Produto("PlayStation 5", 3.90), 13);
//            put(new Produto("Lavadora de roupa", 15.00), 36);
//            put(new Produto("Geladeira", 50.00), 38);
//        }};
//        LinkedHashMap<Produto, Integer> cargaOrdenada11 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("Luminária", 0.80), 5);
//            put(new Produto("PlayStation 5", 3.90), 13);
//            put(new Produto("Lavadora de roupa", 15.00), 36);
//            put(new Produto("Geladeira", 50.00), 38);
//        }};
//        LinkedHashMap<Produto, Integer> cargaOrdenada2 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("Nintendo Switch", 0.30), 14);
//            put(new Produto("Celular", 0.70), 27);
//            put(new Produto("Air Fryer", 3.50), 14);
//            put(new Produto("Cadeira", 5.00), 23);
//        }};
//        LinkedHashMap<Produto, Integer> cargaOrdenada3 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("PlayStation 5", 3.90), 13);
//            put(new Produto("Cadeira", 5.00), 23);
//            put(new Produto("Lavadora de roupa", 15.00), 36);
//            put(new Produto("Geladeira", 50.00), 38);
//        }};
//
//        Assertions.assertEquals(cargaOrdenada1, cargaOrdenada11);
//
//    }

//    @Test
//    public void testComparacaoDeMapas() {
//        LinkedHashMap<Produto, Integer> cargaOrdenada1 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("Luminária", 0.80), 5);
//            put(new Produto("PlayStation 5", 3.90), 13);
//            put(new Produto("Lavadora de roupa", 15.00), 36);
//            put(new Produto("Geladeira", 50.00), 38);
//        }};
//        LinkedHashMap<Produto, Integer> cargaOrdenada11 = new LinkedHashMap<Produto, Integer>() {{
//            put(new Produto("Luminária", 0.80), 5);
//            put(new Produto("PlayStation 5", 3.90), 13);
//            put(new Produto("Lavadora de roupa", 15.00), 36);
//            put(new Produto("Geladeira", 50.00), 38);
//        }};
//
//
//        // Use a assertiva assertEquals para comparar os mapas
//        Assertions.assertEquals(new Produto("Luminária", 0.80), new Produto("Luminária", 0.80));
//    }

//    @Test
//    public void somaPesoCarga() {
//
//        Transporte transporte = new Transporte();
//    }
}
