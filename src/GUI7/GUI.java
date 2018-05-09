package GUI7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
abstract public class GUI  extends JFrame {
    //<-------------- screen resoultion-----------------------
    private int HeightDim;
    private int WidthDim;
    //<------------------------Comboboxes------------------
    private String[] InstructionsName ={"add","addi","lw","sw","lb","lbu","sb","sll","nor","beq","j","jal","jr","slt","slti"};
    private String[] NumberOfRegisters_rs={"$0","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
    private String[] NumberOfRegisters_rt={"$0","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
    private String[] NumberOfRegisters_rd={"$0","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
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
    private JLabel[] coma1;
    private JLabel[] coma2;
    private JLabel[] coma3;
    private JLabel[] cus1;
    private JLabel[] cus2;
    //<------------------buttons-----------------------
    private JButton Run=new JButton("Compile");
    private JButton Graph =new JButton("Run");
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
    private JLabel savercoma1;
    private JLabel savercoma2;
    private JLabel savercoma3;
    private JLabel savercus1;
    private JLabel savercus2;
    protected JTextField memoryAddress=new JTextField("0");
    protected ArrayList<String>a;
    protected int Address=Integer.parseInt(memoryAddress.getText());
    private JCheckBox isFunction=new JCheckBox("Function");
    private ArrayList<String> saverun=new ArrayList<String>();
     private ArrayList<String> saver2=new ArrayList<>();
    private ArrayList<String> result=new ArrayList<>();
     private ArrayList<String> finalresult=new ArrayList<>();
     private ArrayList<String> FINALRESULT =new ArrayList<>();
    public abstract void saveInstructions();
    public GUI(){

        Graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInstructions();

            }
        });

        frontend();

        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            sorting(result);

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
        //<-------------------------Buttons--------------------
        morethaninstruction(Integer.parseInt(noOfInstructions.getText()));
        pnlmid.setPreferredSize(new Dimension(WidthDim/2+70,HeightDim/2+55*numberoflines));
        //<----------------------add objects to the panel in order (pnlmid)-------------
        //<------------------- add objects to the panel in order (pnltop)-------------
        pnltop.add(noOfInstructions);
        noOfInstructions.setPreferredSize(new Dimension(235, 50));
        pnltop.add(Box.createRigidArea(new Dimension(7, 1)));
        pnltop.add(ok);
        pnltop.add(Box.createRigidArea(new Dimension(80, 1)));
        memoryAddress.setPreferredSize(new Dimension(170,50));
        memoryAddress.setBorder(BorderFactory.createTitledBorder("Program Memory Address"));
        pnltop.add(memoryAddress);
        ok.setPreferredSize(new Dimension(130, 20));
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
            coma1=new JLabel[n];
            coma2=new JLabel[n];
            coma3=new JLabel[n];
            cus1=new JLabel[n];
            cus2=new JLabel[n];
            nameoflabel=Integer.toString(noofline);
            offset[i]=new JTextField();
            lines[i]=new JLabel(nameoflabel);
            checked[i]=new JCheckBox("Label?:");
            label[i]=new JTextField();
            InstructionType[i]=new JComboBox(InstructionsName);
            rs[i]=new JComboBox(NumberOfRegisters_rs);
            rt[i]=new JComboBox(NumberOfRegisters_rt);
            rd[i]=new JComboBox(NumberOfRegisters_rd);
            coma1[i]=new JLabel(",");
            coma2[i]=new JLabel(",");
            coma3[i]=new JLabel(",");
            cus1[i]=new JLabel("(");
            cus2[i]=new JLabel(")");
//<------------------- saver-----------------
            saveroffset=offset[i];
            saverlines=lines[i];
            saverchechked=checked[i];
            saverlabel=label[i];
            saverInstructiontype=InstructionType[i];
            saverrs=rs[i];
            saverrt=rt[i];
            saverrd=rd[i];
            savercoma1=coma1[i];
            savercoma2=coma2[i];
            savercoma3=coma3[i];
            savercus1=cus1[i];
            savercus2=cus2[i];
            //<-----------------------comboboxes------------
            InstructionType[i].setBorder(BorderFactory.createTitledBorder("Instruction Type"));
            rs[i].setBorder(BorderFactory.createTitledBorder("R1"));
            rt[i].setBorder(BorderFactory.createTitledBorder("R2"));
            rd[i].setBorder(BorderFactory.createTitledBorder("R3"));
            label[i].setBorder(BorderFactory.createTitledBorder("label:"));
            label[i].setEditable(false);
            offset[i].setBorder(BorderFactory.createTitledBorder("Offset:"));
            pnlmid.add(lines[i]);
            lines[i].setPreferredSize(new Dimension(65,50));
            pnlmid.add(label[i]);
            label[i].setPreferredSize(new Dimension(100, 50));
            pnlmid.add(InstructionType[i]);
            InstructionType[i].setPreferredSize(new Dimension(130, 50));
            pnlmid.add(coma1[i]);
            coma1[i].setPreferredSize(new Dimension(5,20));
            pnlmid.add(rs[i]);
            pnlmid.add(coma2[i]);
            coma2[i].setPreferredSize(new Dimension(5,20));
            pnlmid.add(offset[i]);
            offset[i].setPreferredSize(new Dimension(75, 50));
            pnlmid.add(cus1[i]);
            cus1[i].setPreferredSize(new Dimension(5,20));
            pnlmid.add(rt[i]);
            pnlmid.add(cus2[i]);
            cus2[i].setPreferredSize(new Dimension(5,20));
            pnlmid.add(coma3[i]);
            coma3[i].setPreferredSize(new Dimension(5,20));
            pnlmid.add(rd[i]);
            cus1[i].setVisible(false);
            cus2[i].setVisible(false);
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
            collectingData(saverchechked,saverlabel,saveroffset,saverInstructiontype
                    ,saverlines,saverrs,saverrt,saverrd,numberoflines,savercoma1,
                    savercoma2,savercoma3,savercus1,savercus2);
        }
    }
    public void run(JCheckBox checkBox, JTextField textFields,JTextField textoffset,JComboBox swORlw,JLabel Numberline,JComboBox rs1,JComboBox rt1,JComboBox rd1, int size){
        Run.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ArrayList<String> result2=new ArrayList<String>();
                        boolean checked=checkBox.isSelected();
                        String test=swORlw.getSelectedItem().toString();

                        if (test=="add"||test=="nor"||test=="slt"){
                            if (checked){
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+textFields.getText()+":"+swORlw.getSelectedItem().toString()+","+
                                            rs1.getSelectedItem().toString()+","+rt1.getSelectedItem().toString()+","+rd1.getSelectedItem().toString());
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                            else{
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+swORlw.getSelectedItem().toString()+
                                            ","+rs1.getSelectedItem().toString()+","+rt1.getSelectedItem().toString()+","+rd1.getSelectedItem().toString());
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                        }
                        else if (test=="j"||test=="jal"){
                            if (checked){
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+textFields.getText()+":"+swORlw.getSelectedItem().toString()+","+textoffset.getText());
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                            else{
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+swORlw.getSelectedItem().toString()+","+textoffset.getText());
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                        }
                        else if (test=="addi"||test=="sll"||test=="slti"||test=="beq"){
                            if (checked){
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+textFields.getText()+":"+swORlw.getSelectedItem().toString()+
                                            ","+rs1.getSelectedItem().toString()+","+rt1.getSelectedItem().toString()+","+textoffset.getText());
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                            else{
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+swORlw.getSelectedItem().toString()+
                                            ","+rs1.getSelectedItem().toString()+","+rt1.getSelectedItem().toString()+","+textoffset.getText());
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                        }
                        else if (test=="sw"||test=="lw"||test=="lb"||test=="lbu"||test=="sb"){
                            if (checked){
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+textFields.getText()+":"+swORlw.getSelectedItem().toString()+
                                            ","+rs1.getSelectedItem().toString()+","+textoffset.getText()+"("+rt1.getSelectedItem().toString()+")");
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                            else {
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+swORlw.getSelectedItem().toString()+
                                            ","+rs1.getSelectedItem().toString()+","+textoffset.getText()+"("+rt1.getSelectedItem().toString()+")");
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                        }
                        else if (test=="jr")
                        {
                            if (checked){
                                for (int i = 0; i <size ; i++) {
                                    saverun.add(i, Numberline.getText()+";"+textFields.getText()+":"+swORlw.getSelectedItem().toString()+
                                            ","+rs1.getSelectedItem().toString());
                                    saver2.add(i, saverun.get(i));
                                }
                                for (int i = 0; i <size ; i++) {
                                    result2.add(i,saver2.get(i));
                                    for (int j = 0; j < size; j++) {
                                        if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                                saver2.indexOf(saver2.get(j))){
                                            continue;
                                        }
                                        else {
                                            saver2.remove(j);
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i <size ; i++) {
                                saverun.add(i, Numberline.getText()+";"+swORlw.getSelectedItem().toString()+
                                        ","+rs1.getSelectedItem().toString());
                                saver2.add(i, saverun.get(i));
                            }
                            for (int i = 0; i <size ; i++) {
                                result2.add(i,saver2.get(i));
                                for (int j = 0; j < size; j++) {
                                    if(result2.get(i).toCharArray()[0]==saver2.get(j).toCharArray()[0]&& result2.indexOf(result2.get(i))==
                                            saver2.indexOf(saver2.get(j))){
                                        continue;
                                    }
                                    else {
                                        saver2.remove(j);
                                    }
                                }
                            }
                        }
                        result=removeDuplicates(saver2);

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
    public char[] remove_one_character_from_a_character_array_in_java(char[] original, int location_to_remove) {
        char[] result = new char[original.length-1];
        int last_insert = 0;
        for (int i = 0; i < original.length; i++){
            if (i == location_to_remove)
                i++;

            result[last_insert++] = original[i];
        }
        return result;
    }
    private   void collectingData(JCheckBox checkBox, JTextField textFields,
                                  JTextField textoffset, JComboBox swORlw,
                                  JLabel Numberline,JComboBox rs2,
                                  JComboBox rt2,JComboBox rd2,int size,JLabel coma1st,JLabel couma2snd,JLabel couma3rd,
                                  JLabel cus1st,JLabel cus2nd){
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
        I_type(swORlw,rd2,cus1st,cus2nd,couma3rd,textoffset);
        run(checkBox,textFields,textoffset,swORlw,Numberline,rs2,rt2,rd2,size);
        J_type(swORlw,rs2,rt2,rd2,textoffset);
        R_type(swORlw,rs2,rt2,rd2,cus1st,cus2nd,textoffset);






    }
    private void chechekandLABEL(JCheckBox checkBox, JTextField textFields){
        checkBox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent i) {
                        if (i.getStateChange() == ItemEvent.SELECTED) {
                            textFields.setEditable(true);
                        } else if (i.getStateChange() == ItemEvent.DESELECTED) {
                            textFields.setEditable(false);
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
                        if(nameofit=="sw"||nameofit=="lw"||nameofit=="addi"||nameofit=="slli"||nameofit=="beq"||nameofit=="lb"
                                ||nameofit=="lbu"||nameofit=="sb"||nameofit=="j"||nameofit=="jal"||nameofit=="sll"){
                            textField1.setEditable(true);
                        }
                        else {
                            textField1.setEditable(false);
                        }
                    }
                }
        );
        

    }
    private void I_type(JComboBox Typeofinstruction,JComboBox turnoff,JLabel elqus1,JLabel elqus2,JLabel elcouma3, JTextField addressorOffset){

        Typeofinstruction.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                String test=Typeofinstruction.getSelectedItem().toString();
                if(test=="addi"||test=="lw"||test=="sw"||test=="slti"||test=="beq"||test=="lb"||test=="lbu"||test=="sb"){
                    turnoff.setEnabled(false);
                    elcouma3.setVisible(false);
                    if (test=="sw"||test=="lw"||test=="lb"||test=="lbu"||test=="sb"){
                    elqus1.setVisible(true);
                    elqus2.setVisible(true);

                    addressorOffset.setBorder(BorderFactory.createTitledBorder("Offset"));
                    }
                    else if (test=="beq") {
                        addressorOffset.setBorder(BorderFactory.createTitledBorder("To label"));
                        elqus1.setVisible(false);
                        elqus2.setVisible(false);
                    }
                    else if (test=="addi"||test=="slti"){
                        addressorOffset.setBorder(BorderFactory.createTitledBorder("Number"));
                        elqus1.setVisible(false);
                        elqus2.setVisible(false);
                    }

                }


            }
        });
    }
    private void J_type(JComboBox TypeofInstruction,JComboBox turnoff1,JComboBox turnoff2,JComboBox turnoff3,JTextField address){

            TypeofInstruction.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent itemEvent) {
                    String test=TypeofInstruction.getSelectedItem().toString();
                    if(test=="j"||test=="jal"){
                    turnoff1.setEnabled(false);
                    turnoff2.setEnabled(false);
                    turnoff3.setEnabled(false);
                    address.setBorder(BorderFactory.createTitledBorder("To label"));
                    }

                }
            });

    }
    private  void R_type(JComboBox TypeofInstruction,JComboBox turnoff1,JComboBox turnoff2,JComboBox turnoff3,JLabel elqus1,JLabel elqus2,JTextField address){
        TypeofInstruction.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                String test=TypeofInstruction.getSelectedItem().toString();
                if (test=="add"|| test=="nor"|| test=="slt"){
                    turnoff1.setEnabled(true);
                    turnoff2.setEnabled(true);
                    turnoff3.setEnabled(true);
                    elqus1.setVisible(false);
                    elqus2.setVisible(false);

                }
                else if (test=="jr"){
                    turnoff1.setEnabled(true);
                    turnoff2.setEnabled(false);
                    turnoff3.setEnabled(false);
                    elqus1.setVisible(false);
                    elqus2.setVisible(false);
                }
                else if (test=="sll"){
                    turnoff1.setEnabled(true);
                    turnoff2.setEnabled(true);
                    turnoff3.setEnabled(false);
                    elqus1.setVisible(false);
                    elqus2.setVisible(false);
                    address.setBorder(BorderFactory.createTitledBorder("Shamt"));
                }
            }
        });
    }
   private ArrayList<String> sorting(ArrayList<String> result69){
        int x=0;
        int index=0;
        String saver69;
        char[] mychar=new char[100];

        for (int i = 0; i <result69.size() ; i++) {
            for (int j = 0; j <result69.get(i).toCharArray().length ; j++) {
                if(result69.get(i).toCharArray()[j]==';'){
                    x=j+1;
                }

            }
               // mychar= remove_one_character_from_a_character_array_in_java(result69.get(i).toCharArray(),x);
                  mychar=java.util.Arrays.copyOfRange(result69.get(i).toCharArray(),x,result69.get(i).toCharArray().length);

            saver69=String.copyValueOf(mychar);
            finalresult.add(i,saver69);
        }
        this.a=new ArrayList<>(finalresult);
        System.out.println(a);

        //System.out.println(finalresult.toString());
return finalresult;
    }
    public ArrayList<String> GetArraylist(){
        return finalresult;
    }


}
