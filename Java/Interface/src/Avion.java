import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public abstract class Avion implements IAntrenament{
    String              denumire;
    int                 viteza;
    int                 greutate;
    private static int  nrObiecte = 0;
    
    /* Primirea numarului de obiecte */
    static int getObjectsNumber(){
            return Avion.nrObiecte;
    }
    
    /* Citirea de la tastatura */
    String inString(){
            BufferedReader sacosa = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try{
                    str = sacosa.readLine();
            }
            catch(Exception e){}
            return str;
    }
    int inInt(){
            return (Integer.valueOf(inString())).intValue();
    }
    float inFloat(){
            return (Float.valueOf(inString())).floatValue();
    }

    /*
    *  Metodele Get
    */
    public final String getDenumire() {
            return denumire;
    }

    public final int getViteza() {
            return viteza;
    }

    public final int getGreutate() {
            return greutate;
    }
    
    /*
    *   Metodele Set
    */
    public final void setDenumire(String denumire) {
            if(denumire.length() != 0)
                    this.denumire = denumire;
            else
                    System.out.println("Denumirea nu poate fi nula. Datele nu au fost modificate.");
    }

    public final void setViteza(int viteza) {
            if(viteza >= 0)
                    this.viteza = viteza;
            else
                    System.out.println("Viteza nu poate fi negativa. Datele nu au fost modificate.");

    }

    public final void setGreutate(int greutate){
            if(greutate >= 0)
                    this.greutate = greutate;
            else
                    System.out.println("Greutatea nu poate fi negativa. Datele nu au fost modificate.");
    }
    //aici
    /* Constructori */
        /* Constructor implicit */
    Avion(){
        boolean isFirst = true;

        System.out.println("Introduceti denumirea: ");
        // Introducerea denumirii
        do{
                if(isFirst == false)
                        System.out.println("** Eroare ** \nDenumirea nu poate fi nula. Introduceti o valoare valida.");
                denumire = inString();
                isFirst = false;
        }
        while(denumire.length() == 0);

        // Introducerea vitezei
        System.out.println("Introduceti viteza: ");
        isFirst = true;
        do{
                if(isFirst == false)
                        System.out.println("** Eroare ** \nViteza nu poate fi negativa sau nula. Introduceti o valoare valida.");
                viteza = inInt();
                isFirst = false;
        }
        while(viteza <= 0);

        // Introducerea greutatii
        System.out.println("Introduceti greutatea: ");
        isFirst = true;
        do{
                if(isFirst == false)
                        System.out.println("** Eroare ** \nGreutatea nu poate fi nula. Introduceti o valoare valida.");
                greutate = inInt();
                isFirst = false;
        }
        while(greutate < 0);		
        Avion.nrObiecte++;
    }

            /* Constructor cu toti parametrii */
    Avion(String denumire, int viteza, int greutate){
            this.denumire = denumire;
            this.viteza = viteza;
            this.greutate = greutate;
            Avion.nrObiecte++;
    }

            /* Constructor cu valori aleatoare */
    Avion(boolean unused){
            String[] randDenumire = {"747", "B32", "SGH-222", "G99"};
            this.denumire = randDenumire[(new Random().nextInt(randDenumire.length))];
            viteza = new Random().nextInt(100);
            greutate = new Random().nextInt(viteza*100);
    }
    void afisare(){
            System.out.println("Denumire: " + denumire 
                            + "\nViteza: " + viteza + "\nGreutate: " 
                            + greutate);
    }
    
    static void comparareAvioane(Avion a1, Avion a2){
        if(a1.greutate > a2.greutate)
            System.out.println("Primul avion (" + a1.greutate + ") este mai greu decat al doilea avion (" + a2.greutate + "). cu " + (a2.greutate - a2.greutate));
        else if(a1.greutate < a2.greutate)
            System.out.println("Primul avion (" + a1.greutate + ") este mai usor decat al doilea avion (" + a2.greutate + "). cu " + (a2.greutate - a2.greutate));
        else
            System.out.println("avioanele au aceeasi greutate - " + a1.greutate);
    }
    public abstract void antrenament();
}
