package Stages;
import Blocks.*;

import java.util.Map;

public class Execution {
    private String instruction;
    public Execution(int address,int numberOfInstructions) {
        //load instruction from the memory
            I_Mem imem=new I_Mem();
            //Loop the instruction memory hash map and get instructions one by one
            for (Map.Entry m:imem.instruction.entrySet()){
                this.instruction=(String)m.getValue();
            }
    }
}
