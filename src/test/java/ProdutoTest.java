import org.chorume.amarelinha.entities.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void testProduto() {
        // Testes para produtos com pesos válidos
        Produto celular = new Produto("Celular", 0.7);
        assertEquals("Celular", celular.getNome());
        assertEquals(0.7, celular.getPeso());

        Produto geladeira = new Produto("Geladeira", 50.0);
        assertEquals("Geladeira", geladeira.getNome());
        assertEquals(50.0, geladeira.getPeso());


        // Teste para peso negativo (deve lançar uma exceção)
        assertThrows(IllegalArgumentException.class, () -> new Produto("Produto Inválido", -1.0));
    }

    @Test
    void testToString() {
        Produto produto = new Produto("Produto de Teste", 10.0);
        assertEquals("Produto{nome='Produto de Teste', peso=10.0}", produto.toString());
    }
}

