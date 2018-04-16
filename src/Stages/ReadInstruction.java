package Stages;
import Blocks.*;
import java.util.Scanner;

public class ReadInstruction {
    private String ins;
    private int numberOfInstructions;
    private int numberOfMemLocations;
    private int firstAddress;
    private int address;
    private int memAddress;
    private int memValue;
    String regName;
    int regNums=0;
    int regInitialValues;
    private I_Mem iMem;
    private RegisterFile reg;
    private Data_Mem mem;

    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);

    public String getInstruction() {
        return this.ins;
    }
    public ReadInstruction(){
        iMem=new I_Mem();
        mem=new Data_Mem();
        reg=new RegisterFile();
        System.out.println("enter the number of used memory locations");
        numberOfMemLocations=sc.nextInt();
        for(int i=0;i<numberOfMemLocations;i++){
            System.out.println("enter the address of location number "+(i+1));
            memAddress=sc.nextInt();
            System.out.println("enter the value of address "+memAddress);
            memValue=sc.nextInt();
            mem.addLocation(memAddress,memValue);
        }
        System.out.println("please enter the number of instructions");
        this.numberOfInstructions=sc.nextInt();
        System.out.println("enter the starting address of your program in memory");
        firstAddress=sc.nextInt();
        address=firstAddress;
        for(int i=0;i<numberOfInstructions;i++){
            System.out.println("please enter instruction number "+(i+1));
            this.ins=sc.next();

                iMem.addInstruction(ins,address);
                address+=4;



        }
        for(int i=0;i<32;i++) //initialize all registers with initial values null
            RegisterFile.Register.put("$"+i,null);


        RegisterFile.Register.put("$1",1);
        RegisterFile.Register.put("$2",1000);
        RegisterFile.Register.put("$3",1);
        Execution e=new Execution();


    }


}
