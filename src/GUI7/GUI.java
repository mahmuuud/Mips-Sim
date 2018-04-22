package GUI7;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;

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
    private  JCheckBox[] checked;


    //<-----------------textbox for offset && label && number of instructions --------------

    private JTextField[] offset;
    private JTextField[] label;
    private JTextField noOfInstructions=new JTextField("1");
    private JTextField endOFinstructions=new JTextField("1");
    private JLabel[] lines;

    //<------------------buttons-----------------------


    private JButton Run=new JButton("Run");
    private JButton Graph =new JButton("Graph");
    private JButton ok=new JButton(" Generate ");


    //<----------------------------------- variables-----------------------
    private  int numberoflines=1;
    private static int noofline=0;
    private String nameoflabel;
    private int endofinstruction=0;
    private static int address;

    private  JTextField saveroffset;
    private  JLabel saverlines;
    private JCheckBox saverchechked;
    private  JTextField saverlabel;
    private JComboBox saverInstructiontype;
    private JComboBox saverrs;
    private JComboBox saverrt;
    private JComboBox saverrd;

    private ArrayList<String> saverun=new ArrayList<String>();
    ArrayList<String> saver2=new ArrayList<>();
    ArrayList<String> result=new ArrayList<>();





    public GUI(){

        frontend();

        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i <result.size() ; i++) {

                    for (int j = 1; j <result.size(); j++) {

                        if(result.get(i).toCharArray()[j-1]==':'){
                            break;
                        }

                    }
                }
                System.out.println(result.toString());
            }
        });



    }

    private void frontend(){
        //<--------------default--------------

        this.setTitle("Semi Colon ;");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("semicolon.jpg")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //<-------------- screen resoultion-----------------------


        HeightDim=900;
        WidthDim=1350;
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
        endOFinstructions.setBorder(BorderFactory.createTitledBorder("Last Instruction :"));







        //<-------------------------Buttons--------------------

        //morethaninstruction(numberoflines);
        morethaninstruction(Integer.parseInt(noOfInstructions.getText()));


        pnlmid.setPreferredSize(new Dimension(WidthDim/2+70,HeightDim/2+55*numberoflines));


        //<----------------------add objects to the panel in order (pnlmid)-------------


        //collectingData(saverchechked,saverlabel,saveroffset,saverInstructiontype,saverlines,saverrs,saverrt,saverrd,numberoflines);











        //<------------------- add objects to the panel in order (pnltop)-------------


        pnltop.add(noOfInstructions);
        noOfInstructions.setPreferredSize(new Dimension(235, 50));
        pnltop.add(Box.createRigidArea(new Dimension(60, 1)));

        pnltop.add(ok);
        pnltop.add(Box.createRigidArea(new Dimension(80, 1)));
        ok.setPreferredSize(new Dimension(130, 20));
        pnltop.add(endOFinstructions);

        endOFinstructions.setPreferredSize(new Dimension(190,50));




        //<------------------- add objects to the panel in order (pnlbotton)-------------




        pnlbotton.add(Run);
        Run.setPreferredSize(new Dimension(100, 20));


        pnlbotton.add(Graph);
        Graph.setPreferredSize(new Dimension(100, 20));








    }

    private void morethaninstruction(int n){

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

//<------------------- saver-----------------

            saveroffset=offset[i];
            saverlines=lines[i];
            saverchechked=checked[i];
            saverlabel=label[i];
            saverInstructiontype=InstructionType[i];
            saverrs=rs[i];
            saverrt=rt[i];
            saverrd=rd[i];



            // run(saverchechked,saverlabel,saveroffset,saverInstructiontype,saverlines,n);





            //<-----------------------comboboxes------------

            InstructionType[i].setBorder(BorderFactory.createTitledBorder("Instruction Type"));
            rs[i].setBorder(BorderFactory.createTitledBorder("rs"));
            rt[i].setBorder(BorderFactory.createTitledBorder("rt"));
            rd[i].setBorder(BorderFactory.createTitledBorder("rd"));


            label[i].setBorder(BorderFactory.createTitledBorder("label:"));
            offset[i].setBorder(BorderFactory.createTitledBorder("Offset:"));



            pnlmid.add(lines[i]);
            lines[i].setPreferredSize(new Dimension(70,50));
            pnlmid.add(label[i]);
            label[i].setPreferredSize(new Dimension(100, 50));
            pnlmid.add(InstructionType[i]);
            InstructionType[i].setPreferredSize(new Dimension(130, 50));
            pnlmid.add(offset[i]);
            offset[i].setPreferredSize(new Dimension(65, 50));


            pnlmid.add(rs[i]);

            pnlmid.add(rt[i]);
            pnlmid.add(rd[i]);


            pnlmid.add(Box.createRigidArea(new Dimension(35,1)));


            pnlmid.add(checked[i]);

            ok.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            result.clear();
                            run(saverchechked,saverlabel,saveroffset,saverInstructiontype,saverlines,saverrs,saverrt,saverrd,n);




                        }
                    }
            );

            collectingData(saverchechked,saverlabel,saveroffset,saverInstructiontype,saverlines,saverrs,saverrt,saverrd,numberoflines);







        }
        // run(saverchechked,saverlabel,saveroffset,saverInstructiontype,saverlines,n);





    }

    public void run(JCheckBox checkBox, JTextField textFields,JTextField textoffset,JComboBox swORlw,JLabel Numberline,JComboBox rs1,JComboBox rt1,JComboBox rd1, int size){
        Run.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        ArrayList<String> result2=new ArrayList<String>();

                        for (int i = 0; i <size ; i++) {
                            saverun.add(i, Numberline.getText()+":"+swORlw.getSelectedItem().toString()+ rs1.getSelectedItem().toString()+rt1.getSelectedItem().toString()+rd1.getSelectedItem().toString());
                            saver2.add(i, saverun.get(i));
                        }

                        for (int i = 0; i <size ; i++) {

                            result2.add(i,saver2.get(i));
                            for (int j = 0; j < size; j++) {
                                if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==saver2.indexOf(saver2.get(j))){

                                    continue;
                                }
                                else {
                                    saver2.remove(j);
                                }
                            }

                        }


                        result=removeDuplicates(saver2);
                        //System.out.println(result.toString());
                        //System.out.println(result.size());






                    }
                }
        );



    }


    static ArrayList<String> removeDuplicates(ArrayList<String> list) {

        // Store unique items in result.
        ArrayList<String> result = new ArrayList<>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : list) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }





    private   void collectingData(JCheckBox checkBox, JTextField textFields,JTextField textoffset,JComboBox swORlw,JLabel Numberline,JComboBox rs2,JComboBox rt2,JComboBox rd2, int size){
        ok.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pnlmid.removeAll();
                        pnlmid.revalidate();
                        pnlmid.repaint();

                        noofline=0;
                        numberoflines=Integer.parseInt(noOfInstructions.getText());
                        morethaninstruction(numberoflines);




                    }
                }
        );


        chechekandLABEL(checkBox,textFields);
        offsetTrueOrNO(textoffset,swORlw);

        run(checkBox,textFields,textoffset,swORlw,Numberline,rs2,rt2,rd2,size);








    }


    private void chechekandLABEL(JCheckBox checkBox, JTextField textFields){
        checkBox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent i) {
                        if (i.getStateChange() == ItemEvent.SELECTED) {
                            textFields.setEditable(false);
                        } else if (i.getStateChange() == ItemEvent.DESELECTED) {
                            textFields.setEditable(true);
                        }
                    }
                }

        );






    }

    private void offsetTrueOrNO(JTextField textField1,JComboBox comboBox){
        textField1.setEditable(false);
        comboBox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent itemEvent) {
                        String nameofit = comboBox.getSelectedItem().toString();
                        if(nameofit=="sw"||nameofit=="lw"){
                            textField1.setEditable(true);
                        }
                        else {
                            textField1.setEditable(false);
                        }
                    }
                }
        );

    }

}
