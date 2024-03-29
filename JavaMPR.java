
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.util.Arrays; 
public class Login extends JFrame implements ActionListener {   
  JFrame f1;  
  JLabel link;   
  JButton b;   
  JTextField t1,t2,t3; 
  JPasswordField t4;  
  JLabel l1,l2,l3,l4,res;  
  JCheckBox term;     
  Login(){        
    f1= new JFrame("Login");
    l1= new JLabel("First Name");
    l1.setBounds(20,20,100,20); 
    f1.add(l1);         
    t1=new JTextField();
    t1.setBounds(130,20,150,20); 
    f1.add(t1);           
    l2= new JLabel("Last Name"); 
    l2.setBounds(20,50,100,20);  
    f1.add(l2);        
    t2= new JTextField();
    t2.setBounds(130,50,100,20); 
    f1.add(t2);         
    l3= new JLabel("Email-id"); 
    l3.setBounds(20,80,140,20); 
    f1.add(l3);        
    t3= new JTextField();
    t3.setBounds(130,80,150,20); 
    f1.add(t3);           
    l4=new JLabel("Passsword");
    l4.setBounds(20,110,100,20);
    f1.add(l4);         
    t4= new JPasswordField();
    t4.setBounds(130,110,90,20);  
    f1.add(t4);         
    b = new JButton("SUBMIT"); 
    b.setBounds(50,250,100,20); 
    b.addActionListener(this);  
    f1.add(b);         
    res = new JLabel("Accept Terms And Conditions.");   
    res.setBounds(20,200,220,20);       
    f1.add(res);  
    term = new JCheckBox();    
    term.setBounds(230,200,20,20);
    f1.add(term);       
    term.addActionListener(this);    
    f1.setLayout(null);       
    f1.setSize(350,400);       
    f1.setLocationRelativeTo(null);   
    f1.setVisible(true);         
    f1.getContentPane().setBackground(Color.pink);   
    f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);     }  
  
  public void actionPerformed(ActionEvent e)     { 
    if(e.getSource()==b)         
    {             
      if(term.isSelected()) {
        String f_name = "First Name:" + t1.getText() + "\n";  
        String l_name = "Last Name:" + t2.getText() + "\n";   
        String email = "email-id: " + t3.getText() + "\n";    
        String password = "password:" + Arrays.toString(t4.getPassword()) + "\n";       
        JOptionPane.showMessageDialog(f1, "All your entered data will be successfully stored in system maintaining your privacy." + "We assure you that your information will be kept confidential");  
        try { 
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareek", "root", "Esha19"); 
          PreparedStatement ps = connection.prepareStatement("insert into login values(?,?,?,?)");                    
          ps.setString(1, f_name);                 
          ps.setString(2, l_name);                
          ps.setString(3, email);              
          ps.setString(4, password);           
          int x = 0;                 
          x++;   
          if (x > 0) {    
            ps.executeUpdate();   
            JOptionPane.showMessageDialog(b, "Data Saved Successfully");                       
            
            //2 PAGE                     
            
            SignIn j = new SignIn();      
            j.setVisible(true);                   
          }                 
        } catch (Exception ex)
          {                   
            System.out.println(ex);   
          }            
      }           
      else         
      {          
        res.setText("Please accept the terms & conditions");     
      }      
    }    
  }    
  public static void main(String[] args)     {   
    new Login();   
  }
}









