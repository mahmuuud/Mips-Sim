package Blocks;

public class Controller {
    private boolean Branch=false;
    private boolean RegisterWrite=false;
    private boolean AluOp=false;
    private boolean RegDst=false;
    private boolean AluSrc=false;
    private boolean MemRead=false;
    private boolean MemWrite=false;
    private boolean MemtoReg=false;
    private boolean jump=false;
    private String OpCode;
    private String fnCode;

    public Controller(String InstructionName){

        this.OpCode=InstructionName;

    }
    public void Control()
    {

        if(this.OpCode=="add")
        {
            RegDst=true;
            RegisterWrite=true;
            AluOp=true;

        }
        else if(this.OpCode=="sb")
        {
            RegDst=true;
            RegisterWrite=true;
            AluOp=true;




        }
        else if(this.OpCode=="and")
        {
            RegDst=true;
            RegisterWrite=true;
            AluOp=true;



        }
        else if(this.OpCode=="or")
        {
            RegDst=true;
            RegisterWrite=true;
            AluOp=true;




        }
        else if(this.OpCode=="slt")
        {
            RegDst=true;
            RegisterWrite=true;
            AluOp=true;



        }
        else if(this.OpCode=="beq")
        {
            Branch=true;
            AluOp=true;




        }
        else if(this.OpCode=="sw")
        {

            MemWrite=true;
            RegisterWrite=true;
            AluOp=false;
            AluSrc=true;
            MemWrite=true;


        }
        else if(this.OpCode=="lw")
        {

            MemRead=true;
            RegisterWrite=true;
            AluOp=false;
            AluSrc=true;
            MemtoReg=true;

        }
        else if(this.OpCode=="j")
        {

            jump=true;

        }





    }














}
