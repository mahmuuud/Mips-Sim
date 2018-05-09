package Blocks;

import java.util.HashMap;

public class Data_Mem {
    public static HashMap<Integer,Integer> memLocations=new HashMap<Integer, Integer>();


    public static void addLocation(int address,int value){
        memLocations.put((address),value);
    }

    public static int getValue(int address){
        return memLocations.get(address);
    }

    public static void printMem(){
        System.out.println(memLocations);
    }
}