import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.*; 
import java.util.Arrays;
public class SignIn extends JFrame implements ActionListener { 
  JFrame f2;  
  JLabel l1,l2;   
  JTextField t1;   
  JPasswordField t2; 
  JButton b;    
  SignIn()   
  {         
    f2= new JFrame("Sign Up");    
    l1= new JLabel("Enter your Email ID"); 
    l1.setBounds(30,30,150,50);       
    f2.add(l1);      
    t1= new JTextField();    
    t1.setBounds(200,40,80,30);   
    f2.add(t1);       
    l2= new JLabel("Enter your Password");   
    l2.setBounds(30,110,150,50);     
    f2.add(l2);       
    t2= new JPasswordField();  
    t2.setBounds(200,120,100,30);    
    b= new JButton("Next");      
    b.setBounds(200,250,80,30); 
    f2.add(b);     
    b.addActionListener(this);   
    f2.add(t2);    
    f2.setLayout(null);   
    f2.setSize(350,400);    
    f2.setVisible(true);    
    f2.setLocationRelativeTo(null);    
    f2.getContentPane().setBackground(Color.pink);   
    f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);   
  }     
  public void actionPerformed(ActionEvent e)     {     
    String email="email-id: " +t1.getText() +"\n";   
    String password= "password:" + Arrays.toString(t2.getPassword()) +"\n";   
    try {          
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareek","root","Esha19");    
      PreparedStatement st = connection.prepareStatement("Select email_id, password from login where email_id=? and password=?");      
      st.setString(1, email);      
      st.setString(2, password);     
      ResultSet rs = st.executeQuery();       
      if (rs.next()) {              
        JOptionPane.showMessageDialog(b, "You have successfully logged in");    
        Page11 j= new Page11();        
        j.setvisible(true);       
      } 
      else 
      {       
        JOptionPane.showMessageDialog(b, "Wrong Username & Password"); 
      }    
    } 
    catch (SQLException sqlException) {    
      sqlException.printStackTrace();  
    }        
  }    
  public static void main(String[] args)     {      
    new SignIn();    
  }
}







import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;  
public class Page11 extends JFrame implements ActionListener {   
  JRadioButton rb1,rb2,rb3,rb4,rb5;  
  JButton b1;    
  JFrame f1;  
  ButtonGroup bg;   
  Page11()    
  {        
    f1=new JFrame("TAREEKH FORM"); 
    rb1 = new JRadioButton("Track my cycle");     
    rb2 = new JRadioButton("Track Pregnancy");   
    rb3 = new JRadioButton("Diet recommendation during menstruation");     
    rb4= new JRadioButton("Diet recommendation in PCOD/PCOS");     
    rb5= new JRadioButton("Exercise/Yoga recommendation");      
    b1=new JButton("next");  
    bg= new ButtonGroup();  
    rb1.setBounds(20,30,270,30);     
    rb2.setBounds(20,90,270,30);
    rb3.setBounds(20,150,270,30); 
    rb4.setBounds(20,210,270,30);  
    rb5.setBounds(20,270,270,30);   
    b1.setBounds(100,320,75,30);    
    f1.add(rb3);   
    f1.add(rb4);    
    f1.add(rb5);      
    f1.add(rb1);      
    f1.add(rb2);    
    f1.add(b1);     
    bg.add(rb1);    
    bg.add(rb2);    
    b1.addActionListener(this);    
    rb2.addActionListener(this);   
    rb3.addActionListener(this);   
    rb4.addActionListener(this);   
    rb5.addActionListener(this);    
    f1.setSize(350,400);       
    f1.setLayout(null);       
    f1.setVisible(true);      
    f1.setLocationRelativeTo(null);   
    f1.getContentPane().setBackground(Color.pink);    
    f1.setDefaultCloseOperation(EXIT_ON_CLOSE);    
  }     
  public void actionPerformed(ActionEvent e) {   
    if (e.getSource() == rb2) {      
      JOptionPane.showMessageDialog(f1, "update will be soon available");       
    }      
    if (e.getSource() == rb3) {        
      Diet1 d=new Diet1();       
      d.setvisible(true);      
    }        
    if (e.getSource() == rb4) {       
      Diet d2=new Diet();        
      d2.setvisible(true);       
    }        
    if (e.getSource() == rb5) {      
      Exercise e1=new Exercise();   
      e1.setvisible(true);    
    }       
    else if (e.getSource() == b1) {      
      Page2 j = new Page2();      
      j.setvisible(true);     
    }    
  }     
  
  public static void main(String[] args)   
  {         
    new Page11(); 
  }     
  public void setvisible(boolean b) {     } }












