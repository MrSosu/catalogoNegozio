package discounts;

public interface Sconto {

    /**
     * questo metodo applica uno sconto
     * @param sconto lo sconto da applicare
     */
    void applicaSconto(double sconto);

    /**
     * questo metodo ritorna il prezzo scontato dell'oggetto
     * @return il prezzo totale scontato in base allo sconto sull'oggetto
     */
    double calcolaPrezzoScontato();

}
