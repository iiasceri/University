
public class Main {

	public static void main(String[] args) {
		ArrayThread.printArray();
		for(int i = 0; i < ArrayThread.row; i++)
			(new ArrayThread(i)).start();
		
		try{
			Thread.sleep(2000);
			System.out.println("Astept 2 secunde.");
		} catch(InterruptedException e){}
		
		System.out.println("Suma elementelor negative maxime este: " + ArrayThread.sum);
	}
}