import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
public class Page2 extends JFrame implements ActionListener {   
  JLabel l1,l2;  
  JTextField tx1;  
  JComboBox cb1,cb2;
  JButton b1,b2;   
  JTextArea area;   
  Page2()     
  {         
    JFrame f2=new JFrame("TARIKH FORM");      
    l1=new JLabel("How many days does your CYCLE last on average?");  
    l2=new JLabel("How long does you PERIODS usually last?");         
    tx1=new JTextField();       
    String days[]={"28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","more than 45(plss visit doctor)"};   
    cb1 = new JComboBox(days);     
    cb1.setBounds(330,25,40,30);    
    f2.add(cb1);      
    String day[]={"1","2","3","4","5","6","7"};        
    cb2 = new JComboBox(day);     
    cb2.setBounds(330,75,40,30);        
    f2.add(cb2);   
    b1=new JButton("next");   
    b2=new JButton("submit");      
    area=new JTextArea();       
    l1.setBounds(20,20,350,30);     
    l2.setBounds(20,70,350,30);    
    b1.setBounds(140,180,80,30);      
    b2.setBounds(280,260,95,30);     
    area.setBounds(30,320,320,100);     
    f2.add(l1);
    f2.add(l2); 
    f2.add(b1);    
    f2.add(b2);     
    f2.add(area);   
    b1.addActionListener(this);   
    b2.addActionListener(this);   
    f2.setSize(400,500);      
    f2.setLayout(null);     
    f2.setVisible(true);    
    f2.getContentPane().setBackground(Color.pink);    
    f2.setDefaultCloseOperation(EXIT_ON_CLOSE);      
  }      
  public void actionPerformed(ActionEvent e)     {  
    if(e.getSource()==b1) {   
      String cycle = cb2.getItemAt(cb2.getSelectedIndex()).toString();    
      String days = cb1.getItemAt(cb1.getSelectedIndex()).toString();   
      area.setText("how long does your period usually last:" + cycle + "\n" + "how long cycle is:" + days + "\n");   
      try {              
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareek", "root", "Esha19");    
        PreparedStatement ps = connection.prepareStatement("insert into info values(?,?)");      
        ps.setString(1, cycle);     
        ps.setString(2, days);     
        int x = 0;             
        x++;          
        if (x > 0) {           
          ps.executeUpdate();    
          JOptionPane.showMessageDialog(b1, "Data Saved Successfully");      
        }           
      } 
      catch (Exception ex) {      
        System.out.println(ex);  
      }   
    }    
    if(e.getSource()==b2){         
      Page3 j= new Page3();         
      j.setvisible(true);      
    }     
  }    
  public static void main(String[] args)     {       
    new Page2();      }    
  public void setvisible(boolean b) {     } }






import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class Page3 extends JFrame implements ActionListener {  
  JLabel l1;   
  JRadioButton rb1,rb2,rb3,rb4;   
  JButton b; 
  JTextArea area;   
  Page3()  
  {     
    JFrame f3=new JFrame("TARIKH FORM");   
    JLabel l1;   
    JButton b;  
    JRadioButton rb1,rb2,rb3,rb4;
    l1=new JLabel("IS YOUR CYCLE REGULAR?");    
    rb1=new JRadioButton("It varies by fewer than 5 days[regular cycle]");  
    rb2=new JRadioButton("5-15 days[irregular cycle]");   
    rb3=new JRadioButton("It varies by more than 15 days[very irregular cycle]");    
    rb4=new JRadioButton("I don't know");     
    ButtonGroup bg= new ButtonGroup();      
    b=new JButton("done");      
    l1.setBounds(20,20,300,30);      
    rb1.setBounds(20,100,300,30);    
    rb2.setBounds(20,130,300,30);    
    rb3.setBounds(20,160,350,30);     
    rb4.setBounds(20,190,200,30);       
    b.setBounds(60,280,75,20);         
    f3.add(l1);       
    bg.add(rb1);    
    bg.add(rb2);     
    bg.add(rb4);     
    bg.add(rb3);     
    f3.add(rb1);     
    f3.add(rb2);     
    f3.add(rb3);     
    f3.add(rb4);     
    f3.add(b);       
    f3.setSize(350,400);      
    f3.setLayout(null);     
    f3.setVisible(true);     
    f3.getContentPane().setBackground(Color.pink);
    f3.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    b.addActionListener(this);     
  }    
  public void actionPerformed(ActionEvent e)   
  {             Page4 j= new Page4();      
   j.setvisible(true);    
  }      
  public static void main(String[] args)     {    
    new Page3();    
  }    
  public void setvisible(boolean b)     { } }






