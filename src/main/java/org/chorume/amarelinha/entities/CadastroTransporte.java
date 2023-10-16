package org.chorume.amarelinha.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class CadastroTransporte {
    public List<String> cidades = new ArrayList<>(); // Modificar para List<Cidade>
    private LinkedHashMap<Produto, Integer> carga;
    private Scanner scanner = new Scanner(System.in);
    private int nCidades = cidades.size();

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
