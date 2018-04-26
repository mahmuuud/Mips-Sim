package GUI7;

import Blocks.I_Mem;


public class FunctionCall extends GUI {
    public FunctionCall(){
        this.setTitle("Function Instructions");
    }
    @Override
    public void saveInstructions(){
        memoryAddress.setText(""+I_Mem.functions.size()*4);
        Address=Integer.parseInt(memoryAddress.getText());
        for (int i = 0; i < a.size(); i++) {
            I_Mem.functions.add(a.get(i));
            I_Mem.addInstruction(a.get(i),Address);
            Address+=4;

        }

        MainProgram m=new MainProgram();
        m.setVisible(true);
        close();

    }
    public void close(){
        this.dispose();
    }

}

