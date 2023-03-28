package main;

import products.Articolo;
import products.TipoProdotto;
import shop.Negozio;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Articolo articolo1 = new Articolo("Mela", 0.55, TipoProdotto.FOOD);
        Articolo articolo2 = new Articolo("I-phone", 899.99, TipoProdotto.TECH);
        Articolo articolo3 = new Articolo("Pantaloni blu di Homer", 30.00, TipoProdotto.CLOTHING);
        Articolo articolo4 = new Articolo("Sapone peeee mano", 2.25, TipoProdotto.SELF_CARE);

        Negozio negozio = new Negozio("Jet Market");
        negozio.addArticolo(articolo1);
        negozio.addArticolo(articolo2);
        negozio.addArticolo(articolo3);
        negozio.addArticolo(articolo4);
        negozio.addArticolo(articolo1);

        negozio.loadCatalogo("resources/catalogo.csv");
    }

}
