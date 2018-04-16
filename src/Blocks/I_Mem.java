package Blocks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.StringTokenizer.*;
public class I_Mem {
    public static HashMap<Integer,String> instruction=new HashMap<Integer, String>();
   // private StringTokenizer checker;
//    String[] supportedInstructions = {"add", "addi", "beq", "j", "lw", "sw", "lb", "sb", "lbu", "sll", "nor", "jal", "jr", "slt", "slti"};



//    public boolean checkInstruction(String instruction) {
//        this.checker = new StringTokenizer(instruction);
//        for (int i = 0; i < supportedInstructions.length; i++) {
//            if (checker.nextToken() == supportedInstructions[i]) {
//                return true;
//            }
//
//        }

//        return false;
//    }
    public static void  addInstruction(String ins,int address){

            instruction.put(address,ins);



    }
    //get the desired instruction only from the memory
    public static String getInstruction(int address){
        return instruction.get(address);
    }
}