import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.sql.*;  
public class Page4 extends JFrame implements ActionListener { 
  JLabel l1,l2;     
  JComboBox cb1,cb2; 
  JButton b1,b2;     
  JTextArea area;      
  Page4() {     
    JFrame f4 = new JFrame("TARIKH FORM");      
    l1 = new JLabel("LAST PERIOD DATE");     
    l2 = new JLabel("LAST PERIOD MONTH");  
    String days[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28", "29", "30", "31"};
    cb1 = new JComboBox(days);      
    String month[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};   
    cb2 = new JComboBox(month); 
    b1 = new JButton("show");
    b2 = new JButton("submit");   
    area = new JTextArea();     
    area.setEditable(false);    
    l1.setBounds(20, 20, 150, 30);   
    l2.setBounds(20, 60, 150, 30);   
    cb1.setBounds(200, 20, 80, 30);  
    cb2.setBounds(200, 60, 100, 30);   
    b1.setBounds(140, 120, 75, 20);    
    b2.setBounds(200, 320, 75, 20);    
    area.setBounds(30, 170, 320, 100);      
    f4.add(l1);       
    f4.add(cb1);      
    f4.add(cb2);     
    f4.add(b1);      
    f4.add(l2);      
    f4.add(b2);      
    f4.add(area);      
    b1.addActionListener(this);     
    b2.addActionListener(this);    
    f4.setSize(400, 500);      
    f4.setLayout(null);       
    f4.setVisible(true);     
    f4.setLocationRelativeTo(null);   
    f4.getContentPane().setBackground(Color.pink);   
    f4.setDefaultCloseOperation(EXIT_ON_CLOSE);     
  }      
  public void actionPerformed(ActionEvent e)     
  {      
    if (e.getSource() == b1)      
    {             
      String p_day = cb1.getItemAt(cb1.getSelectedIndex()).toString();     
      String month = cb2.getItemAt(cb2.getSelectedIndex()).toString();       
      area.setText("\n" + "Your last period date:" + p_day + "\n" + "period month:" + month + "\n"); 
      try            
        {            
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareek", "root", "Esha19");   
          PreparedStatement ps = connection.prepareStatement("insert into pdata values(?,?)");   
          ps.setString(1, p_day);    
          ps.setString(2, month);        
          int x = 0;      
          x++;            
          if (x > 0) {             
            ps.executeUpdate();            
            JOptionPane.showMessageDialog(b1, "Data Saved Successfully");      
          }            
        }          
      catch (Exception ex) { 
        System.out.println(ex); 
      }        
    }        
    else if(e.getSource() == b2)       
    {            
      Page5 j= new Page5();  
     j.setVisible(true);     
    }    
  }      
  public static void main(String[] args) {         
    new Page4();   
  }    
  public void setvisible(boolean b){} }





import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;  
public class Page5 extends JFrame implements ActionListener {
  JLabel l1,l2;   
  private  JLabel hyperlink= new JLabel("VISIT OUR WEBSITE");  
  Calendar calendar; 
  JButton b1, b2;  
  JTextArea area1;  
  Page5() {      
    JFrame f5 = new JFrame("TARIKH FORM");  
    f5.setSize(400, 500);       
    f5.setLayout(null);       
    f5.setVisible(true);       
    hyperlink.setForeground(Color.BLUE.darker());  
    hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    hyperlink.addMouseListener(new MouseAdapter() {     
      @Override          
      public void mouseClicked(MouseEvent e) {        
        try {                   
          Desktop.getDesktop().browse(new URI("http://www.sitemodify.com/preview/c0be576d"));     
        } 
        catch (IOException | URISyntaxException e1) {          
          e1.printStackTrace();      
        }      
      }    
      @Override    
      public void mouseExited(MouseEvent e) {       
        hyperlink.setText("VISIT US");      
      }          
      @Override   
      public void mouseEntered(MouseEvent e) {        
        hyperlink.setText("<html><a href=''>" + "VISIT US" + "</a></html>");    
      }     
    }); 
    l1 = new JLabel("Click submit to get next prediction");       
    area1 = new JTextArea();      
    area1.setEditable(false);     
    area1.setLineWrap(true);          
    l2 = new JLabel("CONTACT US");      
    l2.setBounds(60, 250, 150, 40);       
    f5.add(l2);   
    b2 = new JButton("submit");  
    b2.setBounds(150, 200, 75, 20);
    l1.setBounds(60, 30, 300, 30);      
    hyperlink.setBounds(140, 400, 90, 40);   
    area1.setBounds(50, 90, 300, 50);        
    f5.add(l1);      
    f5.add(hyperlink);  
    f5.add(b2);    
    f5.add(area1);    
    b2.addActionListener(this);     
    f5.setLayout(null);    
    f5.setSize(400,500);    
    f5.setVisible(true);    
    f5.setLocationRelativeTo(null);    
    f5.getContentPane().setBackground(Color.pink);    
    f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);   
  }    
  public void actionPerformed(ActionEvent e) {   
    String Calendar;     
    if (e.getSource() == b2) {   
      {             
        Calendar calendar = java.util.Calendar.getInstance();     
        calendar.add(java.util.Calendar.DATE, +28);        
        System.out.println("28 days hence: " + calendar.getTime());       
        area1.setText("\n" + "YOUR NEXT PERIODS WILL BE ON" +  calendar.getTime()+ "\n");    
      }    
    }   
  }   
  public static void main(String[] args) {      
    new Page5();   
  } }









