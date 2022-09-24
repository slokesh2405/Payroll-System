import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class myframe1 implements ActionListener{

   public JFrame frame1;
   private JLabel label;
   private JLabel label1;
   private JButton fetch;
   private JButton insert;
   private JButton emplsec;
   private JButton clear;
   private JTable table;
   private DefaultTableModel model;
   private JScrollPane jp;
   private JSeparator sep;
   private JLabel name;
   private JButton close_session;
   


    public myframe1() {
    frame1=new JFrame();
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setBounds(100,150,1000,800);
    frame1.setTitle("MyFrame1");
    frame1.setLayout(null);
    frame1.setResizable(false);  // user can't resize the frame
    
    ImageIcon icon = new ImageIcon("src\\pexels-photo-531880.jpeg");
    label = new JLabel(icon);
    label.setSize(1000, 1000);
    frame1.add(label);


    label1=new JLabel("PAYROLL SECTION");
    Font font = new Font("Arial",Font.BOLD,30);
    label1.setFont(font);
    label1.setBounds(20,20, 300, 50);
    label1.setForeground(Color.GREEN);
    sep=new JSeparator(SwingConstants.HORIZONTAL);
    sep.setBounds(20,60,284,40);
    label.add(sep);
    label.add(label1);

    Font fontn=new Font("Segoe UI Bold",Font.BOLD,12);
    name=new JLabel("ALTERNATE pvt. ltd.");
    name.setBounds(20,30,300,80);
    name.setForeground(Color.WHITE);
    name.setFont(fontn);
    label.add(name);

  
    Font fontb = new Font("Segoe UI Bold",Font.BOLD,20);
    fetch=new JButton("Fetch Data");
    fetch.setBounds(50,200,150,50);
    fetch.setFont(fontb);
    fetch.setForeground(Color.DARK_GRAY);
    label.add(fetch);
    fetch.addActionListener(this);

    insert=new JButton("Insert data");
    insert.setBounds(280,200,150,50);
    insert.setFont(fontb);
    insert.setForeground(Color.DARK_GRAY);
    label.add(insert);
    insert.addActionListener(this);

    emplsec=new JButton("Employee Section");
    emplsec.setBounds(500,200,300,50);
    emplsec.setFont(fontb);
    emplsec.setForeground(Color.DARK_GRAY);
    label.add(emplsec);
    emplsec.addActionListener(this);

    clear=new JButton("Clear");
    clear.setBounds(850,200,100,50);
    clear.setFont(fontb);
    clear.setForeground(Color.DARK_GRAY);
    label.add(clear);
    clear.addActionListener(this);

    close_session=new JButton("Close Session");
    close_session.setBounds(750,20,200,50);
    close_session.setFont(fontb);
    close_session.setForeground(Color.DARK_GRAY);
    label.add(close_session);
    close_session.addActionListener(this);


    
    Object[] columnName={"Emp ID","Emp Name","Emp Designation", "Emp Salary","Emp PF","Emp Net Salary"};
    Object[][] data={};
    model= new DefaultTableModel(data,columnName);
    table=new JTable(model);
    
    jp=new JScrollPane(table);
    jp.setVisible(true);
    jp.setBounds(20, 300, 950, 400);
    table.setFont(new Font("Arial",Font.PLAIN,14));
    label.add(jp);
    

    frame1.setVisible(true);
}

  public static void main(String args[]){
    myframe1 f1 = new myframe1();
  }

   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fetch){

          try{
            Class.forName("java.sql.Driver");  // here we load the driver's class file at runtime
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mycorp","root","password");  // to establish a connection
            Statement stmt=con.createStatement();  // create statement to recieve data from database
            String query="select * from empl;";  // sql query
            ResultSet rs=stmt.executeQuery(query); // executeQuery() executes the queries and returns the object of resultset 
            while(rs.next()){
                String empid=rs.getString("EMP_ID");
                String empname=rs.getString("EMP_NAME");
                String empdesignation=rs.getString("EMP_DESIGNATION");
                String empsalary=rs.getString("EMP_SALARY");
                String emppf=rs.getString("EMP_PF");
                String empnetsalary=rs.getString("EMP_NET_SALARY");
                model.addRow(new Object[] {empid,empname,empdesignation,empsalary,emppf,empnetsalary});
            }   
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception c){
            JOptionPane.showMessageDialog(null,c);
        }     

    }

        if(e.getSource() == insert){
          new myframe2();
          frame1.dispose();
            
        }

        if(e.getSource() == emplsec){
          new myframe3();
          frame1.dispose();

            
        }

        if(e.getSource() == clear){
          model.setRowCount(0);  
            
        }

        if(e.getSource() == close_session){
          System.exit(0);
        }
      
      }

  



 
}