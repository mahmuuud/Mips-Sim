
package Blocks;

public class ALU {
    private boolean isOn;
    private String aluControl;
    private boolean zeroFlag;
    private float result;
    private RegisterFile registerFile=new RegisterFile();
    private String [] Offset;
    private String [] BinArr;
    private int count=31;



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

    public int nor (int rs ,int rt) {
        String b1 = Integer.toBinaryString(rs);
        String b2 = Integer.toBinaryString(rt);
        int B1 = Integer.parseInt(b1);
        int B2 = Integer.parseInt(b2);

        long binary1, binary2;
        int i = 0, remainder = 0;
        int[] sum = new int[20];
        String ParsedBin = "";

        binary1 = B1;
        binary2 = B2;

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (int) ((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int) ((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        while (i >= 0) {
            System.out.print(sum[i--]);
        }
        for (int j = 0; j < sum.length; j++) {
            if (sum[j] == 0)
                sum[j] = 1;
            else {
                sum[j] = 0;
            }
        }
        for (int q=0 ; q<sum.length ;q++){
            ParsedBin+=sum[q];
        }
        int Result = Integer.parseInt(ParsedBin);
        return Result;
    }

    public int signExtend(short n){
        short res=n;
        return res;
    }
    }



}