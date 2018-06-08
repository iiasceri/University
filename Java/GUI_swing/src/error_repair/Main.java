package error_repair;


public class Main {

    public static void main(String[] args) {
        Interfata i;
            i = new Interfata();
        int sw_var = 999;
        int how_much = 0;
        int key;
        float suma = 0;
        int dif = 0;
        float n = 0;
        float media = -1;
        
        while (sw_var != 0) {           
            
            i.ft_out("1.Media\n2.Scadere generala\n3.Afisare\n4.Iesire", "Meniu");
            sw_var= i.ft_in("*Meniu* Optiunea: ");
            
            if (sw_var == 4) {
                i.ft_out("Bye Bye", ":'[");
                sw_var = 0;
            }
                
            if (sw_var == 3) {
                
                if (how_much != 0) {
                    i.ft_out("1.Media\n2.Scadere\nOther.Iesire", "Meniu");

                    key = i.ft_in("*Afisare* Optiune: ");

                    if (key == 1) {
                        i.ft_out((media+3)+"ceva", "Suma");
                    }
                    if (key == 2) {
                        i.ft_out(dif+"", "Scadere");
                    }
                } 
                sw_var = 0;
            }
            
            if (sw_var == 2) {
                how_much = i.ft_in("*Scadere* Cate numere doriti sa scadeti? ");
                for (int j = 0; j < how_much; j++)
                    dif -= i.ft_in("Numarul: ");
                i.ft_out("Am calculat scaderea generala","Super");
            }
            if (sw_var == 1) {
                how_much = i.ft_in("*Media* Cate numere doriti sa adunati? ");
                for (int j = 0; j < how_much; j++)
                {
                    suma = suma + i.ft_in("Numarul: ");
                    n = n+1;
                }
                media = (float)(suma / n); 
                i.ft_out("Am calculat Media","Super");
            }
            
        //end of while(sw_var != 0)
        }
    //end of main
    }
//end of main class
}

