import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myframe2 implements ActionListener{
    
    private JFrame frame2;
    private JLabel label;
    private JLabel label1;
    private JTextField text1;
    private JPanel panel;
    private JLabel label2;
    private JTextField text2;
    private JLabel label3;
    private JComboBox cb;
    private JButton clear;
    private JLabel label4;
    private JTextField text3;
    private JLabel label5;
    private JTextField text4;
    private JLabel label6;
    private JTextField text5;
    private JButton insert;
    private JButton home;
    private JLabel head;


    public myframe2(){
    frame2=new JFrame();
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setBounds(100,150,1000,800);
    frame2.setTitle("MyFrame2");
    frame2.setLayout(null);
    frame2.setResizable(false);  // user can't resize the frame
    
    ImageIcon icon = new ImageIcon("src\\pexels-photo-531880.jpeg");
    label = new JLabel(icon);
    label.setSize(1000, 1000);
    frame2.add(label);

    panel=new JPanel();
    panel.setBounds(80, 100, 830, 450);
    panel.setLayout(null);
    label.add(panel);

    label1=new JLabel("Employee ID");
    label1.setBounds(200,80,200,40);
    Font font=new Font("Arial",Font.BOLD,17);
    label1.setFont(font);
    label1.setForeground(Color.darkGray);
    panel.add(label1);

    text1=new JTextField();
    text1.setBounds(400,80,200,30);
    text1.setFont(font);
    panel.add(text1);

    label2=new JLabel("Employee Name");
    label2.setBounds(200,120,200,40);
    label2.setFont(font);
    label2.setForeground(Color.darkGray);
    panel.add(label2);

    text2=new JTextField();
    text2.setBounds(400,120,200,30);
    text2.setFont(font);
    panel.add(text2);

    label3=new JLabel("Employee Designation");
    label3.setBounds(200,160,200,40);
    label3.setFont(font);
    label3.setForeground(Color.darkGray);
    panel.add(label3);

    String[] values={"CEO","CFO","Junior Developer","Senior Developer","Project Manager","Program Analyst","System Analyst","Software Engineer","Trainee Engineer","Testing Officer","Receptionalist"};
    cb= new JComboBox(values);
    cb.setBounds(400,160,200,30);
    panel.add(cb);

    clear = new JButton("Clear");
    clear.setBounds(650,160,70,30);
    panel.add(clear);
    clear.addActionListener(this);
    
    label4=new JLabel("Employee Salary");
    label4.setBounds(200,200,200,40);
    label4.setFont(font);
    label4.setForeground(Color.darkGray);
    panel.add(label4);

    text3=new JTextField();
    text3.setBounds(400,200,200,30);
    text3.setFont(font);
    panel.add(text3);

    label5=new JLabel("Employee PF");
    label5.setBounds(200,240,200,40);
    label5.setFont(font);
    label5.setForeground(Color.darkGray);
    panel.add(label5);

    text4=new JTextField();
    text4.setBounds(400,240,200,30);
    text4.setFont(font);
    panel.add(text4);


    label6=new JLabel("Employee Net Salary");
    label6.setBounds(200,280,200,40);
    label6.setFont(font);
    label6.setForeground(Color.darkGray);
    panel.add(label6);

    text5=new JTextField();
    text5.setBounds(400,280,200,30);
    text5.setFont(font);
    panel.add(text5);

    insert=new JButton("Insert");
    insert.setBounds(330,340,70,40);
    panel.add(insert);
    insert.addActionListener(this);

    home=new JButton("Home");
    home.setBounds(430,340,70,40);
    panel.add(home);
    home.addActionListener(this);

    head=new JLabel("Insert-Data");
    head.setBounds(340,10,200,50);
    Font head_font=new Font("Segoe UI Bold",Font.BOLD,26);
    head.setFont(head_font);
    head.setForeground(Color.GRAY);
    panel.add(head);

    
    frame2.setVisible(true);

}

public static void main(String args[]){
    myframe2 f2 = new myframe2();
  }

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == clear){
      text1.setText("");
      text2.setText("");
      cb.setSelectedItem(null);
      text3.setText("");
      text4.setText("");
      text5.setText("");  

      }

    if(e.getSource()==insert){

      String empname=" ";
      String designation=" ";
      int id,index;
      double salary=0.0,netsalary=0.0,pf=0.0;
      id=Integer.parseInt(text1.getText());         
      empname=text2.getText();
      {
      index=cb.getSelectedIndex();
      if(index==0){
                   designation=(String) cb.getItemAt(index);
                   salary = 70000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==1){
                   designation=(String) cb.getItemAt(index);
                   salary =65000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==2){
                   designation=(String) cb.getItemAt(index);
                   salary = 30000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==3){
                   designation=(String) cb.getItemAt(index);
                   salary = 40000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==4){
                   designation=(String) cb.getItemAt(index);
                   salary = 42000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==5){
                   designation=(String) cb.getItemAt(index);
                   salary = 20000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==6){
                   designation=(String) cb.getItemAt(index);
                   salary = 45000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==7){
                   designation=(String) cb.getItemAt(index);
                   salary = 48000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==8){
                   designation=(String) cb.getItemAt(index);
                   salary = 40000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==9){
                   designation=(String) cb.getItemAt(index);
                   salary = 35000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      else if(index==10){
                   designation=(String) cb.getItemAt(index);
                   salary = 52000.00;
                   pf = salary*0.12;
                   netsalary = salary-pf;
                  }
      }
      
      try{
          
          Class.forName("java.sql.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mycorp","root","password");
          Statement stmt=con.createStatement();
          String query="insert into empl values('"+id+"','"+empname+"','"+designation+"','"+salary+"','"+pf+"','"+netsalary+"');";
          stmt.executeUpdate(query);
         
          text3.setText(""+salary);
          text4.setText(""+pf);
          text5.setText(""+netsalary);
          JOptionPane.showMessageDialog(null,"Successfully Inserted!");
      }
      catch
          (Exception w){
                       JOptionPane.showMessageDialog(null,"Employee ID already exist!");
                       }
      


    }

    if(e.getSource() == home){

      new myframe1();
      frame2.dispose();
    }
    
    
}


}
