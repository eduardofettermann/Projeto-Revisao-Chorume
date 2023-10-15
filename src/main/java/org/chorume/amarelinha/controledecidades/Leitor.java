package org.chorume.amarelinha.controledecidades;

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

    public void fechaLeitor(){
        try {
            leitorBufferizado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Leitor(String caminhoDoArquivoCSV) throws FileNotFoundException {
        setArquivoCSV(caminhoDoArquivoCSV);
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
