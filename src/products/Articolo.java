package products;

import discounts.Sconto;

public class Articolo extends Product implements Sconto {

    // attributi statici
    private static int idTot = 0;

    // attributi
    private int id;
    private String descrizione;
    private TipoProdotto tipoProdotto;
    private double sconto = 0.0;

    // costruttore
    public Articolo(String nome, double prezzo) {
        super(nome, prezzo);
        this.id = idTot++;
    }

    public Articolo(String nome, double prezzo, TipoProdotto tipoProdotto) {
        super(nome, prezzo);
        this.id = idTot++;
        this.descrizione = tipoProdotto.getDescrizione();
        this.tipoProdotto = tipoProdotto;
    }

    // getters
    public int getId() { return id; }
    public String getDescrizione() { return descrizione; }
    public TipoProdotto getTipoProdotto() { return tipoProdotto; }
    public double getSconto() { return sconto; }


    @Override
    public void applicaSconto(double sconto) {
        this.sconto = sconto;
    }

    @Override
    public double calcolaPrezzoScontato() {
        return prezzo - (prezzo / 100 * sconto);
    }

    @Override
    public String toString() {
        return nome + "," + prezzo + "," + tipoProdotto;
    }
}
