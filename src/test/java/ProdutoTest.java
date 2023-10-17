import org.chorume.amarelinha.model.Produto;
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

    @Test
    public void testEquals() {
        Produto produto1 = new Produto("Celular", 0.7);
        Produto produto2 = new Produto("Celular", 0.7);
        Produto produto3 = new Produto("Cadeira", 5.0);

        // Verifica se dois produtos iguais são considerados iguais pelo método equals
        assertTrue(produto1.equals(produto2));

        // Verifica se dois produtos diferentes são considerados diferentes pelo método equals
        assertFalse(produto1.equals(produto3));
    }

    @Test
    public void testHashCode() {
        Produto produto1 = new Produto("Celular",0.7);
        Produto produto2 = new Produto("Celular",0.7);
        Produto produto3 = new Produto("Cadeira",5.0);

        // Verifica se o hashCode é igual para dois produtos iguais
        assertEquals(produto1.hashCode(), produto2.hashCode());

        // Verifica se o hashCode é diferente para dois produtos diferentes
        assertNotEquals(produto1.hashCode(),produto3.hashCode());
    }
}

