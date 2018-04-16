package Stages;
import Blocks.*;

import java.util.Map;
import java.util.StringTokenizer;

public class Execution {
    private String instruction;
   //private StringTokenizer tokenizer;
    private int rs;
    private int rt;
    private String rd;
    private RegisterFile reg;
    private I_Mem imem;
    private ALU alu;
    private String[] tokens;
    private int immediate;
    private String Op;
    public Execution() {
        //load instruction from the memory
            imem=new I_Mem();
            reg=new RegisterFile();
            alu = new ALU();
            //Loop the instruction memory hash map and get instructions one by one
            for (Map.Entry m:imem.instruction.entrySet()) {
                this.instruction = (String) m.getValue();
                //tokenizer = new StringTokenizer(this.instruction, ",");
                //Op = tokenizer.nextToken();
                tokens=this.instruction.split(",");
                Op=tokens[0];
                if (Op.equals("add")) {
                    rs = reg.getValue(tokens[2]);
                    System.out.println(rs);
                    rt = reg.getValue(tokens[3]);
                    rd = tokens[1];
                    reg.setRegister(rd, alu.add(rs, rt));
                }

                else if (Op.equals("addi")) {
                    tokens = this.instruction.split(",");
                    rd = tokens[1];
                    rs = reg.getValue(tokens[2]);
                    immediate = Integer.parseInt(tokens[3]);
                    reg.setRegister(rd, alu.addi(rs, immediate));
                }

                else if(Op.equals("lw")){
                    //lw,$1,2($2)
                    rd=tokens[1];
                    String d=tokens[2]; //d=2($2)
                    String[]d1=d.split("()");
                    short offset=Short.parseShort(d1[0]); //offset=2 (as in our above eg)
                    int Soffset=alu.signExtend(offset); //sign extend the offset "has no meaning"
                    int address=reg.getValue(d1[2]+d1[3]); //get value of register $2 "d1[2]=$ , d1[3]=2"
                    address+=(4*Soffset);
                    reg.setRegister(rd,Data_Mem.getValue(address));

                }

                else if(Op.equals("sw")){
                    //sw,$1,2($2)
                    rs=reg.getValue(tokens[1]);
                    String d=tokens[2];
                    String[] d1=d.split("()");
                    short offset=Short.parseShort(d1[0]);
                    int Soffset=alu.signExtend(offset);
                    int address=reg.getValue(d1[2]+d1[3]);
                    address+=(4*Soffset);
                    Data_Mem.addLocation(address,rs);
                }

                else if(Op.equals("lb")){

                }

                else if(Op.equals("lbu")){

                }

                else if(Op.equals("sb")){

                }

                else if(Op.equals("sll")){
                    //sll,$1,$2,2
                    rd=tokens[1];
                    rs=reg.getValue(tokens[2]);
                    rs*=(2*Integer.parseInt(tokens[3]));
                    reg.setRegister(rd,rs);

                }

                else if(Op.equals("nor")){

                }

                else if(Op.equals("slt")){
                    //slt,$1,$2,$3
                    rd=tokens[1];
                    rs=reg.getValue(tokens[2]);
                    rt=reg.getValue(tokens[3]);
                    if(rs<rt)
                        reg.setRegister(rd,1);
                    else reg.setRegister(rd,0);
                }

                else if(Op.equals("slti")){
                    //slti,$1,$2,3
                    rd=tokens[1];
                    rs=reg.getValue(tokens[2]);
                    int immediate=Integer.parseInt(tokens[3]);
                    if(rs<immediate)
                        reg.setRegister(rd,1);
                    else
                        reg.setRegister(rd,0);
                }





            }



                RegisterFile.printFile(); //prints register file modified registers after the program
                System.out.println("==================================================================");
                Data_Mem.printMem(); //prints  modified memory locations after the program
            }
    }
