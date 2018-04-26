package Blocks;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class I_Mem {
    public static LinkedHashMap<Integer,String> instruction=new LinkedHashMap<Integer, String>();
    public static ArrayList<String> instructions=new ArrayList<>(); //only to get a second storage of the instructions
    public static ArrayList<String> functions=new ArrayList<>(); //ArrayList for the functions only
    public static void  addInstruction(String ins,int address){

            instruction.put(address,ins);



    }
    //get the desired instruction only from the memory
    public static String getInstruction(int address){
        return instruction.get(address);
    }
}
