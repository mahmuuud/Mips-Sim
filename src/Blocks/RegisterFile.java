package Blocks;


import java.util.LinkedHashMap;

public  class RegisterFile {
    public static LinkedHashMap<String, Integer> Register= new LinkedHashMap<String, Integer>();




    public static void printFile() { System.out.println(Register); }

    public  void setRegister(String name, int value) {
        if (name.equals("$0")) {
            System.err.println("Register zero can't be overwritten.");

        }
        else{
            Register.put(name,value);//take the specified register and its value and adds it to the register file
        }
    }

    public  int getValue(String address){
        return Register.get(address);
    }


}
