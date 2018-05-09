package GUI7;

import Blocks.Data_Mem;
import Blocks.RegisterFile;
import Stages.Execute;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class OutputScreen extends JFrame {
    private JTextPane screen;
    private SimpleAttributeSet attributeSet;
    private JScrollPane scrollPane;

    public OutputScreen(){
        screen=new JTextPane();
        attributeSet=new SimpleAttributeSet();
        this.setResizable(false);
        this.setBounds(600,300,600,600);
        this.setDefaultCloseOperation(3);
        StyleConstants.setBold(attributeSet,true);
        StyleConstants.setFontSize(attributeSet,25);
        StyleConstants.setFontFamily(attributeSet,Font.SANS_SERIF);
        screen.setBackground(Color.BLACK);
        screen.setEditable(false);
        screen.setCharacterAttributes(attributeSet,true);
        screen.setForeground(new Color(0,255,255));
        screen.setText("Data Memory:"+"\n"+Data_Mem.memLocations.toString()+"\n"
                        +"================================================"+"\n"
        +"Register File: "+"\n"+RegisterFile.Register.toString()+"\n"
                +"================================================"+"\n"+
        "Clock Cycles Spanned = "+Execute.clockCycles+" Cycles"+"\n");
        scrollPane=new JScrollPane(screen,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);

    }
}
