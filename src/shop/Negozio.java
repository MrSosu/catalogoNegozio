package shop;

import products.Articolo;
import products.TipoProdotto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Negozio {

    // attributi
    private String nome;
    private HashMap<Articolo, Integer> catalogo;

    // costruttori
    public Negozio(String nome) {
        this.nome = nome;
        this.catalogo = new HashMap<>();
    }

    public Negozio(String nome, HashMap<Articolo, Integer> catalogo) {
        this.nome = nome;
        this.catalogo = catalogo;
    }

    // getters
    public String getNome() { return nome; }
    public HashMap<Articolo, Integer> getCatalogo() { return catalogo; }

    // setters
    public void setNome(String nome) { this.nome = nome; }
    public void setCatalogo(HashMap<Articolo, Integer> catalogo) { this.catalogo = catalogo; }

    // metodi

    /**
     * questo metodo aggiunge un articolo al catalogo
     * @param a un articolo da aggiungere al catalogo
     */
    public void addArticolo(Articolo a) {
        if (!catalogo.containsKey(a)) {
            catalogo.put(a, 1);
        }
        else {
            catalogo.put(a, catalogo.get(a)+1);
        }
    }

    /**
     * questo metodo rimuove un articolo dal catalogo. Se dell'articolo vi è una quantità
     * maggiore di 1, viene semplicemente decrementata di una unità.
     * @param a un articolo da rimuovere
     */
    public void removeArticolo(Articolo a) {
        if (!catalogo.containsKey(a)) {
            throw new IllegalArgumentException("non posso rimuovere un articolo non presente!");
        }
        int value = catalogo.get(a);
        if (value == 1) {
            catalogo.remove(a);
        }
        else {
            catalogo.put(a, value - 1);
        }
    }

    /**
     * questo metodo prende in input il nome di un articolo e ritorna l'oggetto Articolo
     * associato presente nella mappa. Se non è presente nessun articolo con tale nome,
     * il metodo lancia una IllegalArgumentException.
     * @param nomeArticolo il nome dell'articolo da cercare
     * @return l'articolo con tale nome, IllegalArgumentException altrimenti
     */
    public Articolo getArticolo(String nomeArticolo) {
        for (Articolo a : catalogo.keySet()) {
            if (a.getNome().equals(nomeArticolo)) {
                return a;
            }
        }
        throw new IllegalArgumentException("Articolo con questo nome non presente");
    }

    /**
     * questo metodo applica uno sconto a tutti i prodotti del tipoProdotto passato in input.
     * @param tipoProdotto il tipo di prodotto da scontare
     * @param sconto lo sconto da applicare
     */
    public void applicaScontoPerTipo(TipoProdotto tipoProdotto, double sconto) {
        for (Articolo a : catalogo.keySet()) {
            if (a.getTipoProdotto().equals(tipoProdotto)) {
                a.applicaSconto(sconto);
            }
        }
    }

    /**
     * questo metodo scrive su un file csv le informazioni del catalogo
     * @param pathname il path del file dove scrivere
     * @throws IOException
     */
    public void salvaCatalogo(String pathname) throws IOException {
        File file = new File(pathname);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<Articolo, Integer> entry : catalogo.entrySet()) {
            bw.append(entry.getKey().toString() + "," + entry.getValue() + "\n");
        }
        bw.close();
    }

}
