package products;

public abstract class Product {

    // attributi
    protected String nome;
    protected double prezzo;

    // costruttore
    public Product(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    // getters
    public String getNome() { return nome; }
    public double getPrezzo() { return prezzo; }

    // setters
    public void setNome(String nome) { this.nome = nome; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
}
