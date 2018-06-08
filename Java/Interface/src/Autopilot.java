import java.util.Random;

public final class Autopilot extends FaraPasageri {
	int                 range;
	float               reactia;
	private static int  nrObiecte = 0;
	final float         reactiaMin = 0.2f;
	final float         reactiaMax = 0.3f;
	
	
	/* Primirea numarului de obiecte */
	static int getObjectsNumber(){
		return Autopilot.nrObiecte;
	}
	
	/* Getters */	
	public final int getRange() {
		return range;
	}

	public final float getReactia() {
		return reactia;
	}
	
	/* Setters */
	public final void setRange(int range) {
		if(range >= 0)
			this.range = range;
		else
			System.out.println("Distanta de lucru nu poate fi negativa. Datele nu au fost modificate.");
	}

	public final void setReactia(float reactia) {
		if(reactia > 0)
			this.reactia = reactia;
		else
			System.out.println("Reactia nu poate fi negativa sau nula. Datele nu au fost modificate.");
	}

	/* Constructori */
		/* Constructor implicit */
	public Autopilot() {
		super();
		boolean isFirst = true;
		
		// Introducerea numarului de save-uri
		System.out.println("Introduceti distanta de operare: ");
		do{
			if(isFirst == false)
				System.out.println("** Eroare ** \nDistanta de operare nu poate fi negativa. Introduceti o valoare valida.");
			range = inInt();
			isFirst = false;
		}
		while(range < 0);
		
		// Introducerea coeficientului reactiei
		System.out.println("Introduceti coeficientul reactiei: ");
		isFirst = true;
		do{
			if(isFirst == false)
				System.out.println("** Eroare ** \nCoeficientul reactiei nu poate fi negativ sau mai mare ca (0.5). Introduceti o valoare valida.");
			reactia = inFloat();
			isFirst = false;
		}
		while(reactia < 0 || reactia > 0.5f);
		Autopilot.nrObiecte++;
	}
	
		/* Constructor cu toti parametrii */
	public Autopilot(String denumire, int viteza, int greutate, 
			float vizibilitate, int nrPiloti, float pret, int range,
			float reactia) {
		super(denumire, viteza, greutate, vizibilitate, nrPiloti, pret);
		this.range = range;
		this.reactia = reactia;
		Autopilot.nrObiecte++;
	}
	
		/* Constructor cu valori aleatoare */
	public Autopilot(boolean unused){
		super(unused);
		this.range = new Random().nextInt(this.viteza);
		this.reactia = 0.3f + (new Random().nextFloat()) / 10;
	}
	
	void afisare(){
		super.afisare();
		System.out.println("Distanta de operare: " + range
				+ "\nReactia:" + reactia);
		
	}
	
	public void antrenament(){
		super.antrenament();
		reactia += 0.01f;
                System.out.println("-------------Antrenament-------------\n");
	}
	
	public void aterizare(int kg){
		if(this.greutate > 50)
			this.greutate -= kg;
                System.out.println("-------------Aterizare-------------\n");
    
	}

}
