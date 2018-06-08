import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static Human Matrix[][];
    static String max_name = "-";
    static String min_name = "-";
    static int row, col;
    
    static{
    row = 100;
    col = 100;
    Matrix = new Human[row][col];

    for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                    Matrix[i][j] = new Human();
                    Randomize(Matrix[i][j]);
            }

    }
        public static void Randomize(Human tmp)
    {
        String names_male[] = {"Vanea","Jora","Prikoki","Sergiu","Vlad","Ion","John","Benedicht"}; // 8
        String names_female[] = {"Juana","Melissa","Angela","Vasilisa","Cris","Alexandrina","Ana","Maria"}; // 8
        tmp.gender = (new Random ()).nextBoolean();
        tmp.age = (new Random ()).nextInt(40)+1;
        if (tmp.gender)
        {
            //System.out.println("entered => gender is " + tmp.gender);
            tmp.name =  names_male[(new Random()).nextInt(7)];
        }
        else
            tmp.name = names_female[(new Random()).nextInt(7)];
    }
	public static void main(String[] args){
           // Human.printMatrix();
            for (int i = 0; i < Main.row; i++)
                (new Human(i)).start();
        try{
            Thread.sleep(4000);
            System.out.println("Astept 4 secunde ...Be nice okay?");
        } catch(InterruptedException e){}
        
        System.out.println("Numele final maximal este: " + Main.max_name);
    }
}