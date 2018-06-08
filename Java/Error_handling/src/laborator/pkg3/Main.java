/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator.pkg3;

public class Main {
    public static void main(String args[]){
        Calculator intel = new Calculator("Nick");
        Calculator amd = new Calculator("Sandu");
        Calculator a4 = new Calculator("Ion");
        intel.setProprietar("Meyer");
        intel.setProprietar("Meyer");
        intel.setNrComponente((byte)5);
        intel.setDenumire(0, "Intel", "");
        intel.setDenumire(0, "AMD", "A4");
        intel.setGreutate(1, (float) 5.1);
        intel.setAnulFabricarii(0, (short)2014);
        intel.setAnulFabricarii(0, (short)2015);
        intel.setPret(0, (double)5.15);
        intel.setPret(0, (double)5.15);
        intel.setOS("Linux Mint");
        intel.setOS("Linux Mint");
        intel.setOS("");
        intel.getPret(5);
        intel.afisare();
        System.out.println("\nGreutatea calculatorului este: " + intel.greutatea());
        System.out.println("\nPretul calculatorului este: " + intel.pretul());
        System.out.println("\nVechimea medie a calculatorului este: " + intel.vechime());
        
        Calculator.comparareCalculatoare(amd, intel);
        
        // Crearea retelei de calculatoare
		Calculator[] retea;
		int nrCalc = 3;
		retea = new Calculator[nrCalc];
		
		// Ititializarea vectorului
		
		retea[0] = new Calculator("Nick");
		
		// Citirea datelor de la tastatura in ciclu
		for(int i = 1; i < nrCalc; i++)
			try{
                            retea[i] = new Calculator();
                        }catch(CalculatorException e){
                            e.prelucrare();
                        }
		
		// Afisarea datelor */
		for(int i = 0; i < nrCalc; i++)
			retea[i].afisare();
		
		// Compararea a doua perechi de calculatoare dupa greutate
		Calculator.comparareCalculatoare(retea[0], retea[2]);
		Calculator.comparareCalculatoare(retea[1], retea[2]);
		
		// Compararea a doua perechi de calculatoare dupa vechime
		retea[0].comparareVechime(retea[1]);
		retea[1].comparareVechime(retea[2]);
		
		// Gasirea celui mai scump calculator si afisarea propietarului acestuia
		double pret = 0;
		int winnerIndex = 0;
		for(int i = 0; i < nrCalc; i++){
			if(retea[i].pretul() > pret){
				pret = retea[i].pretul();
				winnerIndex = i;
			}
		}
		
		System.out.print("Proprietarul celui mai scump calculator este " + 
		retea[winnerIndex].getProprietar() + ". Pretul calculatorului este: " + 
				retea[winnerIndex].pretul());
		
		System.out.print("\nClasa Calculator are " + Calculator.objectCount + " obiecte.");
		
		// Crearea unui obiect in baza datelor din fisier
    	Calculator n = new Calculator("E:\\input.txt", true);
    	n.afisare();
    	
    	// Inscrierea in fisier a obiectului
    	// n.writeFile("E:\\output.txt");
    }
}
