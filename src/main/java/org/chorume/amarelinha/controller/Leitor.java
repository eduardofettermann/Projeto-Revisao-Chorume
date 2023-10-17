package org.chorume.amarelinha.controller;

import java.io.*;

public class Leitor {
    private BufferedReader leitorBufferizado;
    private FileReader arquivoCSV;

    public String[] retornaProximaLinhaFracionada() {
        String[] dadosDaLinha;
        String proximaLinha;
        try {
            proximaLinha = leitorBufferizado.readLine();
            dadosDaLinha = proximaLinha.split(";");
            return dadosDaLinha;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] retornaStringPassadaEmArray(String stringPassada) {
        String[] dadosEmArray = stringPassada.split(";");
        return dadosEmArray;
    }

    public String retornaProximaLinha() {
        String proximaLinha;
        try {
            proximaLinha = leitorBufferizado.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        } catch (NullPointerException e) {
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
