import java.util.Random;

public class HumanRow extends Thread{
    String name;
    int age;
    int index;
    boolean gender; // 0 for fem, 1 for man
    
    public HumanRow() {
        name = "-";
        age = -1;
        gender = false;
    }
    
    
    public HumanRow(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    
    public static void printMatrix(){
            for(int i = 0; i < Main.row; i++){
                    for(int j = 0; j < Main.col; j++){
                        System.out.format("Name is: %-6s\n", Main.Matrix[i][j].name);
                        System.out.format("Age is: %d\n", Main.Matrix[i][j].age);
                        if (Main.Matrix[i][j].gender)
                            System.out.format("Male\n--\n");
                        else
                            System.out.format("Female\n--\n");
                    }
                    System.out.println();
            }		
            System.out.println();
    }
    
    public HumanRow(int index){
            this.index = index;
    }
    
    public void run(){
            System.out.println("Procesul pentru randul " + index + " a inceput lucrul.");
            int start = 0;
            Main.max_name = "-";
            for(int i = 0; i < Main.col; i++){
                    if(Main.Matrix[index][i].name.length() >= Main.Matrix[index][i + 1].name.length() && i + 1 != Main.col)
                            if (gender == false){
                            System.out.println("Current max name is: " + Main.max_name + " Gender is: " + Main.Matrix[index][i].gender);
                                if (Main.Matrix[index][i].name.length() >= Main.max_name.length()){
                                    Main.max_name = Main.Matrix[index][i].name;
                                    System.out.println("Current max name is: " + Main.max_name + " Gender is: " + Main.Matrix[index][i].gender);
                                    start = i;
                                    break;
                                }
                            }
            }
            //for(int i = start + 1; i < col; i++)

            System.out.println("Procesul pentru randul " + index + " a finisat lucrul. Numele cel mai mare este: " + Main.max_name);
    }
}