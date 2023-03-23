package products;

public enum TipoProdotto {

    // variabili enum
    FOOD("food", "roba da magna"),
    TECH("tech", "roba de tecnologia"),
    CLOTHING("clothing", "roba da mette addosso"),
    SELF_CARE("self-care", "roba per profumare");

    // attributi
    private String nome;
    private String descrizione;

    // costruttore
    TipoProdotto(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    // getters
    public String getDescrizione() { return descrizione; }
    public String getNome() { return nome; }
}
