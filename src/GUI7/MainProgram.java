package GUI7;
import Blocks.*;
import Stages.*;
public class MainProgram extends GUI {
    public MainProgram(){
        this.setTitle("Main Program");
    }
    @Override
    public void saveInstructions(){
        Address=Integer.parseInt(memoryAddress.getText());
        for (int i = 0; i < a.size(); i++) {
            I_Mem.instructions.add(a.get(i));
            I_Mem.addInstruction(a.get(i),Address);
            Address+=4;

        }


        RegisterFile.Register.put("$0",0);
        for(int i=1;i<32;i++) //initialize all registers except "$0" with initial values null
            RegisterFile.Register.put("$"+i,null);
        RegisterFile.Register.put("$1",3);
        RegisterFile.Register.put("$2",1000);
        RegisterFile.Register.put("$3",3);
        Execution execution=new Execution();
        OutputScreen o=new OutputScreen();
        o.setVisible(true);
        close();
    }

    public void close(){this.dispose();}
}
