package main;

import products.Articolo;
import products.TipoProdotto;
import shop.Negozio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Articolo articolo1 = new Articolo("Mela", 0.55, TipoProdotto.FOOD);
        Articolo articolo2 = new Articolo("I-phone", 899.99, TipoProdotto.TECH);
        Articolo articolo3 = new Articolo("Pantaloni blu di Homer", 30.00, TipoProdotto.CLOTHING);
        Articolo articolo4 = new Articolo("Sapone peeee mano", 2.25, TipoProdotto.SELF_CARE);
        Articolo articolo5 = new Articolo("Insalata", 0.99, TipoProdotto.FOOD);

        Negozio negozio = new Negozio("Jet Market");
        negozio.addArticolo(articolo1);
        negozio.addArticolo(articolo2);
        negozio.addArticolo(articolo3);
        negozio.addArticolo(articolo4);
        negozio.addArticolo(articolo1);
        negozio.addArticolo(articolo5);

        Articolo a1 = negozio.getArticolo("Mela");
        System.out.println(a1);
        double discount_price = a1.calcolaPrezzoScontato();
        System.out.println(discount_price);
        // negozio.saveCatalogo("resources/catalogo.csv");
        // negozio.loadCatalogo("resources/catalogo.csv");

        // ottenere la lista di tutti i prodotti di tipo food
        List<Articolo> cibi =
                negozio.getCatalogo().keySet().stream()
                        .filter(a -> a.getTipoProdotto().equals(TipoProdotto.FOOD))
                        .toList();

        // ottenere il numero di articoli che costano più di 20 euro
        long piuDIVenti = negozio.getCatalogo().keySet().stream()
                .filter(a -> a.getPrezzo() > 20)
                .count();

        // ottenere la somma di tutti i prezzi dei prodotti  del catalogo
        double somma = negozio.getCatalogo().keySet().stream()
                .map(a -> a.getPrezzo())
                .reduce(0.0, Double::sum);

        // verificare che esista almeno un prodotto tech
        boolean isTech = negozio.getCatalogo().keySet().stream()
                .anyMatch(a -> a.getTipoProdotto().equals(TipoProdotto.TECH));

        // verificare che tutti gli articoli abbiano un prezzo maggiore di 1 euro
        boolean allMaggioreEuro = negozio.getCatalogo().keySet().stream()
                .allMatch(a -> a.getPrezzo() > 1);

        // verificare che tutti gli articoli non di tipo food abbiano un prezzo maggiore di 1 euro
        boolean nonFood = negozio.getCatalogo().keySet().stream()
                .filter(a -> !a.getTipoProdotto().equals(TipoProdotto.FOOD))
                .allMatch(a -> a.getPrezzo() > 1);

        // verificare che nessun articolo si chiami "fuffa"
        boolean noFuffa = negozio.getCatalogo().keySet().stream()
                .noneMatch(a -> a.getNome().equals("fuffa"));

        // leggere da un file con gli stream
        List<String> righeFile = Files.lines(Path.of("resources/catalogo.csv")).toList();

        System.out.println(righeFile);

    }



}
