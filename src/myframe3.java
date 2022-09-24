import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class myframe3  implements ActionListener{

    private JFrame frame3;
    private JLabel label;
    private JPanel panel;
    private JRadioButton ceo;
    private JRadioButton cfo;
    private JRadioButton jd;
    private JRadioButton sd;
    private JRadioButton pm;
    private JRadioButton se;
    private JRadioButton te;
    private JRadioButton pa;
    private JRadioButton sa;
    private JRadioButton to;
    private JRadioButton rec;
    private JLabel head;
    private JButton search;
    private JButton clear;
    private JButton home;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane jp;
    
    

    public myframe3(){
        frame3=new JFrame();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setBounds(100,150,1000,800);
        frame3.setTitle("MyFrame2");
        frame3.setLayout(null);
        frame3.setResizable(false);  // user can't resize the frame
        
        ImageIcon icon = new ImageIcon("src\\pexels-photo-531880.jpeg");
        label = new JLabel(icon);
        label.setSize(1000, 1000);
        frame3.add(label);

        
        panel=new JPanel();
        panel.setBounds(100, 50, 800, 260);
        panel.setLayout(null);
        label.add(panel);

        Font font = new Font("Arial",Font.BOLD,18);

        ceo=new JRadioButton("CEO");
        ceo.setBounds(50, 70, 200, 30);
        ceo.setFont(font);
        ceo.setForeground(Color.blue);
        panel.add(ceo);

        cfo=new JRadioButton("CFO");
        cfo.setBounds(50, 110,200, 30);
        cfo.setFont(font);
        cfo.setForeground(Color.blue);
        panel.add(cfo);

        jd=new JRadioButton("Junior Developer");
        jd.setBounds(50, 150, 200, 30);
        jd.setFont(font);
        jd.setForeground(Color.blue);
        panel.add(jd);

        sd=new JRadioButton("Senior Developer");
        sd.setBounds(50, 190, 200, 30);
        sd.setFont(font);
        sd.setForeground(Color.blue);
        panel.add(sd);


        pm=new JRadioButton("Project Manager");
        pm.setBounds(300, 70, 200, 30);
        pm.setFont(font);
        pm.setForeground(Color.blue);
        panel.add(pm);

        se=new JRadioButton("Software Engineer");
        se.setBounds(300, 110, 200, 30);
        se.setFont(font);
        se.setForeground(Color.blue);
        panel.add(se);

        te=new JRadioButton("Trainee Engineer");
        te.setBounds(300, 150, 200, 30);
        te.setFont(font);
        te.setForeground(Color.blue);
        panel.add(te);

        pa=new JRadioButton("Program Analyst");
        pa.setBounds(300, 190, 200, 30);
        pa.setFont(font);
        pa.setForeground(Color.blue);
        panel.add(pa);

        sa=new JRadioButton("System Analyst");
        sa.setBounds(550, 70, 200, 30);
        sa.setFont(font);
        sa.setForeground(Color.blue);
        panel.add(sa);

        to=new JRadioButton("Testing Officer");
        to.setBounds(550, 110, 200, 30);
        to.setFont(font);
        to.setForeground(Color.blue);
        panel.add(to);


        rec=new JRadioButton("Receptionalist");
        rec.setBounds(550, 150, 200, 30);
        rec.setFont(font);
        rec.setForeground(Color.blue);
        panel.add(rec);

        ButtonGroup des=new ButtonGroup();
        des.add(ceo);
        des.add(cfo);
        des.add(jd);
        des.add(sd);
        des.add(pm);
        des.add(se);
        des.add(te);
        des.add(pa);
        des.add(sa);
        des.add(to);
        des.add(rec);


        head=new JLabel("Designation-Filter");
        head.setBounds(300,6,200,50);
        Font head_font=new Font("Times New Roman",Font.BOLD,22);
        head.setFont(head_font);
        head.setForeground(Color.darkGray);
        panel.add(head);

        search=new JButton("Search");
        search.setBounds(250,340,100,50);
        search.setFont(font);
        label.add(search);
        search.addActionListener(this);
        
        clear=new JButton("Clear");
        clear.setBounds(450,340,100,50);
        clear.setFont(font);
        label.add(clear);
        clear.addActionListener(this);

        home=new JButton("Home");
        home.setBounds(650,340,100,50);
        home.setFont(font);
        label.add(home);
        home.addActionListener(this);

        Object[] columnName={"Emp ID","Emp Name","Emp Designation", "Emp Salary","Emp PF","Emp Net Salary"};
        Object[][] data={};
        model= new DefaultTableModel(data,columnName);
        table=new JTable(model);
    
        jp=new JScrollPane(table);
        jp.setVisible(true);
        jp.setBounds(20, 450, 950, 300);
        table.setFont(new Font("Arial",Font.PLAIN,14));
        label.add(jp);
    

        frame3.setVisible(true);


}


public static void main(String args[]){
    myframe3 f3=new myframe3();
}


@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == search){

        try{
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mycorp","root","password");
            Statement stmt=con.createStatement();
            String query="";
          
            {
            if(ceo.isSelected()){     
               query="select * from empl where EMP_DESIGNATION='CEO';";
                                          }
            else if(cfo.isSelected()){    
               query="select * from empl where EMP_DESIGNATION='CFO';";
                                               }
            else if(jd.isSelected()){
               query="select * from empl where EMP_DESIGNATION='Junior Developer';";
                                               }
            else if(sd.isSelected()){
               query="select * from empl where EMP_DESIGNATION='Senior Developer';";
                                               }
            else if(pm.isSelected()){
               query="select * from empl where EMP_DESIGNATION='Project Manager';";
                                               }
            else if(se.isSelected()){
               query="select * from empl where EMP_DESIGNATION='Software Engineer';";
                                               }
            else if(te.isSelected()){ 
               query="select * from empl where EMP_DESIGNATION='Trainee Engineer';";
                                               }
            else if(pa.isSelected()){
               query="select * from empl where EMP_DESIGNATION='Program Analyst';";
                                               }
            else if(sa.isSelected()){
               query="select * from empl where EMP_DESIGNATION='System Analyst';";
                                               }
            else if(to.isSelected()){
               query="select * from empl where EMP_DESIGNATION='Testing Officer';";
                                               }
            else if(rec.isSelected()){
               query="select * from empl where EMP_DESIGNATION='Receptionalist';";
                                               }
            }
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String empid=rs.getString("EMP_ID");
                String empname=rs.getString("EMP_NAME");
                String empdesination=rs.getString("EMP_DESIGNATION");
                String empsalary=rs.getString("EMP_SALARY");
                String emppf=rs.getString("EMP_PF");
                String empnetsalary=rs.getString("EMP_NET_SALARY");
                model.addRow(new Object[] {empid,empname,empdesination,empsalary,emppf,empnetsalary});
            }   
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception w){
            JOptionPane.showMessageDialog(null,"Searching Error!");
        }


    }

    if(e.getSource() == clear){

        ceo.setSelected(false);
        cfo.setSelected(false);
        jd.setSelected(false);
        sd.setSelected(false);
        pm.setSelected(false);
        se.setSelected(false);
        te.setSelected(false);
        pa.setSelected(false);
        sa.setSelected(false);
        to.setSelected(false);
        rec.setSelected(false);

        model.setRowCount(0);

    }

    if(e.getSource() == home){
        new myframe1();
        frame3.dispose();
    }
    
}

}
