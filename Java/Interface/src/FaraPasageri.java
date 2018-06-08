import java.util.Random;

public class FaraPasageri extends Avion implements IViraj {
    float               vizibilitate;
    int                 nrPiloti;
    float               pret;
    private static int  nrObiecte = 0;

    /* Primirea numarului de obiecte */
    static int getObjectsNumber(){
            return FaraPasageri.nrObiecte;
    }

    /* Getters */
    public final float getVizibilitate() {
            return vizibilitate;
    }

    public final int getNrPiloti() {
            return nrPiloti;
    }

    public final float getPret() {
            return pret;
    }

    /* Setters */
    public final void setViteza(float vizibilitate) {
            if(vizibilitate > 0)
                    this.vizibilitate = vizibilitate;
            else
                    System.out.println("Vizibilitatea nu poate fi negativa sau nula. Datele nu au fost modificate.");
    }

    public final void setNrPiloti(int nrPiloti) {
            if(nrPiloti > 0)
                    this.nrPiloti = nrPiloti;
            else
                    System.out.println("Numarul de piloti nu poate fi negativ sau nul. Datele nu au fost modificate.");
    }

    public final void setPret(float pret) {
            if(pret > 0)
                    this.pret = pret;
            else
                    System.out.println("Pretul nu poate fi negativ sau nul. Datele nu au fost modificate.");
    }

    /* Constructori */
            /* Constructor implicit */
    public FaraPasageri() {
            super();
            boolean isFirst = true;

            // Introducerea vizibilitatii
            System.out.println("Introduceti vizibilitatea: ");
            do{
                    if(isFirst == false)
                            System.out.println("** Eroare ** \nVizibiliatatea nu poate fi negativa sau nula. Introduceti o valoare valida.");
                    vizibilitate = inFloat();
                    isFirst = false;
            }
            while(vizibilitate <= 0);

            // Introducerea numarului de piloti
            System.out.println("Introduceti numarul de piloti: ");
            isFirst = true;
            do{
                    if(isFirst == false)
                            System.out.println("** Eroare ** \nNumarul de piloti nu poate fi negativ sau nul. Introduceti o valoare valida.");
                    nrPiloti = inInt();
                    isFirst = false;
            }
            while(nrPiloti <= 0);

            // Introducerea pretului
            System.out.println("Introduceti pretul: ");
            isFirst = true;
            do{
                    if(isFirst == false)
                            System.out.println("** Eroare ** \nPretul nu poate fi negativ. Introduceti o valoare valida.");
                    pret = inFloat();
                    isFirst = false;
            }
            while(pret < 0);
            System.out.println("\n");
            FaraPasageri.nrObiecte++;
    }

            /* Constructor cu toti parametrii */
    public FaraPasageri(String denumire, int viteza, int greutate, 
                    float vizibilitate, int nrPiloti, float pret) {
            super(denumire, viteza, greutate);
            this.vizibilitate = vizibilitate;
            this.nrPiloti = nrPiloti;
            this.pret = pret;
            FaraPasageri.nrObiecte++;
    }

            /* Constructor cu valori aleatoare */
    public FaraPasageri(boolean unused){
            super(unused);
            this.vizibilitate = 30 + (new Random().nextFloat()) + (new Random().nextInt(50));
            this.greutate += (vizibilitate % 10) * 100;
            this.nrPiloti = new Random().nextInt(1000);
            this.pret = this.viteza * this.greutate / 2 * (new Random().nextInt(10));
    }


    void afisare(){
            super.afisare();
            System.out.println("Vizibilitatea: " + vizibilitate + "\nNr. Piloti: "
                             + nrPiloti + "\nPret: " + pret);
    }

    public void antrenament(){
            nrPiloti = 1;
            pret += 100;
            System.out.println("-------------Antrenament reactia a fost schimbata-------------\n");
    }
    public void viraj(){
        vizibilitate -= 10;
        System.out.println("-------------Viraj vizibilitatea a fost schimbata-------------\n");
    }

}