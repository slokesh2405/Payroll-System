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
import javax.swing.JPasswordField;
import javax.swing.JTextField;






public class myframe implements ActionListener{
   
    private JTextField text;
    private JPasswordField pwd;
    private JFrame frame;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JButton login;
    private JLabel logo;
    private JLabel name;
    private JLabel sub_name;
   
   
    
  
    public myframe(){
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,150,1100,600);
        frame.setTitle("MyFrame");
        frame.setLayout(null);
        frame.setResizable(false);  // user can't resize the frame
      
        
        ImageIcon icon = new ImageIcon("src\\black_background.jpg");
        label = new JLabel(icon);
        label.setSize(1100, 1000);
        frame.add(label);

        name=new JLabel("ALTERNATE");
        name.setBounds(200,30,300,80);
        Font fontn=new Font("Segoe UI Bold",Font.BOLD,40);
        name.setForeground(Color.GRAY);
        name.setFont(fontn);
        label.add(name);

        sub_name=new JLabel("software solutions");
        sub_name.setBounds(250,60,300,80);
        Font fontsn=new Font("Segoe UI Bold",Font.BOLD,14);
        sub_name.setForeground(Color.GREEN);
        sub_name.setFont(fontsn);
        label.add(sub_name);
    

        ImageIcon lIcon = new ImageIcon("src\\_logo.jpg");
        logo=new JLabel(lIcon);
        logo.setBounds(600,1,580,600);
        label.add(logo);
        
        

        label1=new JLabel("Enter Username ");
        label1.setBounds(100,150,300,50);
        Font font=new Font("Arial",Font.BOLD,25);
        label1.setFont(font);
        label1.setForeground(Color.WHITE);
        label.add(label1);

        text=new JTextField();
        text.setBounds(300,150,250,50);
        text.setFont(font);
        label.add(text);

        label2=new JLabel("Enter Password ");
        label2.setBounds(100,250,300,50);
        label2.setFont(font);
        label2.setForeground(Color.WHITE);
        label.add(label2);


        pwd=new JPasswordField();
        pwd.setBounds(300,250,250,50);
        pwd.setFont(font);
        label.add(pwd);

        login=new JButton("Log In");
        login.setBounds(300,350,120,50);
        login.setFont(font);
        login.setForeground(Color.DARK_GRAY);
        label.add(login);
        login.addActionListener(this);



        frame.setVisible(true);

        
    }
    public static void main(String args[]){
        myframe f=new myframe();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String admin=text.getText();
        String pass=new String(pwd.getPassword());
        String username="",password="";

        try{
            Class.forName("java.sql.Driver");  // here we load the driver's class file at runtime
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mycorp","root","password");  // to establish a connection
            Statement stmt=con.createStatement();  // create statement to recieve data from database
            String query="select username,password from cred;";  // sql query
            ResultSet rs=stmt.executeQuery(query); // executeQuery() executes the queries and returns the object of resultset 
            while(rs.next()){
                username=rs.getString("username");
                password=rs.getString("password");
                
            }   
           
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception c){
            JOptionPane.showMessageDialog(null,c);
        }  

        if(admin.equalsIgnoreCase(username) && pass.equals(password))
        {
           JOptionPane.showMessageDialog(null,"Welcome Admin!","Message",JOptionPane.PLAIN_MESSAGE);
           
          new myframe1();
          frame.dispose();
            
       }
   else
       {
           JOptionPane.showMessageDialog(null,"Username and Password does not match","Message",JOptionPane.PLAIN_MESSAGE);
       }
       
        
    }
}
