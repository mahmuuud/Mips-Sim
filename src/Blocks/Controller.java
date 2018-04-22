
package Blocks;

public class Controller {
    private int ifBranch=0;
    private int RegisterWrite=0;
    private int AluOp0=0;
    private int AluOp1=0;
    private int RegDst=0;
    private int AluSrc=0;
    private int MemRead=0;
    private int MemWrite=0;
    private int MemtoReg=0;
    private int jump=0;
    private String OpCode;
    private int PctoI_m;
    private int ImtoCu;
    private int ImtoSll;
    private int ImtoReadReg1;
    private int Imtoreadreg2;
    private int Imto0inMux;
    private int Imto1inMux;
    private int MuxToReadReg2;
    private int ImtoSignExtend;
    private int ImtoAluControl;
    private int ReadData1toALU;
    private int ReadData2to0inMux;
    private int SignExtendto1inMux;
    private int MuxtoAlu;
    private int ReadData2toDm;
    private int AluControltoAlu;
    private int AlutoDm;
    private int AluDifftoAND;
    private int Dmto1inMux;
    private int Aluto0inMux;
    private int MuxtoRegFile;
    //goz2 bta3 l pc lel heta ly fo2
    private int PctoAdder;  // the adder +4
    private int AddertoOPofSll; // OPy3ny output the concatination of the first 4 bits of pc+4 from the adder
    private int AddertoAdder2;
    private int SignExtendtoSll;
    private int SlltoAdder2;
    private int Adder2to1inMux;
    private int Adderto0inMux;
    private int Muxto0inMux;
    private int FromAddertoOPofSllto1inMux;
    private int FromMuxtoPc;
    public Controller(String InstructionName){

        this.OpCode=InstructionName;
    }

    // critical path of the circuit 
    public int  setPctoI_m(int n)
    {
        return this.PctoI_m;

    }
    public int  setImtoCu(int n)
    {
        return this.ImtoCu;

    }
    public int  setImtoSll(int n)
    {
        return this.ImtoSll;

    }
    public int  setImtoReadReg1(int n)
    {
        return this.ImtoReadReg1;

    }
    public int  setImtoreadreg2(int n)
    {
        return this.Imtoreadreg2;

    }
    public int  setImto0inMux(int n)
    {
        return this.Imto0inMux;

    }
    public int  setImto1inMux(int n)
    {
        return this.Imto1inMux;

    }
    public int  setMuxToReadReg2(int n)
    {
        return this.MuxToReadReg2;

    }
    public int  setImtoSignExtend(int n)
    {
        return this.ImtoSignExtend;

    }
    public int  setImtoAluControl(int n)
    {
        return this.ImtoAluControl;

    }
    public int  setReadData1toALU(int n)
    {
        return this.ReadData1toALU;

    }
    public int  setReadData2to0inMux(int n)
    {
        return this.ReadData2to0inMux;

    }
    public int  setSignExtendto1inMux(int n)
    {
        return this.SignExtendto1inMux;

    }
    public int  setMuxtoAlu(int n)
    {
        return this.MuxtoAlu;

    }
    public int  setReadData2toDm(int n)
    {
        return this.ReadData2toDm;

    }
    public int  setAluControltoAlu(int n)
    {
        return this.AluControltoAlu;

    }
    public int setAlutoDm(int n) {
        return this.AlutoDm;

    }
    public int  setAluDifftoAND(int n)
    {
        return this.AluDifftoAND;

    }
    public int  setDmto1inMux(int n)
    {
        return this.Dmto1inMux;

    }
    public int  setAluto0inMux(int n)
    {
        return this.Aluto0inMux;

    }
    public int  setMuxtoRegFile(int n)
    {
        return this.MuxtoRegFile;

    }
    // the short path of the circuit
    public int  setPctoAdder(int n)
    {
        return this.PctoAdder;

    }
    public int  setAddertoOPofSll(int n)
    {
        return this.AddertoOPofSll;

    }
    public int  setAddertoAdder2(int n)
    {
        return this.AddertoAdder2;

    }
    public int  setSignExtendtoSll(int n)
    {
        return this.SignExtendtoSll;

    }
    public int  setSlltoAdder2(int n)
    {
        return this.SlltoAdder2;

    }
    public int  setAdder2to1inMux(int n)
    {
        return this.Adder2to1inMux;

    }
    public int  setAdderto0inMux(int n)
    {
        return this.Adderto0inMux;

    }
    public int  setMuxto0inMux(int n)
    {
        return this.Muxto0inMux;

    }
    public int  setFromAddertoOpofSllto1inMux(int n)
    {
        return this.FromAddertoOPofSllto1inMux;

    }
    public int  setFromMuxtoPc(int n)
    {
        return this.FromMuxtoPc;

    }

    // critical path of the circuit 
    public int  getPctoI_m()
    {
        return this.PctoI_m;

    }
    public int  getImtoCu()
    {
        return this.ImtoCu;

    }
    public int  getImtoSll()
    {
        return this.ImtoSll;

    }
    public int  getImtoReadReg1()
    {
        return this.ImtoReadReg1;

    }
    public int  getImtoreadreg2()
    {
        return this.Imtoreadreg2;

    }
    public int  getImto0inMux()
    {
        return this.Imto0inMux;

    }
    public int  getImto1inMux()
    {
        return this.Imto1inMux;

    }
    public int  getMuxToReadReg2()
    {
        return this.MuxToReadReg2;

    }
    public int  getImtoSignExtend()
    {
        return this.ImtoSignExtend;

    }
    public int  getImtoAluControl()
    {
        return this.ImtoAluControl;

    }
    public int  getReadData1toALU()
    {
        return this.ReadData1toALU;

    }
    public int  getReadData2to0inMux()
    {
        return this.ReadData2to0inMux;

    }
    public int  getSignExtendto1inMux()
    {
        return this.SignExtendto1inMux;

    }
    public int  getMuxtoAlu()
    {
        return this.MuxtoAlu;

    }
    public int  getReadData2toDm()
    {
        return this.ReadData2toDm;

    }
    public int  getAluControltoAlu()
    {
        return this.AluControltoAlu;

    }
    public int getAlutoDm() {
        return this.AlutoDm;

    }
    public int  getAluDifftoAND()
    {
        return this.AluDifftoAND;

    }
    public int  getDmto1inMux()
    {
        return this.Dmto1inMux;

    }
    public int  getAluto0inMux()
    {
        return this.Aluto0inMux;

    }
    public int  getMuxtoRegFile()
    {
        return this.MuxtoRegFile;

    }
    // the short path of the circuit
    public int  getPctoAdder()
    {
        return this.PctoAdder;

    }
    public int  getAddertoOPofSll()
    {
        return this.AddertoOPofSll;

    }
    public int  getAddertoAdder2()
    {
        return this.AddertoAdder2;

    }
    public int  getSignExtendtoSll()
    {
        return this.SignExtendtoSll;

    }
    public int  getSlltoAdder2()
    {
        return this.SlltoAdder2;

    }
    public int  getAdder2to1inMux()
    {
        return this.Adder2to1inMux;

    }
    public int  getAdderto0inMux()
    {
        return this.Adderto0inMux;

    }
    public int  getMuxto0inMux()
    {
        return this.Muxto0inMux;

    }
    public int  getFromAddertoOpofSllto1inMux()
    {
        return this.FromAddertoOPofSllto1inMux;

    }
    public int  getFromMuxtoPc()
    {
        return this.FromMuxtoPc;

    }


}