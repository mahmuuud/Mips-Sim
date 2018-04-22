
package Blocks;

public class ALU {
    private boolean isOn;
    private String aluControl;
    private boolean zeroFlag;
    private float result;
    private RegisterFile registerFile=new RegisterFile();



    public String SetControl(String aluControl)
    { return this.aluControl=aluControl;}

    public String getControl(){return this.aluControl;}

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }


    public void setZeroFlag(boolean zeroFlag) {
        if(this.result==0)
            this.zeroFlag=true;
        else this.zeroFlag=false;
    }

    public boolean isZeroFlag() {
        return zeroFlag;
    }

    /*  public int getAluControl() {
          return aluControl;
      }

      public void setAluControl(int aluControl) {
          this.aluControl = aluControl;
      }*/

    public int add(int rs,int rt){

        int result=rs+rt;
        return result;
    }

    public int addi(int rs,int immediate){
        return rs+immediate;
    }

    public int signExtend(short n){
        int result=n;
        return result;
    }





}