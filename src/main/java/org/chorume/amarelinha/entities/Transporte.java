package org.chorume.amarelinha.entities;

public class Transporte {
    public HashMap<Produto, Integer> carga = new HashMap<>(); // <Produto, Quantidade>

    public double somaPesoCarga(HashMap<Produto, Integer> carga) {
        double total = 0.0;
        for (Map.Entry<Produto,Integer> produto : carga.entrySet()) {
            total += produto.getKey().getPeso() * produto.getValue();
        }
        return total;
    }
}
