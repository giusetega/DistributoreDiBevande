package lesson10.distributore_bevande;

public class MainDistributoreDiBevande {

    public static void main (String[] arg){
        Caffe caffe = new Caffe("caffe", 0.5f);
        Cappuccino cappuccino = new Cappuccino("cappuccino", 1);
        DistributoreDiBevande distributoreDiBevande = new DistributoreDiBevande(10);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(cappuccino);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(cappuccino);

        System.out.println();
        distributoreDiBevande.start();
        distributoreDiBevande.start();
//        distributoreDiBevande.printProdotti();


//        System.out.println();
//        distributoreDiBevande.start();
//        distributoreDiBevande.start();
//        distributoreDiBevande.printProdotti();

//        System.out.println();
//        distributoreDiBevande.printProdotti();
    }

}
