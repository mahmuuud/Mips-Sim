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

    public static void initializeFile(){
        //Register file initialization; all registers are set to null except $0, $sp or further notice.
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
        RegisterFile.Register.put("$s0",1);
        RegisterFile.Register.put("$s1",null);
        RegisterFile.Register.put("$s2",null);
        RegisterFile.Register.put("$s3",null);
        RegisterFile.Register.put("$s4",null);
        RegisterFile.Register.put("$s5",null);
        RegisterFile.Register.put("$s6",null);
        RegisterFile.Register.put("$s7",null);
        RegisterFile.Register.put("$t8",null);
        RegisterFile.Register.put("$t9",null);
        RegisterFile.Register.put("$k0",null);
        RegisterFile.Register.put("$k1",null);
        RegisterFile.Register.put("$gp",null);
        RegisterFile.Register.put("$sp",1000); //the stack is 1000 memory places.
        RegisterFile.Register.put("$fp",null);
        RegisterFile.Register.put("$ra",null);
    }

}
