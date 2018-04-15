package Stages;
import Blocks.*;
import java.util.Scanner;

public class ReadInstruction {
    private String ins;
    private int numberOfInstructions;
    private int numberOfMemLocations;
    private int firstAddress;
    private int address;
    private String memAddress;
    private int memValue;
    String regName;
    int regNums;
    int regInitialValues;
    private I_Mem iMem;
    private RegisterFile reg;
    private Data_Mem mem;

    Scanner sc = new Scanner(System.in);

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
            memAddress=sc.next();
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
        System.out.println("What is the number of registers used by your program");
        regNums=sc.nextInt();
        for(int i=0;i<regNums;i++){
            System.out.println("enter the name for Register number "+(i+1));
            regName=sc.next();
            System.out.println("enter the initial value of register number "+(i+1));
            regInitialValues=sc.nextInt();
            reg.setRegister(regName,regInitialValues);
        }
       
    }


}
