package lesson10.distributore_bevande;

import java.util.Objects;

public class Prodotto {

    private static final int COD_PRODUCT_CAFFE = 7;
    private static final int COD_PRODUCT_CAPPUCCINO = 14;

    private String codice;
    private float prezzo;

    public Prodotto(String codice, float prezzo){
            this.codice = codice;
            this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public float getPrezzo() {
        return prezzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return Objects.equals(codice, prodotto.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codice='" + codice + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
