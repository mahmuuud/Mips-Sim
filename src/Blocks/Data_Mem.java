package Blocks;

import java.util.HashMap;

public class Data_Mem {
    private HashMap<String,Integer> memLocations;

    public Data_Mem(){
        memLocations=new HashMap<String, Integer>();
    }

    public void addLocation(String address,int value){
        memLocations.put(address,value);
    }

    public int getValue(String address){
        return memLocations.get(address);
    }
}
