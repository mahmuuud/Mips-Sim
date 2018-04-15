package Blocks;


import java.util.HashMap;

public  class RegisterFile {
    private HashMap<String, Integer> Register;


    public RegisterFile() {
        Register = new HashMap<String, Integer>();

    }

    public void printFile() {
        System.out.println(this.Register);
    }

    public void setRegister(String name, int value) {
        if (name == "$0") {
            System.out.println("Register zero cant be overwritten");

        }
        else{
            this.Register.put(name,value);//take the specified register and its value and adds it to the register file
        }
    }

    public int getValue(String address){
        return this.Register.get(address);
    }
}
