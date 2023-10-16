package org.chorume.amarelinha.entities;

import java.util.*;

public class CadastroTransporte {
    public List<String> cidades = new ArrayList<>(); // Modificar para List<Cidade>
    private LinkedHashMap<Produto, Integer> carga;
    private Scanner scanner = new Scanner(System.in);
    private int nCidades = cidades.size();

    private List<Produto> produtosPermitidos = Arrays.asList(
            new Produto("Celular", 0.7),
            new Produto("Geladeira", 50.0),
            new Produto("Air Fryer", 3.5),
            new Produto("Cadeira", 5.0),
            new Produto("Luminária", 0.8),
            new Produto("Lavadora de roupa", 15.0),
            new Produto("PlayStation 5", 3.9),
            new Produto("Nintendo Switch", 0.3)
    );

    public void cadastraCidades() {
        String cidadeInput;
        // Cidade cidade;
        boolean listando = true;
        do {
            try {
                System.out.printf("Digite a cidade %d (X para sair): ", nCidades);
                cidadeInput = scanner.nextLine();
                if (!cidadeInput.equalsIgnoreCase("X")) {
                    // cidade = verificaCidade(cidadeInput); Substituir por método que verifica cidade
                    cidades.add(cidadeInput); // Substituir cidadeInput por cidade
                } else {
                    listando = false;
                }
            } catch (Exception e) { // Trocar por Exception de cidade inexistente
                System.out.println("Cidade inválida!");
            }
        } while (listando);
    }

    public void imprimeCidades() {
    } // Implementar método que lista as cidades já cadastradas

    public void removeCidades() {
    } // Implementar método para remover cidade adicionada
}
