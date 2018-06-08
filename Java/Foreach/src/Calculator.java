import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.util.*;
class Calculator{

    String proprietar;
    ArrayList<Componenta> componente = new ArrayList<Componenta>();

    String os;

    static int k = 0; // Variabila ce salveaza numarul randului curent, pentru extragerea din fisier

    static int objectCount = 0;	// Numarul de obiecte

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

    // Functia de citire a fisierului
    static String readFile(String fileName)
    {
        int u = 0;
        String w = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                if(u == k)  w = line;
                u++;
            }

        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {}
            }
        }
        return w;
    }

    // Constructorul implicit
    Calculator(){

        // Citirea numelui proprietarului
        int check = 0;
        do{
            if(check == 0)
                System.out.print("Numele proprietarului: \n");
            else
                System.out.print("Numele proprietarului nu poate fi vid. Introduceti cel putin un caracter diferit de spatiu. \n");
            check = 1;
            proprietar = inString();
        }
        while(proprietar == " " || proprietar.length() == 0);

        // Citirea datelor despre componente
        System.out.print("Introduceti datele despre componente.\n\n");

        String answer = "yes";
        do{
            componente.add(new Componenta());
            System.out.println("Doriti sa mai introduceti elemente? Yes/No");
            answer = inString();
        }
        while(answer.equalsIgnoreCase("no") == false);

        // Citirea sistemului de operare
        check = 0;
        do{
            if(check == 0)
                System.out.print("Sistemul de operare\n");
            else
                System.out.print("Denumirea sistemului de operare nu poate fi nula. Introduceti o denumire valida pentru sistemul de operare.\n ");
            check = 1;
            os = inString();
        }
        while(os.length() == 0 || os == " ");
        objectCount++;
    }



    // Constructor de copiere
    Calculator(Calculator obiect) {
        proprietar = obiect.proprietar;
        componente = obiect.componente;
        os = obiect.os;

    }

    // Constructor cu valori aleatoare
    Calculator(boolean a){
        String[] nume = {"Nick", "John", "Sandu", "Pavel"};
        proprietar = nume[(new Random ()).nextInt(nume.length)];
        componente.add(new Componenta(true));
        os = "Windows 7 x64";
        objectCount++;
    }

    // Metoda de afisare
    void afisare(){
        System.out.println("Proprietar: " + proprietar);
        System.out.println("Lista de componente: \n");
        for(Componenta c: componente)
            c.print();
        System.out.println("\nSistemul de operare: " + os);
    }

    void modify(int num){
        if(num < componente.size())
            for(int i = num; i < componente.size(); i++)
                componente.remove(i);
        else
            for(int i = componente.size(); i < num; i++)
                    componente.add(new Componenta());
    }


    // Metoda ce returneaza greutatea totala a calculatorului.
    float greutatea(){
        float greutate = 0;
        for(Componenta c : componente)
            greutate += c.greutate;
        return greutate;
    }

    // Metoda ce returneaza pretul total al calculatorului.
    double pretul(){
        double pret = 0;
        for(Componenta c : componente)
            pret += c.pret;
        return pret;
    }

    // Metoda ce returneaza vechimea medie calculatorului.
    float vechime(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        float vechime = 0;
        int internCount = 0;
        for(Componenta c : componente)
            if(c.anulFabricarii != 0){
                vechime += (year - c.anulFabricarii);
                internCount++;
            }
        return (vechime/internCount);
    }

    // Metoda de comparare dupa vechime.
    void comparareVechime(Calculator calculator){
        if(this.vechime() > calculator.vechime())
            System.out.println("Calculatorul curent este mai vechi decat calculatorul indicat ca argument.");
        else if(this.vechime() < calculator.vechime())
            System.out.println("Calculatorul curent este mai nou decat calculatorul indicat ca argument.");
        else
            System.out.println("Calculatoarele sunt la fel de vechi.");
    }
    
    /*
     * 
     * Metodele set
     * 
     * */

    // Metoda de setare a proprietarului
    void setProprietar(String proprietar){
        if(proprietar != this.proprietar && proprietar.length() != 0){
            System.out.println("\n*Succes* Proprietarul a fost modificat.\nProprietarul vechi: " + this.proprietar);
            this.proprietar = proprietar;
            System.out.println("Proprietarul nou: " + this.proprietar);
        }
        else
            System.out.println("*Eroare* Datele nu au fost modificate deoarece nu ati introdus nimic sau numele nou coincide cu cel vechi.");
    }


    // Metoda de setare a producatorului
    void setProducator(int index, String producator){
        if(producator.isEmpty() == false && index >= 0 && index < componente.size() && !componente.get(index).producator.equalsIgnoreCase(producator)) {
            componente.get(index).producator = producator;
            System.out.println("*Succes* Producatorul a fost modificat.");

        }
        else
            System.err.println("*Eroare* Datele despre denumire nu au fost modificate deoarece a fost introdus un index incorect, nu ati introdus nimic sau datele introduse sunt identice cu cele vechi.");
    }

    // Metoda de setare a modelului
    void setModel(int index, String model){
        if(model.isEmpty() == false && index >= 0 && index < componente.size() && !componente.get(index).model.equalsIgnoreCase(model)) {
            componente.get(index).model = model;
            System.out.println("*Succes* Modelul a fost modificat.");
        }
        else
            System.err.println("*Eroare* Datele despre denumire nu au fost modificate deoarece a fost introdus un index incorect, nu ati introdus nimic sau datele introduse sunt identice cu cele vechi.");
    }


    // Metoda de setare a greutatii
    void setGreutate(int index, float greutateNoua){
        if(greutateNoua > 0 && index >=0 && index < componente.size() && componente.get(index).greutate != greutateNoua){
            System.out.println("*Succes* Greutatea a fost modificata.");
            componente.get(index).greutate = greutateNoua;
        }
        else
            System.out.println("*Eroare* Greutatea nu a fost modificata deoarece a fost indicat un index inacceptabil sau informatia introdusa coincide cu cea veche.");
    }

    // Metoda de setare a anului fabricarii
    void setAnulFabricarii(int index, short an){
        if(an > 1960 && an < 2017 && index >= 0 && index < componente.size() && componente.get(index).anulFabricarii != an){
            System.out.println("*Succes* Anul fabricarii componentei a fost modificat.");
            componente.get(index).anulFabricarii = an;
        }
        else
            System.out.println("*Eroare* Anul nu a fost modificat deoarece a fost indicat un index inacceptabil, an inacceptabil sau informatia introdusa coincide cu cea veche.");
    }

    // Metoda de setare a pretului
    void setPret(int index, double pret){
        if(index >= 0 && index < componente.size() && pret > 0 && pret != componente.get(index).pret){
            System.out.println("*Succes* Pretul componentei a fost modificat.");
            componente.get(index).pret = pret;
        }
        else
            System.out.println("*Eroare* Pretul nu a fost modificat deoarece a fost indicat un index inacceptabil, pret inacceptabil sau informatia introdusa coincide cu cea veche.");
    }

    // Metoda de setare a sistemului de operare
    void setOS(String SO){
        if(os != SO && SO.length() != 0){
            System.out.println("*Succes* Sistemul de operare a fost modificat. \nSistemul de operare vechi: " + os);
            os = SO;
            System.out.println("Sistemul de operare nou: " + os);
        }
        else
            System.out.println("*Eroare* Sistemul de operare nu a fost modificat deoarece nu ati introdus nimic sau informatia introdusa coincide cu cea veche.");
    }
    
    /*
     * 
     * Metodele get
     * 
     * */

    // Metoda de extragere a proprietarului
    String getProprietar(){
        return proprietar;
    }

    // Metoda de extragere a producatorului
    String getProducator(int index){
        if(index >= 0 && index < componente.size())
            return componente.get(index).producator;
        else{
            System.out.println("Ati introdus un index incorect (getProducator)");
            return "Eroare";
        }
    }

    // Metoda de extragere a modelului
    String getModel(int index){
        if(index >= 0 && index < componente.size())
            return componente.get(index).model;
        else{
            System.out.println("Ati introdus un index incorect (getModel)");
            return "Eroare";
        }
    }

    // Metoda de extragere a greutatii
    float getGreutateC(int index){
        if(index >= 0 && index < componente.size())
            return componente.get(index).greutate;
        else{
            System.out.println("Ati introdus un index incorect (getGreutateC)");
            return 0;
        }
    }

    // Metoda de extragere a anului fabricarii
    short getAnulFabricariiC(int index){
        if(index >= 0 && index < componente.size())
            return componente.get(index).anulFabricarii;
        else{
            System.out.println("Ati introdus un index incorect (getAnulFabricariiC)");
            return 0;
        }
    }

    // Metoda de extragere a pretului
    double getPret(int index){
        if(index >= 0 && index < componente.size())
            return componente.get(index).pret;
        else{
            System.out.println("Ati introdus un index incorect (getPret)");
            return 0;
        }
    }

    // Metoda de extragere a sistemului de operare
    String getOS(){
        return os;
    }

    static void comparareCalculatoare(Calculator c1, Calculator c2){
        float greutate1 = c1.greutatea(),
                greutate2 = c2.greutatea();
        if(greutate1 > greutate2)
            System.out.println("Primul calculator (" + greutate1 + ") este mai greu decat al doilea calculator (" + greutate2 + "). cu " + (greutate1 - greutate2));
        else if(greutate1 < greutate2)
            System.out.println("Primul calculator (" + greutate1 + ") este mai usor decat al doilea calculator (" + greutate2 + "). cu " + (greutate2 - greutate1));
        else
            System.out.println("Calculatoarele au aceeasi greutate - " + greutate1);
    }
}