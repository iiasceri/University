import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
            Avion[] avioane = new Avion[3];
            
		avioane[0] = new CuPasageri("GG32", 33, 400, 0.8f, 200, 130.4f);
                avioane[1] = new FaraPasageri();
                avioane[2] = new Autopilot("Drone-3000", 999, 120, 0.1f, 0, 10000, 3000,0.3f);
	
		avioane[0].afisare();
		avioane[0].antrenament();
                System.out.println("A fost schimbata starea ! mai sus");
		((FaraPasageri)avioane[2]).viraj();
		
		for(int i = 0; i < avioane.length; i++){
			avioane[i].afisare();
			if(avioane[i] instanceof CuPasageri)
				((CuPasageri)avioane[i]).aterizare(50);
		}
		
		/* Inscrierea in fisier */
		String fileName = "C:\\java.txt";
		
		
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            String text = "";
            for(int i = 0; i < avioane.length; i++){
                   text += avioane[i].getDenumire() + "\r\n\n"
                        + avioane[i].getViteza() + "\r\n\n"
                        + avioane[i].getGreutate() + "\r\n\n";
            }
            writer.write(text);
            writer.flush();
            writer.close();
        }
        catch(IOException ex){ 
            System.out.println(ex.getMessage());
        }
        
        //citirea din fisier
        File file = new File("C:\\Users\\nicui\\Desktop\\Projects\\lab2\\container.txt");
        String[] token;
        token = new String[3];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int i = 0;
            while ((st = br.readLine()) != null){
               token = st.split(" ");
               avioane[i].denumire = token[0];
               avioane[i].viteza = Integer.parseInt(token[1]);
               avioane[i].greutate = Integer.parseInt(token[2]);
               i++;
            }
        }
        catch (Exception e){
            System.out.println("Error reading from file");
        }
    }
}