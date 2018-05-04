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
        System.out.println("Enter 1 if your program contains function and 0 otherwise.");
        this.isFunction=sc.nextInt();
        if(isFunction==1){
            System.out.println("please enter the total number of instructions inside your functions");
            this.numberOfInstructions=sc.nextInt();
            address=firstAddress;
            System.out.println("Instructions: ");
            for(int i=0;i<numberOfInstructions;i++){
                this.ins=sc.next();
                iMem.addInstruction(ins,address); // instructions HashMap representing the actual instruction memory
                I_Mem.functions.add(this.ins); //functions ArrayList; without addresses, while the index is the
                //PC but not in a byte manner
                address+=4;



            }
        }

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


        //Register file initialization
        RegisterFile.Register.put("$0",0);
        RegisterFile.Register.put("$at",null);
        RegisterFile.Register.put("$v0",null);
        RegisterFile.Register.put("$v1",null);
        RegisterFile.Register.put("$a0",null);
        RegisterFile.Register.put("$a1",null);
        RegisterFile.Register.put("$a2",null);
        RegisterFile.Register.put("$a3",null);
        RegisterFile.Register.put("$t0",null);
        RegisterFile.Register.put("$t1",null);
        RegisterFile.Register.put("$t2",null);
        RegisterFile.Register.put("$t3",null);
        RegisterFile.Register.put("$t4",null);
        RegisterFile.Register.put("$t5",null);
        RegisterFile.Register.put("$t6",null);
        RegisterFile.Register.put("$t7",null);
        RegisterFile.Register.put("$t8",null);
        RegisterFile.Register.put("$t9",null);
        RegisterFile.Register.put("$s0",1);
        RegisterFile.Register.put("$s1",null);
        RegisterFile.Register.put("$s2",null);
        RegisterFile.Register.put("$s3",null);
        RegisterFile.Register.put("$s4",null);
        RegisterFile.Register.put("$s5",null);
        RegisterFile.Register.put("$s6",null);
        RegisterFile.Register.put("$s7",null);
        Execution e=new Execution();



    }


}
