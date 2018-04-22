package Blocks;


import java.util.HashMap;

public  class RegisterFile {
    public static HashMap<String, Integer> Register= new HashMap<String, Integer>();




    public static void printFile() { System.out.println(Register); }

    public  void setRegister(String name, int value) {
        if (name == "$0") {
            System.out.println("Register zero can't be overwritten.");

        }
        else{
            Register.put(name,value);//take the specified register and its value and adds it to the register file
        }
    }

    public  int getValue(String address){
        return Register.get(address);
    }


}
