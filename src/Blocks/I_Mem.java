package Blocks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.StringTokenizer.*;
public class I_Mem {
    public static HashMap<Integer,String> instruction=new HashMap<Integer, String>();
    public static ArrayList<String> instructions=new ArrayList<>(); //only to get a second storage of the instructions
    public static void  addInstruction(String ins,int address){

            instruction.put(address,ins);



    }
    //get the desired instruction only from the memory
    public static String getInstruction(int address){
        return instruction.get(address);
    }
}
