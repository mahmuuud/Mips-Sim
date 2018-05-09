package Stages;
import Blocks.*;
import java.util.Scanner;

public class ReadInstruction {
    private String ins;
    private int numberOfInstructions;
    private int numberOfMemLocations;
    private int firstAddress;
    private static int address;
    private int memAddress;
    private int memValue;
    private int isFunction;
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
        reg=new RegisterFile();
        System.out.println("enter the starting address of your program in memory");
        address=sc.nextInt();
//        System.out.println("Enter 1 if your program contains function and 0 otherwise.");
//        this.isFunction=sc.nextInt();
//        if(isFunction==1){
//            System.out.println("please enter the total number of instructions inside your functions");
//            this.numberOfInstructions=sc.nextInt();
//            address=firstAddress;
//            System.out.println("Instructions: ");
//            for(int i=0;i<numberOfInstructions;i++){
//                this.ins=sc.next();
//                iMem.addInstruction(ins,address); // instructions HashMap representing the actual instruction memory
//                I_Mem.functions.add(this.ins); //functions ArrayList; without addresses, while the index is the
//                //PC but not in a byte manner
//                address+=4;


//
//            }
//        }

        System.out.println("please enter the number of instructions");
        this.numberOfInstructions=sc.nextInt();
        System.out.println("Instructions: ");
        for(int i=0;i<numberOfInstructions;i++){
            this.ins=sc.next();
            iMem.addInstruction(ins,address); // instructions HashMap representing the actual instruction memory
            I_Mem.instructions.add(this.ins); //instructions ArrayList; without addresses, while the index is the
            //PC but not in a byte manner
            address+=4;



        }




        Execute e=new Execute();
        e.Execute(I_Mem.instructions,0);
        e.endExecution();



    }


}
