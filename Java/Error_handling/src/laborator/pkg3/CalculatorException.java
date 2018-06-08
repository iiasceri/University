/*
 * To change this license header, chotexte License Headers in Project Properties.
 * To change this template file, chotexte Tools | Templates
 * and open the template in the editor.
 */
package laborator.pkg3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InputMismatchException;

public class CalculatorException extends Exception{
    String text;
    Object error;
    int number;
    double doubleNum;
    
    CalculatorException(double doubleNum){
        this.doubleNum = doubleNum;
    }
    CalculatorException(Object error){
        this.error = error;
    }
    CalculatorException(String text){
        this.text = text;
    }
    CalculatorException(int number){
        this.number = number;
    }
    
    public boolean prelucrare(){
        doubleNum = number;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if(error instanceof NumberFormatException){
            System.out.println("Ati introdus sir de caractere in loc de numar");
            return false;
        }
        else if(error instanceof InputMismatchException){
            System.out.println("Ati introdus date de tip gresit");
            return false;
        }
        else if(text.length() == 0 || " ".equals(text)){
            System.out.println("Continutul nu poate fi nul.");
            return false;
        }
        else if(text.equalsIgnoreCase("Windows") == false || text.equalsIgnoreCase("Linux") == false){
            System.out.println("Ati introdus un sistem de operare nesuportat.");
            return false;
        }
        else if(doubleNum < 0){
            System.out.println("Introduceti un numar mai mare ca zero.");
            return false;
        }
        else if(number <= 1960 || number > year){
            System.out.println("Introduceti un an intre 1960 si " + year);
            return false;
        }
        else if(error instanceof FileNotFoundException){
            System.out.println("Fisierul nu a fost gasit.");
            return false;
        }
        else if(error instanceof IOException){
            System.out.println("A intervenit o eroare la citirea fisierului.");
            return false;
        }
        else
            return true;
    }
}
