import java.util.Random;

public class CuPasageri extends Avion implements IAterizare{
	float               stare;
	int                 nrPasageri;
	float               greutateBagaje;
	private static int  nrObiecte = 0;
	
	/* Primirea numarului de obiecte */
	static int getObjectsNumber(){
		return CuPasageri.nrObiecte;
	}
	
	/* Getters */
	public final float getStare() {
		return stare;
	}

	public final int getNrPasageri() {
		return nrPasageri;
	}

	public final float getGreutateBagaje() {
		return greutateBagaje;
	}

	/* Setters */
	public final void setStare(float stare) {
		if(stare > 0 && stare < 1)
			this.stare = stare;
		else
			System.out.println("Starea in procente nu poate fi negativa sau nula. Datele nu au fost modificate.");
	}
	
	public final void setNrPasageri(int nrPasageri) {
		if(nrPasageri >= 0)
			this.nrPasageri = nrPasageri;
		else
			System.out.println("Numarul de pasageri nu poate fi negativ. Datele nu au fost modificate.");
	}
	
	public final void setGreutateBagaje(float greutateBagaje) {
		if(greutateBagaje > 0)
			this.greutateBagaje = greutateBagaje;
		else
			System.out.println("Greutatea bagajelor nu poate fi negativa sau nul. Datele nu au fost modificate.");
	}
	
	/* Constructori */
		/* Constructor implicit */
	public CuPasageri() {
		super();
		boolean isFirst = true;
		
		// Introducerea starii
		System.out.println("Introduceti stare: ");
		do{
			if(isFirst == false)
				System.out.println("** Eroare ** \nStarea in procente nu poate fi negativa sau nula. Introduceti o valoare valida.");
			stare = inFloat();
			isFirst = false;
		}
		while(stare <= 0 || stare > 1);
		
		// Introducerea numarului de pasageri
		System.out.println("Introduceti numarul de pase: ");
		isFirst = true;
		do{
			if(isFirst == false)
				System.out.println("** Eroare ** \nNumarul de pasageri nu poate fi negativ. Introduceti o valoare valida.");
			nrPasageri = inInt();
			isFirst = false;
		}
		while(nrPasageri < 0);
		
		// Introducerea greutateBagajeului
		System.out.println("Introduceti Greutatea Bagajelor: ");
		isFirst = true;
		do{
			if(isFirst == false)
				System.out.println("** Eroare ** \nGreutatea bagajelor nu poate fi negativa. Introduceti o valoare valida.");
			greutateBagaje = inFloat();
			isFirst = false;
		}
		while(greutateBagaje < 0);
		CuPasageri.nrObiecte++;
	}
		
		/* Constructor cu toti parametrii */
        public CuPasageri(String denumire, int viteza, int greutate, 
                    float stare, int nrPasageri, float greutateBagaje) {
		super(denumire, viteza, greutate);
		this.stare = stare;
		this.nrPasageri = nrPasageri;
		this.greutateBagaje = greutateBagaje;
		CuPasageri.nrObiecte++;
	}
	
		/* Constructor cu valori aleatoare */
	public CuPasageri(boolean unused){
		super(unused);
		this.stare = (new Random().nextFloat()) + (new Random().nextInt(1));
		this.greutate += (stare * 10) * 100;
		this.nrPasageri = new Random().nextInt(1000);
		this.greutateBagaje = this.nrPasageri/ 2;
	}
	
	
	void afisare(){
		super.afisare();
		System.out.println("Starea(0-1): " + stare + "\nNr. Pasageri: "
				 + nrPasageri + "\nGreutate Bagaje: " + greutateBagaje);
	}
	
	public void antrenament(){
		stare -= 0.5;
		viteza += 1;
                System.out.println("-------------Antrenament-------------\n");
	}
	
	public void aterizare(int kg){
		nrPasageri = 0;
                greutate -= kg;
                System.out.println("-------------Pasagerii au iesit-------------\nNr pasageri acum = "+nrPasageri);
                System.out.println("-------------------------------------------------");
	}

}
