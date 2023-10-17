package org.chorume.amarelinha.controller;

import java.io.*;

public class Leitor {
    private BufferedReader leitorBufferizado;
    private FileReader arquivoCSV;

    public String retornaProximaLinha() {
        String proximaLinha = null;
        try {
            proximaLinha = leitorBufferizado.readLine();
        } catch (IOException e) {
            return proximaLinha;
        }
        return proximaLinha;
    }

    public void fechaLeitor() {
        try {
            leitorBufferizado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Leitor() {
        try {
            setArquivoCSV("DistanciasCidadesCSV.csv");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.err.println("Ocorreu um erro: Verifique se o caminho indicado do arquivo .csv está correto!");
        }
        setLeitorBufferizado(getArquivoCSV());
    }

    public void setLeitorBufferizado(FileReader arquivoCSV) {
        this.leitorBufferizado = new BufferedReader(arquivoCSV);
    }

    public void setArquivoCSV(String caminhoArquivoCSV) throws FileNotFoundException {
        this.arquivoCSV = new FileReader(caminhoArquivoCSV);
    }

    public FileReader getArquivoCSV() {
        return arquivoCSV;
    }
}
