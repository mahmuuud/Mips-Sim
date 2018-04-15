package Blocks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.StringTokenizer.*;
public class I_Mem {
    public HashMap<Integer,String> instruction;
    private StringTokenizer checker;
//    String[] supportedInstructions = {"add", "addi", "beq", "j", "lw", "sw", "lb", "sb", "lbu", "sll", "nor", "jal", "jr", "slt", "slti"};

    public I_Mem() {

        instruction=new HashMap<Integer, String>();

    }

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
    public void addInstruction(String instruction,int address){

            this.instruction.put(address,instruction);



    }
    //get the desired instruction only from the memory
    public String getInstruction(int address){
        return this.instruction.get(address);
    }
}
