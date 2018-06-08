/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator.pkg3;
/*
Din lab 1,  clasa proprie pentru prelucrarea erorilor, trei tipuri de prelucrare: prelucrare 
simpla, lenesa, try in try, nici o prelucrare nu trebuie sa fie in clasa de baza
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Random;

class Calculator{
    
    String proprietar;
    byte nrComponente;
    String[][] denumireC; // Producator si model
    float[] greutateC;
    short[] anulFabricariiC;
    double[] pretC;
    String os;
    
    static int k = 0; // Variabila ce salveaza numarul randului curent, pentru extragerea din fisier
    
    static int objectCount = 0;	// Numarul de obiecte

    // Citirea datelor
    static String inString() throws CalculatorException{
        BufferedReader buffer;
        buffer = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try
        {
            str = buffer.readLine();
        }
        catch(IOException e){
            throw new CalculatorException(e);
        }
        return str;
    }

    // Conversia tipurilor de date
    static int inInt() throws CalculatorException{
        try{
            return (Integer.valueOf(inString()));
        }catch(NumberFormatException e){
            try{
                throw new CalculatorException(e);
            }catch(CalculatorException f){
                f.prelucrare();
                return 0;
            }
        }
    }

    static double inDouble() throws CalculatorException{
        try{
            return (Float.valueOf(inString())).doubleValue();
        }catch(NumberFormatException e){
            try{
                throw new CalculatorException(e);
            }catch(CalculatorException f){
                f.prelucrare();
                return 0;
            }
        }
    }
    
    // Functia de citire a fisierului
    static String readFile(String fileName) throws CalculatorException {
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
    
    void writeFile(String fileName) throws CalculatorException{
    	try(FileWriter writer = new FileWriter(fileName, false))
        {
    		String denumire = "";
    		String greutate = "";
    		String anulFabricarii = "";
    		String pret = "";
    		for(int i = 0; i < nrComponente; i++){
    			denumire = denumire + denumireC[i][0] + "\r\n" + denumireC[i][1] + "\r\n";
    			greutate = greutate + greutateC[i] + "\r\n";
    			anulFabricarii = anulFabricarii + anulFabricariiC[i] + "\r\n";
    			pret = pret + pretC[i] + "\r\n";
    		}
            String text = proprietar + "\r\n" + nrComponente + "\r\n" + denumire + greutate + anulFabricarii + pret + os;
            writer.write(text);
            writer.flush();
            writer.close();
        }
        catch(FileNotFoundException e){
            throw new CalculatorException(e);
        }
        catch(IOException e){
            throw new CalculatorException(e);
        }
    }

    // Constructorul implicit
    Calculator() throws CalculatorException{
        // Citirea numelui proprietarului
        boolean flag;
        do{
            flag = true;
            try{
                System.out.print("Numele proprietarului: \n");
                proprietar = inString();
                if(proprietar.length() == 0 || " ".equals(proprietar))
                    throw new CalculatorException(proprietar);//////////////////////////lenesa!!!
            }catch (CalculatorException e){
                flag = e.prelucrare();
            }
        }
        while(flag == false);
        
        // Citirea numarului de componente
        do{
            flag = true;
            try{
                System.out.print("Numarul de componente: \n");
                nrComponente = (byte) inInt();
                if(nrComponente <= 0)
                    throw new CalculatorException(nrComponente);
            }catch(CalculatorException e){
                try{
                    flag = e.prelucrare();
                }catch(NullPointerException a){
                    System.out.println("");
                    flag = false;
                }
            }
        }
        while(flag == false);
        
        // Initializarea variabilelor dinamice
        denumireC = new String[nrComponente][2];
        greutateC = new float[nrComponente];
        anulFabricariiC = new short[nrComponente];
        pretC = new double[nrComponente];
        
        // Citirea datelor despre componente
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.print("Introduceti datele despre componente.\n\n");
         for(int i = 0; i < nrComponente; i++){
            
            // Citirea producatorului
            do{
                flag = true;
                try{
                    System.out.print("Producatorul componentei " + (i+1) + "\n");
                    denumireC[i][0] = inString();
                    if(denumireC[i][0].length() == 0 || denumireC[i][0] == " ")
                        throw new CalculatorException(denumireC[i][0]);
                }catch(CalculatorException e){
                    flag = e.prelucrare();
                }
            }
            while(flag == false);
            
            // Citirea modelului
            do{
                flag = true;
                /* Prelucrarea exceptiei de citire a fisierului */
                try{
                    System.out.print("Modelul componentei " + (i+1) + "\n");
                    denumireC[i][1] = inString();
                    if(denumireC[i][1].length() == 0 || denumireC[i][1] == " ")
                        throw new CalculatorException(denumireC[i][1]);
                }catch(CalculatorException e){
                    flag = e.prelucrare();
                }
            }
            while(flag == false);
            
            // Citirea greutatii
            do{
                flag = true;
                try{
                    System.out.print("Greutatea componentei " + (i+1) + "\n");
                    greutateC[i] = (float) inDouble();
                    if(greutateC[i] <= 0)
                        throw new CalculatorException(greutateC[i]);
                }catch(CalculatorException e){
                try{
                    flag = e.prelucrare();
                }catch(NullPointerException a){
                    System.out.println("");
                    flag = false;
                }
            }
            }
            while(flag == false);
            
            // Citirea anului fabricarii componentei
            do{
                flag = true;
                try{
                    System.out.print("Anul fabricarii componentei " + (i+1) + "\n");
                    anulFabricariiC[i] = (short) inInt();
                    if(anulFabricariiC[i] <= 1960 || anulFabricariiC[i] > year)
                        throw new CalculatorException((double)anulFabricariiC[i]);
                }catch(CalculatorException e){
                    try{
                        flag = e.prelucrare();
                    }catch(NullPointerException a){
                        System.out.println("");
                        flag = false;
                    }
                }
            }
            while(flag == false);
            
            // Citirea pretului componentei
            do{
                flag = true;
                try{
                    System.out.print("Pretul componentei " + (i+1) + "\n");
                    pretC[i] = inDouble();
                    if(pretC[i] <= 0)
                        throw new CalculatorException(pretC[i]);
                }catch(CalculatorException e){
                    try{
                        flag = e.prelucrare();
                    }catch(NullPointerException a){
                        System.out.println("");
                        flag = false;
                    }
                }
            }
            while(flag == false);
            
        }
       // Citirea sistemului de operare
        do{
            flag = true;
            try{
                System.out.print("Sistemul de operare\n");
                os = inString();
                if(os.equalsIgnoreCase("Windows") == false && os.equalsIgnoreCase("Linux") == false)
                    throw new CalculatorException(os);
            }catch(CalculatorException e){
                flag = e.prelucrare();
            }
        }
        while(flag == false);
        objectCount++;
    }
    
    // Constructor cu doi parametri
    Calculator(String proprietar, byte componente){
        
        this.proprietar = proprietar;
        nrComponente = componente;
        
        // Initializarea variabilelor dinamice
        denumireC = new String[nrComponente][2];
        greutateC = new float[nrComponente];
        anulFabricariiC = new short[nrComponente];
        pretC = new double[nrComponente];
        int check;
        // Citirea datelor despre componente
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.print("Introduceti datele despre componente.\n\n");
         for(int i = 0; i < nrComponente; i++){
            
            // Citirea producatorului
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Producatorul componentei " + (i+1) + "\n");
                else
                    System.out.print("Denumirea producatorului nu poate fi nula. Introduceti o denumire valida pentru producator.\n");
                check = 1;
                try{
                    denumireC[i][0] = inString();
                }catch(CalculatorException e){
                    e.prelucrare();
                }
            }
            while(denumireC[i][0].length() == 0 || denumireC[i][0] == " ");
            
            // Citirea modelului
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Modelul componentei " + (i+1) + "\n");
                else
                    System.out.print("Modelul componentei nu poate fi nula. Introduceti o denumire valida pentru model.\n ");
                check = 1;
                try{
                    denumireC[i][1] = inString();
                }catch(CalculatorException e){
                    e.prelucrare();
                }
            }
            while(denumireC[i][1].length() == 0 || denumireC[i][1] == " ");
            
            // Citirea greutatii
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Greutatea componentei " + (i+1) + "\n");
                else
                    System.out.print("Greutatea componentei trebuie sa fie mai mare decat 0. Introduceti o greutate valida.\n");
                check = 1;
                try{
                    greutateC[i] = (float) inDouble();
                }catch(CalculatorException e){
                    e.prelucrare();
                }
            }
            while(greutateC[i] <= 0);
            
            // Citirea anului fabricarii componentei
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Anul fabricarii componentei " + (i+1) + "\n");
                else
                    System.out.print("Anul nu poate fi mai mic de 1960 sau mai mare decat anul curent. Introduceti un an valid.\n");
                check = 1;
                try{
                    anulFabricariiC[i] = (short) inInt();
                }catch(CalculatorException e){
                    e.prelucrare();
                }
            }
            while(anulFabricariiC[i] <= 1960 || anulFabricariiC[i] > year);
            
            // Citirea pretului componentei
            check = 0;
            do{
                if(check == 0)
                    System.out.print("Pretul componentei " + (i+1) + "\n");
                else
                    System.out.print("Pretul trebuie sa fie mai mare de 0.\n");
                check = 1;
                try{
                    pretC[i] = inDouble();
                }catch(CalculatorException e){
                    e.prelucrare();
                }
            }
            while(pretC[i] <= 0);
            
        }
         
       // Citirea sistemului de operare
        check = 0;
        do{
            if(check == 0)
                System.out.print("Sistemul de operare\n");
            else
                System.out.print("Denumirea sistemului de operare nu poate fi nula. Introduceti o denumire valida pentru sistemul de operare.\n ");
            check = 1;
            try{
                os = inString();
            }catch(CalculatorException e){
                e.prelucrare();
            }
        }
        while(os.length() == 0 || " ".equals(os));
        objectCount++;
    }
    
    // Constructor cu un parametru.
    Calculator(String proprietar){
        this.proprietar = proprietar;
        nrComponente = 2;
        
        denumireC = new String[2][2];
        greutateC = new float[2];
        anulFabricariiC = new short[2];
        pretC = new double[2];
        
        denumireC[0][0] = "Intel";
        denumireC[0][1] = "Core i3";
        denumireC[1][0] = "nVidia";
        denumireC[1][1] = "920G";
        
        greutateC[0] = (float) 150.5;
        greutateC[1] = (float) 720.9;
        
        anulFabricariiC[0] = (short) 2014;
        anulFabricariiC[1] = (short) 2015;
        
        pretC[0] = 520;
        pretC[1] = 954.50;
        
        os = "Windows 7 x64";
        objectCount++;
        
    }
    
    // Constructor de copiere
    Calculator(Calculator obiect){
    	obiect.proprietar = proprietar;
    	obiect.nrComponente = nrComponente;
    	obiect.os = os;
    	
    	// Alocarea memoriei
    	obiect.denumireC = new String[obiect.nrComponente][2];
    	obiect.greutateC = new float[obiect.nrComponente];
    	obiect.anulFabricariiC = new short[obiect.nrComponente];
    	obiect.pretC = new double[obiect.nrComponente];
    	
    	// Copierea valorilor variabilelor dinamice
    	for(int i = 0; i < nrComponente; i++){
    		obiect.denumireC[i][0] = denumireC[i][0];
    		obiect.denumireC[i][1] = denumireC[i][1];
    		obiect.greutateC[i] = greutateC[i];
    		obiect.anulFabricariiC[i] = anulFabricariiC[i];
    		obiect.pretC[i] = pretC[i];
    	}
    }
    
    // Constructor cu parametru cale spre fisier.
    Calculator(String cale, boolean fisier){
    	k = 0;
        String s;
    	try{
            s = Calculator.readFile(cale);
        }catch(CalculatorException e){
            e.prelucrare();
            s = "Eroare";
        }
    	proprietar = s;
    	
    	k++;
    	try{
            s = Calculator.readFile(cale);
        }
        catch(CalculatorException e){
            e.prelucrare();
        }
    	nrComponente = (Byte.valueOf(s)).byteValue();
    	
    	k++;
        try{
            s = Calculator.readFile(cale);
        }
        catch(CalculatorException e){
            e.prelucrare();
        }
    	
    	
    	// Initializarea campurilor 
    	denumireC = new String[nrComponente][2];
    	greutateC = new float[nrComponente];
    	anulFabricariiC = new short[nrComponente];
    	pretC = new double[nrComponente];
    	
    	denumireC[0][0] = s;
    	
    	k++;
        try{
            s = Calculator.readFile(cale);
        }
        catch(CalculatorException e){
            e.prelucrare();
        }
    	denumireC[0][1] = s;
    	
    	k++;
    	try{
            s = Calculator.readFile(cale);
        }
        catch(CalculatorException e){
            e.prelucrare();
        }
    	greutateC[0] = (Float.valueOf(s)).floatValue();
    	
    	k++;
    	try{
            s = Calculator.readFile(cale);
        }
        catch(CalculatorException e){
            e.prelucrare();
        }
    	anulFabricariiC[0] = (Short.valueOf(s)).shortValue();
    	
    	k++;
    	try{
            s = Calculator.readFile(cale);
        }
        catch(CalculatorException e){
            e.prelucrare();
        }
    	pretC[0] = (Double.valueOf(s)).doubleValue();
    	
    	k++;
    	try{
            s = Calculator.readFile(cale);
        }
        catch(CalculatorException e){
            e.prelucrare();
        }
    	os = s;   	
    	
    }
    
    // Constructor cu valori aleatoare
    Calculator(boolean a){
    	String[] nume = {"Nick", "John", "Sandu", "Pavel"};
    	String[] producator = {"Intel", "AMD", "Samsung", "nVidia"};
    	String[] model = {"Core i7", "Radeon HD 7800", "SG 518", "GTX520"};
    	proprietar = nume[(new Random ()).nextInt(nume.length)];
    	
        nrComponente = 2;
        
        denumireC = new String[2][2];
        greutateC = new float[2];
        anulFabricariiC = new short[2];
        pretC = new double[2];
        
        
        int denumire = new Random().nextInt(producator.length);
        denumireC[0][0] = producator[denumire];
        denumireC[0][1] = model[denumire];
        denumireC[1][0] = producator[denumire];
        denumireC[1][1] = model[denumire];
        
        greutateC[0] = new Random().nextFloat();
        greutateC[1] = new Random().nextFloat();
        
        anulFabricariiC[0] = (short) 2014;
        anulFabricariiC[1] = (short) 2015;
        
        pretC[0] = 520;
        pretC[1] = 954.50;
        
        os = "Windows 7 x64";
        objectCount++;
    }
    
    // Metoda de afisare
    void afisare(){
    	System.out.println("Proprietar: " + proprietar);
    	System.out.println("Numarul de componente: " + nrComponente);
    	int nullCounter = 0;
    	for(int i = 0; i < nrComponente; i++){
    		if(		denumireC[i][0] == " " &&
                	denumireC[i][1] == " " &&
                	greutateC[i] == 0 &&
                	anulFabricariiC[i] == 0 &&
                	pretC[i] == 0
    			)
    		nullCounter++;
    		else{
	    		System.out.println("\nProducatorul componentei " + i + ": " + denumireC[i][0]);
	    		System.out.println("Modelul componentei " + i + ": " + denumireC[i][1]);
	    		System.out.println("Greutatea componentei " + i + ": " + greutateC[i]);
	    		System.out.println("Anul fabricarii componentei " + i + ": " + anulFabricariiC[i]);
	    		System.out.println("Pretul componentei " + i + ": " + pretC[i]);
    		}
    	}
    	if(nullCounter == 1)
    		System.out.println("\n*Informare* In obiect a fost detectata o componenta cu valori nule. Aceasta componenta nu a fost afisata.");
    	else if(nullCounter != 0)
    		System.out.println("\n*Informare* In obiect au fost detectate " + nullCounter + " componente cu valori nule. Aceste componente nu au fost afisate.");
    	
    	
    	System.out.println("\nSistemul de operare: " + os);    	
    }
    
    // Metoda ce returneaza greutatea totala a calculatorului.
    float greutatea(){
    	float greutate = 0;
    	for(int i = 0; i < nrComponente; i++)
    		greutate += greutateC[i];
		return greutate;
    }
    
    // Metoda ce returneaza pretul total al calculatorului.
    double pretul(){
    	double pret = 0;
    	for(int i = 0; i < nrComponente; i++)
    		pret += pretC[i];
    	return pret;
    }
    
    // Metoda ce returneaza vechimea medie calculatorului.
    float vechime(){
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	float vechime = 0;
    	int internCount = 0;
    	for(int i = 0; i < nrComponente; i++)
    		if(anulFabricariiC[i] != 0){
    			vechime += (year - anulFabricariiC[i]);
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
    
    // Metoda de setare a numarului de componente
    void setNrComponente(byte nrComponente){
        if(nrComponente > 0 && this.nrComponente != nrComponente){
            if(nrComponente < this.nrComponente){
                // Afisare alerta daca e posibila pierderea de date.
            	if(this.nrComponente - nrComponente == 1)
            		System.out.println("*Informare* Numarul de componente introdus este mai mic decat numarul existent. Va fi pierduta o inregistrare. Pentru anulare - introduceti 0, pentru confirmare - introduceti orice alt caracter.");
            	else
            		System.out.println("*Informare* Numarul de componente introdus este mai mic decat numarul existent. Vor fi pierdute " + (this.nrComponente - nrComponente) + " inregistrari. Pentru anulare - introduceti 0, pentru confirmare - introduceti orice alt caracter.");
                
                String answer;
                try{
                    answer = inString();
                }
                catch(CalculatorException e){
                    e.prelucrare();
                    answer = "0";
                }
                if(answer != "0"){
                    String[][] tDenumireC = new String[this.nrComponente][2];
                    float[] tGreutateC = new float[this.nrComponente];
                    short[] tAnulFabricariiC = new short[this.nrComponente];
                    double[] tpretC = new double[this.nrComponente];
                    
                    for(int i = 0; i < nrComponente; i++){
                        tDenumireC[i][0] = denumireC[i][0];
                        tDenumireC[i][1] = denumireC[i][1];
                        tGreutateC[i] = greutateC[i];
                        tAnulFabricariiC[i] = anulFabricariiC[i];
                        tpretC[i] = pretC[i];
                    }

                    denumireC = new String[nrComponente][2];
                    greutateC = new float[nrComponente];
                    anulFabricariiC = new short[nrComponente];
                    pretC = new double[nrComponente];
                    
                    // Copierea doar a componentelor precedente
                    for(int i = 0; i < nrComponente; i++){
                    	denumireC[i][0] = tDenumireC[i][0];
                    	denumireC[i][1] = tDenumireC[i][1];
                    	greutateC[i] = tGreutateC[i];
                    	anulFabricariiC[i] = tAnulFabricariiC[i];
                    	pretC[i] = tpretC[i];
                    }
                    this.nrComponente = nrComponente;
                    System.out.println("*Succes* Numarul de componente a fost modificat. Numarul curent: " + nrComponente);
                }
            }
            
            if(nrComponente > this.nrComponente){
            	String[][] tDenumireC = new String[this.nrComponente][2];
                float[] tGreutateC = new float[this.nrComponente];
                short[] tAnulFabricariiC = new short[this.nrComponente];
                double[] tpretC = new double[this.nrComponente];
                
                for(int i = 0; i < this.nrComponente; i++){
                    tDenumireC[i][0] = denumireC[i][0];
                    tDenumireC[i][1] = denumireC[i][1];
                    tGreutateC[i] = greutateC[i];
                    tAnulFabricariiC[i] = anulFabricariiC[i];
                    tpretC[i] = pretC[i];
                }

                denumireC = new String[nrComponente][2];
                greutateC = new float[nrComponente];
                anulFabricariiC = new short[nrComponente];
                pretC = new double[nrComponente];
                
                // Copierea doar a componentelor precedente
                for(int i = 0; i < this.nrComponente; i++){
                	denumireC[i][0] = tDenumireC[i][0];
                	denumireC[i][1] = tDenumireC[i][1];
                	greutateC[i] = tGreutateC[i];
                	anulFabricariiC[i] = tAnulFabricariiC[i];
                	pretC[i] = tpretC[i];
                }
                
                // Completarea restului campurilor cu valori nule
                for(int i = this.nrComponente; i < nrComponente; i++){
                	denumireC[i][0] = " ";
                	denumireC[i][1] = " ";
                	greutateC[i] = 0;
                	anulFabricariiC[i] = 0;
                	pretC[i] = 0;
                }
                this.nrComponente = nrComponente;
                System.out.println("*Succes* Numarul de componente a fost modificat. Numarul curent: " + nrComponente);
            }   
        }
        else
        	System.out.println("*Eroare* Numarul componentelor nu a fost modificat deoarece a fost introdusa o valoare neadmisibila sau numarul de componente nou coincide cu cel vechi.");
    }
    
    // Metoda de setare a denumirii n
    void setDenumire(int index, String producator, String model){
    	if(index >= 0 && index < nrComponente && (denumireC[index][0] != producator || denumireC[index][1] != model) && producator.length() != 0 && model.length() != 0){
	    	System.out.println("*Succes* Producatorul a fost modificat.\nProducatorul vechi: " + denumireC[index][0]);
	    	denumireC[index][0] = producator;
	    	System.out.println("Producatorul nou: " + denumireC[index][0]);
	    	System.out.println("*Succes* Modelul a fost modificat.\nModelul vechi: " + denumireC[index][1]);
	    	denumireC[index][1] = model;
	    	System.out.println("Modelul nou: " + denumireC[index][1]);
    	}
    	else
    		System.out.println("*Eroare* Datele despre denumire nu au fost modificate deoarece a fost introdus un index incorect, nu ati introdus nimic sau datele introduse sunt identice cu cele vechi.");
    	
    }
    
    // Metoda de setare a greutatii
    void setGreutate(int index, float greutateNoua){
    	if(greutateNoua > 0 && index >=0 && index < nrComponente && greutateNoua != greutateC[index]){
    		System.out.println("*Succes* Greutatea a fost modificata. \nGreutatea veche: " + greutateC[index]);
    		greutateC[index] = greutateNoua;
    		System.out.println("Greutatea noua: " + greutateC[index]);
    	}
    	else
    		System.out.println("*Eroare* Greutatea nu a fost modificata deoarece a fost indicat un index inacceptabil sau informatia introdusa coincide cu cea veche.");
    }
    
    // Metoda de setare a anului fabricarii
    void setAnulFabricarii(int index, short an){
    	if(an > 1960 && an < 2017 && index >= 0 && index < nrComponente && anulFabricariiC[index] != an){
    		System.out.println("*Succes* Anul fabricarii componentei a fost modificat. \nAnul vechi: " + anulFabricariiC[index]);
    		anulFabricariiC[index] = an;
    		System.out.println("Anul nou: " + anulFabricariiC[index]);
    	}
    	else
    		System.out.println("*Eroare* Anul nu a fost modificat deoarece a fost indicat un index inacceptabil, an inacceptabil sau informatia introdusa coincide cu cea veche.");
    }
    
    // Metoda de setare a pretului
    void setPret(int index, double pret){
    	if(index >= 0 && index < nrComponente && pret > 0 && pret != pretC[index]){
    		System.out.println("*Succes* Pretul componentei a fost modificat. \nPretul vechi: " + pretC[index]);
    		pretC[index] = pret;
    		System.out.println("Pretul nou: " + pretC[index]);
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
    
    // Metoda de extragere a numarului de componente
    byte getNrComponente(){
    	return nrComponente;
    }
    
    // Metoda de extragere a producatorului
    String getProducator(int index){
    	if(index >= 0 && index < nrComponente)
    		return denumireC[index][0];
    	else{
    		System.out.println("Ati introdus un index incorect (getProducator)");
    		return "Eroare";
    	}
    }
    
    // Metoda de extragere a modelului
    String getModel(int index){
    	if(index >= 0 && index < nrComponente)
    		return denumireC[index][1];
    	else{
    		System.out.println("Ati introdus un index incorect (getModel)");
    		return "Eroare";
    	}
    }
    
    // Metoda de extragere a greutatii
    float getGreutateC(int index){
    	if(index >= 0 && index < nrComponente)
    		return greutateC[index];
    	else{
    		System.out.println("Ati introdus un index incorect (getGreutateC)");
    		return 0;
    	}
    }
    
    // Metoda de extragere a anului fabricarii
    short getAnulFabricariiC(int index){
    	if(index >= 0 && index < nrComponente)
    		return anulFabricariiC[index];
    	else{
    		System.out.println("Ati introdus un index incorect (getAnulFabricariiC)");
    		return 0;
    	}
    }
    
    // Metoda de extragere a anului fabricarii
    double getPret(int index){
    	if(index >= 0 && index < nrComponente)
    		return pretC[index];
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