import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Diet extends JFrame implements ActionListener {  
  JTextArea l1, l2, l3, l4, l5;   
  JButton b1;  
  Diet() {    
    JFrame f6 = new JFrame("TARIKH DIET RECOMMENDATION IN PCOD/PCOS");     
    f6.setSize(400, 500);  
    f6.setLayout(null);   
    f6.setVisible(true);      
    f6.getContentPane().setBackground(Color.pink);    
    l1 = new JTextArea("Choose High Quality, High Fiber Carbohydrates .Women with PCOS are more likely to be diagnosed with type 2 diabetes than women who do not have PCOS. Similar to a diabetic diet, it is important for women with PCOS to consume high quality, high fiber carbohydrates. This will aid in stabilizing your blood sugar levels.");    
    l2 = new JTextArea("Eat a Balanced Diet Consuming a well balanced PCOS Diet will help to keep your body in a neutral, homeostatic state. A balanced PCOS Diet allows insulin to function properly by bringing glucose to your cells for energy. This process results in less insulin in your bloodstream, ultimately decreasing androgen production and alleviating your PCOS symptoms.");       
    l3 = new JTextArea("Do not skip meals. Skipping meals can crash your blood sugar levels,leading to food cravings and overindulgence. Keeping a routine will allow your sugar levels to stabilize. Stable blood sugar aids in the proper androgen production in your body. Proper androgen production = less severe PCOS symptoms. Some doctors recommendeating smaller, more frequent meals to better regulate blood sugar and establish better habits.");    
    l4 = new JTextArea("Studies show consuming foods high in Vitamin D, Vitamin B, Iodine, Selenium, and Magnesium will greatly aid in improving insulin resistance,and decrease the severity of symptoms associated with PCOS.");         l5 = new JTextArea("Tuna, almonds, eggplant, strawberries, corn, oranges, beans ,Iodine,salmon, eggs, mushrooms, fortified milk, turkey breast, himalayan salt, salmon, yogurt");           b1 = new JButton("okay");     
    l1.setBounds(20, 20, 400, 120);        
    l2.setBounds(20, 170, 400, 120);      
    l3.setBounds(20, 320, 400, 120);     
    l4.setBounds(20, 470, 400, 120);    
    l1.setLineWrap(true);       
    l2.setLineWrap(true);     
    l3.setLineWrap(true);     
    l4.setLineWrap(true);     
    l5.setLineWrap(true);    
    l5.setBounds(20, 620, 400, 150);    
    b1.setBounds(140, 810, 75, 30);     
    f6.add(l1);    
    f6.add(l2);   
    f6.add(l3);   
    f6.add(l4);      
    f6.add(l5);      
    f6.add(b1);     
    b1.addActionListener(this);  
    f6.setSize(500,900);  
    f6.setVisible(true);   
    f6.getContentPane().setBackground(Color.pink);      
    f6.setLocationRelativeTo(null);     
    f6.setDefaultCloseOperation(EXIT_ON_CLOSE);     
  }   
  public void actionPerformed(ActionEvent e) { 
    if (e.getSource() == b1) {
      
    }   
  }       
  public static void main(String[] args)         {      
    new Diet();      
  }    
  public void setvisible(boolean b) {     } }



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
public class Diet1 extends JFrame implements ActionListener {
  JTextArea l1, l2, l3, l4, l5;  
  JButton b1;  
  Diet1() {      
    JFrame f5 = new JFrame("TARIKH DIET RECOMMENDATION DURING MENSTRUATION");
    l1 = new JTextArea("consume leafy green vegetable,bananas,yogurt It’s common to experience a dip in your iron levels during your period,particularly if your menstrual flow is heavy. This can lead to fatigue, bodily pain, and dizziness.Leafy green vegetables such as kale and spinach can boost your iron levels. Spinach is also rich in magnesium.");   
    l2 = new JTextArea("Dark chocolate");     
    l3 = new JTextArea("consume Iron,vitamin B12,magnesium,zinc,calcium,omega 3 Fatty acid ,fibre for eg  nuts,pumpkin seeds,grains,beans,channa,fish,flaxseed,etc");  
    l4 = new JTextArea("water-rich fruits, such as watermelon and cucumber, are great for staying hydrated.Sweet fruits can help you curb your sugar cravings without eating a lot of refined sugars,which can cause your glucose levels to spike and then crash.");  
    l5 = new JTextArea("A warm mug of ginger tea can improve certain symptoms of menstruation. Ginger has anti-inflammatory effect which can soothe achy muscles.Ginger may also reduce nausea. Few studies confirm this, but a 2018 study found that ginger effectively reduced nausea and vomiting during the first trimester of pregnancy.Since it’s safe and relatively cheap, it’s worth trying.Don’t consume too much ginger,though: Consuming more than 4 grams in one day could cause heartburn and stomachaches. "); 
    b1 = new JButton("okay");  
    l1.setBounds(20, 20, 400, 120);    
    l2.setBounds(20, 170, 400, 120);   
    l3.setBounds(20, 320, 400, 120);  
    l4.setBounds(20, 470, 400, 120);  
    l5.setBounds(20, 620, 400, 150);  
    l1.setLineWrap(true);      
    l2.setLineWrap(true);      
    l3.setLineWrap(true);     
    l4.setLineWrap(true);     
    l5.setLineWrap(true);     
    b1.setBounds(140, 810, 75, 30);       
    f5.add(l1);    
    f5.add(l2);    
    f5.add(l3);
    f5.add(l4);    
    f5.add(l5);    
    f5.add(b1);    
    b1.addActionListener(this); 
    f5.setSize(500,900);     
    f5.setLayout(null);      
    f5.setVisible(true);    
    f5.setLocationRelativeTo(null); 
    f5.getContentPane().setBackground(Color.pink);   
    setDefaultCloseOperation(EXIT_ON_CLOSE);    
  }    
  public void actionPerformed(ActionEvent e) { 
    if (e.getSource() == b1) {         }   
  }     
  public static void main(String[] args) {       
    new Diet1();   
  }     
  public void setvisible(boolean b) {     } }






