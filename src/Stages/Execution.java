package Stages;
import Blocks.*;

import java.util.HashMap;
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
    private HashMap<Integer, String> labeledInstructions;
    private HashMap<Integer,String> labeledInstructions2;
    public static int clockCycles;

    public Execution() {
        //load instruction from the memory
        imem = new I_Mem();
        reg = new RegisterFile();
        alu = new ALU();
        labeledInstructions = new HashMap<>();
        labeledInstructions2=new HashMap<>();

        //collect the labels and their corresponding index
        for (int i = 0; i < I_Mem.instructions.size(); i++) {
            this.instruction = I_Mem.instructions.get(i);
            if (instruction.indexOf(':') == -1)
                continue;
            else {
                String[] tokens1;
                tokens1 = this.instruction.split(":");
                //collect the indices and their corresponding labels of the labeled instructions only
                labeledInstructions.put(i, tokens1[0]); //the index is the key and the label is the value
            }
        }

        for (int i = 0; i < I_Mem.instructions.size(); i++) {
            ++clockCycles;
            this.instruction = I_Mem.instructions.get(i);
            //check if there is no label in the instruction
            if (instruction.indexOf(':') == -1) {
                tokens = this.instruction.split(",");
                Op = tokens[0];
            } else {
                String[] tokens1;
                tokens1 = this.instruction.split(":");
                this.tokens = tokens1[1].split(",");//split the instruction excluding the label
                Op = tokens[0]; //op is equals to the instruction name as before
            }

            if (Op.equals("add")) {
                rs = reg.getValue(tokens[2]);
                System.out.println(rs);
                rt = reg.getValue(tokens[3]);
                rd = tokens[1];
                reg.setRegister(rd, alu.add(rs, rt));
            } else if (Op.equals("addi")) {
                tokens = this.instruction.split(",");
                rd = tokens[1];
                rs = reg.getValue(tokens[2]);
                immediate = Integer.parseInt(tokens[3]);
                reg.setRegister(rd, alu.addi(rs, immediate));

            } else if (Op.equals("lw")) {
                //lw,$1,2($2)
                rd = tokens[1];
                String d = tokens[2]; //d=2($2)
                String[] d1 = d.split("()");
                short offset = Short.parseShort(d1[0]); //offset=2 (as in our above eg)
                int Soffset = alu.signExtend(offset); //sign extend the offset "has no meaning"
                int address = reg.getValue(d1[2] + d1[3]); //get value of register $2 "d1[2]=$ , d1[3]=2"
                address += (4 * Soffset);
                reg.setRegister(rd, Data_Mem.getValue(address));

            } else if (Op.equals("sw")) {
                //sw,$1,2($2)
                rs = reg.getValue(tokens[1]);
                String d = tokens[2];
                String[] d1 = d.split("()");
                short offset = Short.parseShort(d1[0]);
                int Soffset = alu.signExtend(offset);
                int address = reg.getValue(d1[2] + d1[3]);
                address += (4 * Soffset);
                Data_Mem.addLocation(address, rs);
            } else if (Op.equals("lb")) {
                //lb,$1,2($2)
                rd = tokens[1];
                String d = tokens[2]; //d=2($2)
                String[] d1 = d.split("()");
                short offset = Short.parseShort(d1[0]); //offset=2 (as in our above eg)
                int Soffset = alu.signExtend(offset); //sign extend the offset "has no meaning"
                int address = reg.getValue(d1[2] + d1[3]); //get value of register $2 "d1[2]=$ , d1[3]=2"
                address += (1 * Soffset);
                reg.setRegister(rd, Data_Mem.getValue(address));
            } else if (Op.equals("lbu")) {
                //lbu,$1,2($2)
                rd = tokens[1];
                String d = tokens[2]; //d=2($2)
                String[] d1 = d.split("()");
                short offset = Short.parseShort(d1[0]); //offset=2 (as in our above eg)
                int Soffset = alu.signExtend(offset); //sign extend the offset "has no meaning"
                int address = reg.getValue(d1[2] + d1[3]); //get value of register $2 "d1[2]=$ , d1[3]=2"
                address += (4 * Soffset);
                reg.setRegister(rd, java.lang.Math.abs(Data_Mem.getValue(address)));
            } else if (Op.equals("sb")) {
                //sb,$1,2($2)
                rs = reg.getValue(tokens[1]);
                String d = tokens[2];
                String[] d1 = d.split("()");
                short offset = Short.parseShort(d1[0]);
                int Soffset = alu.signExtend(offset);
                int address = reg.getValue(d1[2] + d1[3]);
                address += (1 * Soffset);
                Data_Mem.addLocation(address, rs);

            } else if (Op.equals("sll")) {
                //sll,$1,$2,2
                rd = tokens[1];
                rs = reg.getValue(tokens[2]);
                rs *= (2 * Integer.parseInt(tokens[3]));
                reg.setRegister(rd, rs);

            } else if (Op.equals("nor")) {
                //nor,$1,$2,$3
                rd = tokens[1];
                rs = reg.getValue(tokens[2]);
                rt = reg.getValue(tokens[3]);
                String rsBinary = Integer.toBinaryString(rs);
                String rtBinary = Integer.toBinaryString(rt);
                char[] rsBin = rsBinary.toCharArray();
                char[] rtBin = rtBinary.toCharArray();
                int size;
                if (rsBin.length > rtBin.length)
                    size = rsBin.length;
                else
                    size = rtBin.length;
                char[] result = new char[size];
                for (int k = 0; i < size; i++) {
                    if ((rsBin[k] == '1' && rtBin[k] == '1') || (rsBin[k] == '1' && rtBin[k] == '0') || (rsBin[k] == '0' && rtBin[k] == '1'))
                        result[k] = '1';
                    else result[k] = '0';
                }
                for (int k = 0; i < result.length; i++) {
                    if (result[k] == '0')
                        result[k] = '1';
                    else
                        result[k] = '0';
                }
                String res = String.copyValueOf(result);
                reg.setRegister(rd, Integer.parseInt(res));

            } else if (Op.equals("slt")) {
                //slt,$1,$2,$3
                rd = tokens[1];
                rs = reg.getValue(tokens[2]);
                rt = reg.getValue(tokens[3]);
                if (rs < rt)
                    reg.setRegister(rd, 1);
                else reg.setRegister(rd, 0);
            } else if (Op.equals("slti")) {
                //slti,$1,$2,3
                rd = tokens[1];
                rs = reg.getValue(tokens[2]);
                int immediate = Integer.parseInt(tokens[3]);
                if (rs < immediate)
                    reg.setRegister(rd, 1);
                else
                    reg.setRegister(rd, 0);
            } else if (Op.equals("beq")) {
                //beq,$1,$2,L1
                rs = reg.getValue(tokens[1]);
                rt = reg.getValue(tokens[2]);
                if (rs == rt) {
                    String label = tokens[3];
                    int index = -1;
                    for (Map.Entry entry : labeledInstructions.entrySet()) {
                        if (entry.getValue().equals(label)) {
                            index = (int) entry.getKey(); //the index of the dst instruction
                            break;
                        }
                    }
                    if (index >= 0)
                        i = index - 1;
                    else System.err.println("The desired jump to label is not found in your program.");

                    continue;
                } else continue;

            } else if (Op.equals("j")) {
                //j,L1
                String label = this.tokens[1];
                int index = -1;
                for (Map.Entry entry : labeledInstructions.entrySet()) {
                    if (entry.getValue().equals(label)) {
                        index = (int) entry.getKey(); //the index of the dst instruction
                        break;
                    }
                }
                if (index >= 0)
                    i = index - 1;
                else System.err.println("The desired jump to label is not found in your program.");

                continue;

            } else if (Op.equals("jal")) {
                //jal,sum
                String label = tokens[1];
                reg.setRegister("$31", (i + 1)); //$ra=the next instruction after the jal
                for(int j=0;j<I_Mem.functions.size();j++){
                    this.instruction=I_Mem.functions.get(j);
                    if(instruction.indexOf(':')==-1)
                        continue;
                    else{
                        String[] tokens1;
                        tokens1=this.instruction.split(":");
                        //collect the indices and their corresponding labels of the labeled instructions only
                        labeledInstructions2.put(j,tokens1[0]); //the index is the key and the label is the value
                    }
                }

                for (int j = 0; j < I_Mem.functions.size(); j++) {

                    this.instruction = I_Mem.functions.get(j);
                    //check if there is no label in the instruction
                    if (instruction.indexOf(':') == -1) {
                        tokens = this.instruction.split(",");
                        Op = tokens[0];++clockCycles;
                    } else {
                        String[] tokens1;
                        tokens1 = this.instruction.split(":");
                        this.tokens = tokens1[1].split(",");//split the instruction excluding the label
                        if (tokens1[0].equals(label)) {
                            ++clockCycles;
                            Op = tokens[0]; //op is equals to the instruction name as before
                        } else {
                            continue;
                        }
                    }

                    if (Op.equals("add")) {
                        rs = reg.getValue(tokens[2]);
                        System.out.println(rs);
                        rt = reg.getValue(tokens[3]);
                        rd = tokens[1];
                        reg.setRegister(rd, alu.add(rs, rt));
                    } else if (Op.equals("addi")) {
                        tokens = this.instruction.split(",");
                        rd = tokens[1];
                        rs = reg.getValue(tokens[2]);
                        immediate = Integer.parseInt(tokens[3]);
                        reg.setRegister(rd, alu.addi(rs, immediate));

                    } else if (Op.equals("lw")) {
                        //lw,$1,2($2)
                        rd = tokens[1];
                        String d = tokens[2]; //d=2($2)
                        String[] d1 = d.split("()");
                        short offset = Short.parseShort(d1[0]); //offset=2 (as in our above eg)
                        int Soffset = alu.signExtend(offset); //sign extend the offset "has no meaning"
                        int address = reg.getValue(d1[2] + d1[3]); //get value of register $2 "d1[2]=$ , d1[3]=2"
                        address += (4 * Soffset);
                        reg.setRegister(rd, Data_Mem.getValue(address));

                    } else if (Op.equals("sw")) {
                        //sw,$1,2($2)
                        rs = reg.getValue(tokens[1]);
                        String d = tokens[2];
                        String[] d1 = d.split("()");
                        short offset = Short.parseShort(d1[0]);
                        int Soffset = alu.signExtend(offset);
                        int address = reg.getValue(d1[2] + d1[3]);
                        address += (4 * Soffset);
                        Data_Mem.addLocation(address, rs);
                    } else if (Op.equals("lb")) {
                        //lb,$1,2($2)
                        rd = tokens[1];
                        String d = tokens[2]; //d=2($2)
                        String[] d1 = d.split("()");
                        short offset = Short.parseShort(d1[0]); //offset=2 (as in our above eg)
                        int Soffset = alu.signExtend(offset); //sign extend the offset "has no meaning"
                        int address = reg.getValue(d1[2] + d1[3]); //get value of register $2 "d1[2]=$ , d1[3]=2"
                        address += (1 * Soffset);
                        reg.setRegister(rd, Data_Mem.getValue(address));
                    } else if (Op.equals("lbu")) {
                        //lbu,$1,2($2)
                        rd = tokens[1];
                        String d = tokens[2]; //d=2($2)
                        String[] d1 = d.split("()");
                        short offset = Short.parseShort(d1[0]); //offset=2 (as in our above eg)
                        int Soffset = alu.signExtend(offset); //sign extend the offset "has no meaning"
                        int address = reg.getValue(d1[2] + d1[3]); //get value of register $2 "d1[2]=$ , d1[3]=2"
                        address += (4 * Soffset);
                        reg.setRegister(rd, java.lang.Math.abs(Data_Mem.getValue(address)));
                    } else if (Op.equals("sb")) {
                        //sb,$1,2($2)
                        rs = reg.getValue(tokens[1]);
                        String d = tokens[2];
                        String[] d1 = d.split("()");
                        short offset = Short.parseShort(d1[0]);
                        int Soffset = alu.signExtend(offset);
                        int address = reg.getValue(d1[2] + d1[3]);
                        address += (1 * Soffset);
                        Data_Mem.addLocation(address, rs);

                    } else if (Op.equals("sll")) {
                        //sll,$1,$2,2
                        rd = tokens[1];
                        rs = reg.getValue(tokens[2]);
                        rs *= (2 * Integer.parseInt(tokens[3]));
                        reg.setRegister(rd, rs);

                    } else if (Op.equals("nor")) {
                        //nor,$1,$2,$3
                        rd = tokens[1];
                        rs = reg.getValue(tokens[2]);
                        rt = reg.getValue(tokens[3]);
                        String rsBinary = Integer.toBinaryString(rs);
                        String rtBinary = Integer.toBinaryString(rt);
                        char[] rsBin = rsBinary.toCharArray();
                        char[] rtBin = rtBinary.toCharArray();
                        int size;
                        if (rsBin.length > rtBin.length)
                            size = rsBin.length;
                        else
                            size = rtBin.length;
                        char[] result = new char[size];
                        for (int k = 0; i < size; i++) {
                            if ((rsBin[k] == '1' && rtBin[k] == '1') || (rsBin[k] == '1' && rtBin[k] == '0') || (rsBin[k] == '0' && rtBin[k] == '1'))
                                result[k] = '1';
                            else result[k] = '0';
                        }
                        for (int k = 0; i < result.length; i++) {
                            if (result[k] == '0')
                                result[k] = '1';
                            else
                                result[k] = '0';
                        }
                        String res = String.copyValueOf(result);
                        reg.setRegister(rd, Integer.parseInt(res));

                    } else if (Op.equals("slt")) {
                        //slt,$1,$2,$3
                        rd = tokens[1];
                        rs = reg.getValue(tokens[2]);
                        rt = reg.getValue(tokens[3]);
                        if (rs < rt)
                            reg.setRegister(rd, 1);
                        else reg.setRegister(rd, 0);
                    } else if (Op.equals("slti")) {
                        //slti,$1,$2,3
                        rd = tokens[1];
                        rs = reg.getValue(tokens[2]);
                        int immediate = Integer.parseInt(tokens[3]);
                        if (rs < immediate)
                            reg.setRegister(rd, 1);
                        else
                            reg.setRegister(rd, 0);
                    } else if (Op.equals("beq")) {
                        //beq,$1,$2,L1
                        rs = reg.getValue(tokens[1]);
                        rt = reg.getValue(tokens[2]);
                        if (rs == rt) {
                             label = tokens[3];
                            int index = -1;
                            for (Map.Entry entry : labeledInstructions2.entrySet()) {
                                if (entry.getValue().equals(label)) {
                                    index = (int) entry.getKey(); //the index of the dst instruction
                                    break;
                                }
                            }
                            if (index >= 0)
                                i = index - 1;
                            else System.err.println("The desired jump to label is not found in your program.");

                            continue;
                        } else continue;

                    } else if (Op.equals("j")) {
                        //j,L1
                         label = this.tokens[1];
                        int index = -1;
                        for (Map.Entry entry : labeledInstructions2.entrySet()) {
                            if (entry.getValue().equals(label)) {
                                index = (int) entry.getKey(); //the index of the dst instruction
                                break;
                            }
                        }
                        if (index >= 0)
                            i = index - 1;
                        else System.err.println("The desired jump to label is not found in your program.");

                        continue;

                    } else if (Op.equals("jr")) {
                        //jr,$31
                        int index = reg.getValue(tokens[1]);
                        i = index - 1;
                        continue;
                    } else {
                        System.err.println("UNSUPPORTED instruction.");
                        break;
                    }


                }


            } else if (Op.equals("jr")) {
                //jr,$31
                int index = reg.getValue(tokens[1]);
                i = index - 1;
                continue;
            } else {
                System.err.println("UNSUPPORTED instruction.");
                break;
            }



        }


        System.out.println("Register File: ");
        RegisterFile.printFile(); //prints register file modified registers after the program
        System.out.println("=========================================================================================");
        System.out.println("Data Memory: ");
        Data_Mem.printMem(); //prints  modified memory locations after the program
        System.out.println("=========================================================================================");
        System.out.println("Clock Cycles Spanned = " + clockCycles + " Cycles");


    }
}

