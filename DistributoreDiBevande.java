package lesson10.distributore_bevande;

import java.util.Arrays;
import java.util.Scanner;

public class DistributoreDiBevande {

    private static Prodotto[] prodotti;
    private static float saldoDistributore;
    private static float priceSelectProd;

    public DistributoreDiBevande(int n){
        prodotti = new Prodotto[n];
    }

    public void start(){
        inserisciImporto(false);
        getSaldoAttuale();
        System.out.println("Attendere l'erogazione del " + scegliProdotto().getCodice() + "...");
        System.out.println("Prendere il resto di " + getResto() + "€");
        saldoDistributore = 0;
    }

    public void caricaProdotto(Prodotto p){
        for (int i = 0; i < prodotti.length; i++){
            if(prodotti[i] == null){
                prodotti[i] = p;
                break;
            }
        }
    }

    private void inserisciImporto(boolean addMoreMoney){
        Scanner scanner = new Scanner(System.in);
        if (addMoreMoney){
            System.out.println("Inserisci i soldi mancanti: ");
        } else {
            System.out.println("Inserisci soldi: ");
        }
        float importo = Math.round(scanner.nextFloat() * 100) / 100.0f;
        saldoDistributore += importo;
        System.out.println(getSaldoAttuale());
    }

    private Prodotto scegliProdotto(){
        String codiceProd = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Scrivi il nome del prodotto che vuoi scegliere: ");
             codiceProd = scanner.nextLine();
        } while (!seEsiste(codiceProd));


        for (Prodotto prod : prodotti){
            // Controllo se il saldo è OK
            if (prod != null && saldoIsOk(prod.getPrezzo())){
                // Aggiorno il priceSelectProd, rimuovo il prodotto e poi lo ritorno
                if (prod.getCodice().equals(codiceProd) ){
                    priceSelectProd = prod.getPrezzo();
                    rimuoviProdotto(prod);
                    return prod;
                }
            }
        }
        System.out.println("Errore!");
        return null;
    }

    /**
     * Controlla se un codice prodotto è presente o meno nell'array prodotti
     * @param codiceProd preso dopo avere invocato il metodo scegliProdotto()
     * @return boolean
     */
    private boolean seEsiste(String codiceProd){
        for (Prodotto prod: prodotti){
            if (prod != null && codiceProd.equals(prod.getCodice()))
                return true;
        }
        return false;
    }

    /**
     * Add money finchè non si raggiunge il prezzo del prodotto scelto
     * @param prezzo
     * @return boolean
     */
    private boolean saldoIsOk(float prezzo){
        while (saldoDistributore < prezzo){
            inserisciImporto(true);
        }
        return true;
    }

    private float getSaldoAttuale(){
        return Math.round(saldoDistributore * 100.0) / 100.0f;
    }

    private float getResto(){
        return Math.round((saldoDistributore - priceSelectProd) * 100.0) / 100.0f;
    }

    public void printProdotti(){
        for(Prodotto prod : prodotti){
            System.out.println(prod);
        }
    }

    private void rimuoviProdotto(Prodotto p){
        for (int i = 0; i < prodotti.length; i++){
            if (prodotti[i] != null){
                if (prodotti[i].equals(p) ){
                    prodotti[i] = null;
                    break;
                }
            }

        }
    }

    @Override
    public String toString(){
        return Arrays.toString(prodotti);
    }

}