import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
public class Exercise extends JFrame implements ActionListener {  
  JTextArea l1,l2,l3,l4,l5;   
  JButton b1; 
  Exercise()   
  {        
    JFrame f7=new JFrame("EXERCISE/YOGA RECOMMANDATION FOR PCOD/PCOS"); 
    l1=new JTextArea("CARDIO:Good for reducing insulin resistance, boosting fertility, stabilising mood Moderate exercise like brisk walking, jogging, cycling or swimming are all great activities that can help with PCOS. This type of exercise increases your bodies sensitivity to insulin, which reduces your risk of cardiovascular disease and type 2 diabetes. Doing 30 minutes or more a day can also help with weight management, symptoms of depression and anxiety, as well as improving frequency of menstrual cycles and ovulation. And if you’re about to start IVF, regular light exercise can boost your reproductive success. Not sure how to start running, easy download the free Nike Run Club app that provides your with guided runs to help you begin your running journey!");  
    l2=new JTextArea("STRENGTH TRAINING :Good for reducing insulin resistance, increasing metabolic rate, improving body composition (more muscle and less fat tissue)Bodyweight exercises like squats, push-ups, or tricep dips improve the function of insulin in your body, but can also boost your metabolism by building more muscle mass. Don’t worry though; you won’t bulk up unless you’re taking steroids! More muscle simply means burning more calories while exercising, but also throughout the day even at rest. Combining resistance moves with cardio exercise is the best way to ensure you’re building a lean body, achieving a healthy BMI, and reducing your risk of chronic diseases like type 2 diabetes.");   
    l3=new JTextArea("HIGH INTENSITY INTERVAL TRAINING :Good for increasing cardiovascular fitness and decreasing waist circumference Intervals involve swapping between short bouts of high intensity work and lower intensity recovery. It’s a time efficient way of boosting your cardiovascular fitness, with extra benefits for PCOS. Going hard on the spin bike burns bucket-loads of calories, and reduces abdominal fat more effectively then say, a brisk walk. This can help you achieve a 5 – 10% weight loss, which studies show can decrease PCOS symptoms by reducing excess testosterone and improving insulin resistance.");         
    l4=new JTextArea("CORE STRENGTH Good for general well-being and injury prevention, preparing your body for pregnancy. Being above your ideal weight can cause lower back pain and poor posture, so including core training in your program is essential. These muscles support the spine and learning how to switch them on ensures you don’t injure yourself during exercise. Also if you’re trying to conceive, start training your pelvic floor muscles! These muscles are also part of your core and help prevent incontinence, boost sexual health, and improve pelvic stability to help support a healthy pregnancy.");       
    l5=new JTextArea("The most effective exercise is the one you keep up with, so choose something you enjoy! Seeking help from an Accredited Exercise Physiologist is a great way to guarantee you’re exercising right for your condition. They can provide a tailored exercise program as well as lifestyle advice and support to help you reach your health and well-being goals. ");             
    b1=new JButton("okay");    
    l1.setBounds(20, 20, 400, 160);     
    l2.setBounds(20, 200, 400, 160);     
    l3.setBounds(20, 370, 400, 140);     
    l4.setBounds(20, 530, 400, 140);     
    l5.setBounds(20, 690, 400, 80);      
    l1.setLineWrap(true);        
    l2.setLineWrap(true);     
    l3.setLineWrap(true);     
    l4.setLineWrap(true);     
    l5.setLineWrap(true);     
    b1.setBounds(140, 810, 75, 30);     
    f7.add(l1);       
    f7.add(l2);     
    f7.add(l3);      
    f7.add(l4);     
    f7.add(l5);     
    f7.add(b1);     
    b1.addActionListener(this);   
    f7.setSize(500,900);     
    f7.setLayout(null);      
    f7.setVisible(true);     
    f7.setLocationRelativeTo(null);    
    f7.getContentPane().setBackground(Color.pink);   
    setDefaultCloseOperation(EXIT_ON_CLOSE);     
  }     
  public void actionPerformed(ActionEvent e) {   
    if (e.getSource() == b1) {         }   
  }         
  public static void main (String[]args)       
  {             
    new Exercise();    
  }       
  public void setvisible ( boolean b)         {         } }
