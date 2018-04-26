package GUI7;
import Blocks.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DataMemory_Frame extends JFrame {
    private JPanel generatePnl;
    private JPanel memLocationsPnl;
    private JPanel bottomPnl;
    private JTextField numberOfLocations;
    private JButton reserve;
    private JButton next;
    private JTextField[] address;
    private JTextField[] value;
    private JLabel[] a;
    private JLabel[] v;
    private JScrollPane scrollPane;


    public DataMemory_Frame(){
        //init Jframe
        this.setDefaultCloseOperation(3);
        Dimension preferedSize=new Dimension(500,400);
        this.setPreferredSize(preferedSize);
        this.setBounds(700,400,500,400);
        this.setResizable(false);
        this.setTitle("Memory Locations Read");

        //init components
        generatePnl=new JPanel();
        memLocationsPnl=new JPanel();
        bottomPnl=new JPanel();
        numberOfLocations=new JTextField("0");
        next=new JButton("Next");
        Container c=this.getContentPane();
        numberOfLocations.setPreferredSize(new Dimension(70,30));
        reserve=new JButton("Reserve");
        this.add(generatePnl,BorderLayout.NORTH);
        this.add(memLocationsPnl,BorderLayout.CENTER);
        this.add(bottomPnl,BorderLayout.SOUTH);
        scrollPane=new JScrollPane(memLocationsPnl,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        c.add(scrollPane);
        //generate panel is the panel contains the generate btn and txt field containing number of locations
        generatePnl.setLayout(new FlowLayout());
        generatePnl.add(numberOfLocations);
        generatePnl.add(reserve);
        //Memory loc panel is the panel containing the addresses and values for the reserved locations

            reserve.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    address=new JTextField[Integer.parseInt(numberOfLocations.getText())];
                    value=new JTextField[Integer.parseInt(numberOfLocations.getText())];
                    a=new JLabel[Integer.parseInt(numberOfLocations.getText())];
                    v=new JLabel[Integer.parseInt(numberOfLocations.getText())];
                    memLocationsPnl.setLayout(null);
                    memLocationsPnl.setPreferredSize(new Dimension(memLocationsPnl.getWidth(),
                            memLocationsPnl.getHeight()+(100*Integer.parseInt(numberOfLocations.getText()))));
                    for(int i=0;i<Integer.parseInt(numberOfLocations.getText());i++){
                       address[i]=new JTextField();
                       address[i].setBounds(120,50+50*i,70,30);
                       value[i]=new JTextField();
                       value[i].setBounds(360,50+50*i,70,30);
                       memLocationsPnl.add(address[i]);
                       memLocationsPnl.add(value[i]);
                       a[i]=new JLabel("Address:");
                       a[i].setBounds(10,50+50*i,110,30);
                       memLocationsPnl.add(a[i]);
                       v[i]=new JLabel("Value:");
                       v[i].setBounds(240,50+50*i,70,30);
                       memLocationsPnl.add(v[i]);


                    }
                    c.repaint();
                    scrollPane.revalidate();



                }

            });


        //bottom panel contains a Btn that takes you to the next step
        bottomPnl.setLayout(new FlowLayout());
        bottomPnl.add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionCall f=new FunctionCall();
                f.setVisible(true);
                close();
                for(int i=0;i<Integer.parseInt(numberOfLocations.getText());i++){
                    int a=Integer.parseInt(address[i].getText());
                    int v=Integer.parseInt(value[i].getText());
                    Data_Mem.addLocation(a,v);
                }
                Data_Mem.printMem();//To be printed in the text area of the output frame



            }
        });







    }
    public void close(){
        this.dispose();
    }
}
