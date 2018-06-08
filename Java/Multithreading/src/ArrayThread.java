import java.util.Random;

public class ArrayThread extends Thread{
	static short Matrix[][];
	static int row, col, randomSpreating;
	int index;
	int max;
	static int sum = 0;
	
	static{
		short sign[] = {-1, 1};
		row = 100;
		col = 100;
		randomSpreating = 30;
		Matrix = new short[row][col];
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				Matrix[i][j] = (short) ((new Random()).nextInt(randomSpreating) * sign[(new Random()).nextInt(2)]);
		
	}
	
	public static void printArray(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(Matrix[i][j] >= 0)
					System.out.format(" %-5s", Matrix[i][j]);
				else
					System.out.format("%-6s", Matrix[i][j]);
			}
			System.out.println();
		}		
		System.out.println();
	}
	
	public ArrayThread(int index){
		this.index = index;
	}
	
	public void run(){
		System.out.println("Procesul pentru randul " + index + " a inceput lucrul.");
		int start = 0;
		max = Matrix[index][0];
		
		for(int i = 0; i < col; i++)
			if(Matrix[index][i] < 0){
				max = Matrix[index][i];
				start = i;
				break;
			}
		
		for(int i = start + 1; i < col; i++)
			if(Matrix[index][i] < 0 && Matrix[index][i] > max)
				max = Matrix[index][i];
		
		sum += max;
		
		System.out.println("Procesul pentru randul " + index + " a finisat lucrul. Elementul maxim negativ este: " + max);
	}
}
