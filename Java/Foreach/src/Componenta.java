import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Random;

public class Componenta {
    String producator;
    String model;
    float greutate;
    short anulFabricarii;
    double pret;

    // Citirea datelor
    static String inString(){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try{
            str = buffer.readLine();
        }
        catch(Exception e){}
        return str;
    }

    // Conversia tipurilor de date
    static int inInt(){
        return (Integer.valueOf(inString())).intValue();
    }

    static double inDouble(){
        return (Float.valueOf(inString())).doubleValue();
    }

    int check;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    public Componenta(){

        // Citirea datelor despre componente
        //System.out.print("Introduceti datele despre componente.\n\n");
            // Citirea producatorului
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Producatorul componentei ");
                else
                    System.out.print("Denumirea producatorului nu poate fi nula. Introduceti o denumire valida pentru producator.\n");
                check = 1;
                producator = inString();
            }
            while(producator.isEmpty() == true);

            // Citirea modelului
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Modelul componentei ");
                else
                    System.out.print("Modelul componentei nu poate fi nula. Introduceti o denumire valida pentru model.\n ");
                check = 1;
                model = inString();
            }
            while(model.isEmpty() == true);

            // Citirea greutatii
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Greutatea componentei");
                else
                    System.out.print("Greutatea componentei trebuie sa fie mai mare decat 0. Introduceti o greutate valida.\n");
                check = 1;
                greutate = (float) inDouble();
            }
            while(greutate <= 0);

            // Citirea anului fabricarii componentei
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Anul fabricarii componentei ");
                else
                    System.out.print("Anul nu poate fi mai mic de 1960 sau mai mare decat anul curent. Introduceti un an valid.\n");
                check = 1;
                anulFabricarii = (short) inInt();
            }
            while(anulFabricarii <= 1960 || anulFabricarii > year);

            // Citirea pretului componentei
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Pretul componentei ");
                else
                    System.out.print("Pretul trebuie sa fie mai mare de 0.\n");
                check = 1;
                pret = inDouble();
            }
            while(pret <= 0);

        }

    public Componenta(String producator, String model, float greutateC, short anulFabricariiC, double pretC) {
        this.producator = producator;
        this.model = model;
        this.greutate = greutateC;
        this.anulFabricarii = anulFabricariiC;
        this.pret = pretC;
    }

    public Componenta(boolean isRandom){
        String[] producator1 = {"Samsung", "AMD", "Intel"};
        String[] model1 = {"Core i3", "Radeon HD566", "SSG431"};
        short[] anulFabricarii1 = {2007, 2009, 2013, 2015};

        producator = producator1[(new Random ()).nextInt(producator1.length)];
        model = model1[(new Random ()).nextInt(model1.length)];
        anulFabricarii = anulFabricarii1[(new Random ()).nextInt(anulFabricarii1.length)];
        greutate = (new Random().nextFloat()) * (new Random().nextInt(10) + 1);
        pret = (new Random().nextFloat()) * (new Random().nextInt(10) + 1);
    }

    public void print(){
        System.out.println("Producator: " + producator + "\nModel: " + model
         + "\nGreutate: " + greutate + "\nAnul fabricarii: " + anulFabricarii);
    }

}
