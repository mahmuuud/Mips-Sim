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


        RegisterFile.initializeFile();
        Execute e=new Execute();
        e.Execute(I_Mem.instructions,0);
        OutputScreen o=new OutputScreen();
        o.setVisible(true);
        close();
    }

    public void close(){this.dispose();}
}
