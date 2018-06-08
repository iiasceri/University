import java.util.ArrayList;

public class Main {
    // Metoda main
    public static void main(String args[]){

        // Crearea retelei de calculatoare
        ArrayList<Calculator> retea = new ArrayList<Calculator>();

        retea.add(new Calculator());
        retea.add(new Calculator());
        // Compararea a doua perechi de calculatoare dupa greutate
        Calculator.comparareCalculatoare(retea.get(0), retea.get(1));

        // Compararea a doua perechi de calculatoare dupa vechime
        retea.get(0).comparareVechime(retea.get(1));

        // Gasirea celui mai scump calculator si afisarea propietarului acestuia
        double pret = 0;
        int winnerIndex = 0;
        for(Calculator c : retea){
            if(c.pretul() > pret){
                pret = c.pretul();
                winnerIndex = retea.indexOf(c);
            }
        }

        System.out.print("Proprietarul celui mai scump calculator este: " +
                retea.get(winnerIndex).getProprietar() + ". Pretul calculatorului este: " +
                retea.get(winnerIndex).pretul());

        System.out.print("\nClasa Calculator are " + Calculator.objectCount + " obiecte.");
    }
}
