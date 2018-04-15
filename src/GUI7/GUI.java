package GUI7;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI  extends JFrame {
    //<-------------- screen resoultion-----------------------

    private int HeightDim;
    private int WidthDim;

    //<------------------------Comboboxes------------------


    private String[] InstructionsName ={"add","addi","lw","sw","lb","lbu","sb","sll","nor","beq","j","jal","jr","slt","slti"};
    private String[] NumberOfRegisters_rs={"$0","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra",};
    private String[] NumberOfRegisters_rt={"$0","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra",};
    private String[] NumberOfRegisters_rd={"$0","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra",};

    JComboBox[]  InstructionType;
    JComboBox[] rs ;
    JComboBox[] rt ;
    JComboBox[] rd ;

    //<------------------------panels-------------------------------

    private JPanel pnltop=new JPanel();
    private JPanel pnlmid=new JPanel();
    private JPanel pnlbotton =new JPanel();





    //<---------------------------checkbox------------------
    private JCheckBox[] checked;


    //<-----------------textbox for offset && label && number of instructions --------------

    private JTextField[] offset;
    private JTextField[] label;
    private JTextField noOfInstructions=new JTextField("1");
    private JLabel[] lines;

    //<------------------buttons-----------------------


    private JButton Run=new JButton("Run");
    private JButton Graph =new JButton("Graph");
    private JButton ok=new JButton(" + ");


    //<----------------------------------- variables-----------------------
    private  int numberoflines=1;
    private static int noofline=0;
    private String nameoflabel;






    public GUI(){

        frontend();

    }

    public void frontend(){
        //<--------------default--------------

        this.setTitle("Semi Colon ;");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("semicolon.jpg")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //<-------------- screen resoultion-----------------------

        Dimension screenResoultion = Toolkit.getDefaultToolkit().getScreenSize();
        HeightDim=screenResoultion.height;
        WidthDim=screenResoultion.width;
        this.setResizable(false);
        this.setBounds(WidthDim/4,HeightDim/4,WidthDim/2+60,HeightDim/2+60);


        //<--------------------Jpanels-----------------------------------

        pnltop.setLayout(new FlowLayout(10) );
        pnlmid.setLayout(new FlowLayout(10));



        pnlbotton.setLayout(new FlowLayout());




        //<---------------main Jpanel---------------




        this.add(pnltop,BorderLayout.NORTH);

        this.add(pnlmid,BorderLayout.CENTER);
        JScrollPane scrollPane=new JScrollPane(pnlmid,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);
        this.add(pnlbotton,BorderLayout.SOUTH);





        //<-------------------------checkedbox----------------




        //<-------------------------Text field-----------------
        noOfInstructions.setBorder(BorderFactory.createTitledBorder("how many lines do you want ?:"));







        //<-------------------------Buttons--------------------
        ok.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        numberoflines=Integer.parseInt(noOfInstructions.getText());
                        morethaninstruction(numberoflines);
                        numberoflines=0;

                    }
                }


        );



        //<------------------- add objects to the panel in order (pnltop)-------------


        pnltop.add(noOfInstructions);
        noOfInstructions.setPreferredSize(new Dimension(235, 50));
        pnltop.add(Box.createRigidArea(new Dimension(60, 1)));

        pnltop.add(ok);
        ok.setPreferredSize(new Dimension(100, 20));




        morethaninstruction(numberoflines);







        //<------------------- add objects to the panel in order (pnlbotton)-------------




        pnlbotton.add(Run);
        Run.setPreferredSize(new Dimension(100, 20));


        pnlbotton.add(Graph);
        Graph.setPreferredSize(new Dimension(100, 20));









    }

    public void morethaninstruction(int n){

        pnlmid.setPreferredSize(new Dimension(WidthDim/2+70,HeightDim/2+55*n));


        //<----------------------add objects to the panel in order (pnlmid)-------------

        for (int i = 0; i < n; i++) {
            ++noofline;
            offset =new JTextField[n];
            lines=new JLabel[n];

            checked=new JCheckBox[n];
            label=new JTextField[n];
            InstructionType=new JComboBox[n];
            rs=new JComboBox[n];
            rt=new JComboBox[n];
            rd =new JComboBox[n];

            nameoflabel=Integer.toString(noofline);

            offset[i]=new JTextField("0");
            lines[i]=new JLabel(nameoflabel);
            checked[i]=new JCheckBox("Label?:");
            label[i]=new JTextField();
            InstructionType[i]=new JComboBox(InstructionsName);
            rs[i]=new JComboBox(NumberOfRegisters_rs);
            rt[i]=new JComboBox(NumberOfRegisters_rt);
            rd[i]=new JComboBox(NumberOfRegisters_rd);
            //<-----------------------comboboxes------------

            InstructionType[i].setBorder(BorderFactory.createTitledBorder("Instruction Type"));
            rs[i].setBorder(BorderFactory.createTitledBorder("rs"));
            rt[i].setBorder(BorderFactory.createTitledBorder("rt"));
            rd[i].setBorder(BorderFactory.createTitledBorder("rd"));


            label[i].setBorder(BorderFactory.createTitledBorder("label:"));
            offset[i].setBorder(BorderFactory.createTitledBorder("Offset:"));



            pnlmid.add(lines[i]);
            lines[i].setPreferredSize(new Dimension(50,50));
            pnlmid.add(label[i]);
            label[i].setPreferredSize(new Dimension(100, 50));
            pnlmid.add(InstructionType[i]);
            InstructionType[i].setPreferredSize(new Dimension(130, 50));
            pnlmid.add(offset[i]);
            offset[i].setPreferredSize(new Dimension(65, 50));


            pnlmid.add(rs[i]);

            pnlmid.add(rt[i]);
            pnlmid.add(rd[i]);


            pnlmid.add(Box.createRigidArea(new Dimension(70,1)));


            pnlmid.add(checked[i]);




        }
        this.repaint();
    }


}

