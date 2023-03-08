package PMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login implements ActionListener
{

    Connection conobj = null;
    Database databaseobj = new Database();
    String name = " s";
    String pass = " 2";

    JFrame obj = new JFrame();
    JButton guestBt = new JButton("Guest");
    JLabel Loglabel = new JLabel("Welcome to the PMS");
    JButton AdminstrationBt = new JButton("Admin");

    JButton sumitBt ;
    JButton admBt;
    ImageIcon adminImage = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\admin.PNG");
    ImageIcon guestImage = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\ha.PNG");
    JTextField user ;
    JPasswordField password;

    JTextField userAdm;
    JPasswordField passAdm;

    JLabel guestLable;
    JLabel adminLable;

    login()
    {
        Loglabel.setBounds(0,0,400,50);
        Loglabel.setFont(new Font(null , Font.PLAIN,25));


        obj.setTitle("LOGIN");
        guestBt.setBounds(10,80,120,220);
        guestBt.setFocusable(false);
        guestBt.setIcon(guestImage);
        guestBt.addActionListener(this);

        guestLable = new JLabel("Guest");
        guestLable.setBounds(20,115,400,400);
        guestLable.setFont(new Font("Consolas", Font.PLAIN,30));
        guestLable.setForeground(new Color(00000000));
        guestLable.setBackground(Color.BLACK);



        AdminstrationBt.setBounds(200,80,200,200);
        AdminstrationBt.setFocusable(false);
        AdminstrationBt.setIcon(adminImage);
        AdminstrationBt.addActionListener(this);

        adminLable = new JLabel("Admin");
        adminLable.setBounds(250,115,400,400);
        adminLable.setFont(new Font("Consolas", Font.PLAIN,30));
        adminLable.setForeground(new Color(0x00000));
        adminLable.setBackground(Color.BLACK);



        obj.add(guestLable);
        obj.add(adminLable);
        obj.add(Loglabel);
        obj.add(guestBt);
        obj.add(AdminstrationBt);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setSize(520,650);
        obj.setLayout(null);
//        obj.setBackground(Color.cyan);
//        obj.setForeground(new Color(255,192,203));
        obj.getContentPane().setBackground(Color.cyan);
        obj.getContentPane().setLayout(null);
        obj.getContentPane().setBackground(Color.cyan);
        obj.getContentPane().setLayout(null);
        obj.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== guestBt)
        {
            obj.setResizable(false);
            //obj.dispose(); // destroy the lauch page when newwindow call
            JLabel guesLabel = new JLabel(" Welcome to Guest login");
            guesLabel.setBounds(30,270,400,250);
            guesLabel.setFont(new Font("Consolas", Font.PLAIN,30));
            guesLabel.setForeground(new Color(0x00000));
           // guesLabel.setOpaque(true);



            user = new JTextField();
            user.setBounds(40 ,450,150,50);
            //user.setPreferredSize(new Dimension(250,40));
            user.setFont(new Font("Consolas", Font.PLAIN,20));
            user.setForeground(new Color(0x00FF00));
            user.setBackground(Color.BLACK);
            user.setCaretColor(Color.white);
            user.setText("Username");



            password = new JPasswordField();
            password.setBounds(40 ,500,150,50);
         //   password.setPreferredSize(new Dimension(250,40));
            password.setFont(new Font("Consolas", Font.PLAIN,20));
            password.setForeground(new Color(0x00FF00));
            password.setBackground(Color.BLACK);
            password.setCaretColor(Color.white);
            password.setText("Password");


            sumitBt = new JButton("Sumbit");
            sumitBt.setBounds(200,500,100,50);
            sumitBt.addActionListener(this);

            obj.add(guesLabel);
            obj.add(user);
            obj.add(password);
            obj.add(sumitBt);

        } else if (e.getSource() == sumitBt)
        {
//            Connection con = null;
//            Statement st = null;

//            try
//            {
//
//            }
////            try{
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","2b3c4d5f");
//
//                PreparedStatement Pstatement = con.prepareStatement("insert into login values(?,?)");
//                // specifing the value of its parameter
//                Pstatement.setString(1,user.getText());
//                Pstatement.setString(2,password.getText());
//                Pstatement.executeUpdate();
//                JOptionPane.showMessageDialog(null, " the data is stored successfully of guest");
            try {
                //databaseobj.connectionestablish();
                conobj = databaseobj.getconection();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                databaseobj.CreateStatements();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

            try {
                PreparedStatement Pstatement = conobj.prepareStatement("insert into login values(?,?)");
                // specifing the value of its parameter
                Pstatement.setString(1,user.getText());
                Pstatement.setString(2,password.getText());
                Pstatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
//
            try {
                databaseobj.connectionClosed();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

            System.out.println(user.getText());
            System.out.println(password.getText());
            sumitBt.setEnabled(false);  // one we sumbit second time we didn't submitted
            user.setEditable(false);
            password.setEditable(false);
            obj.dispose();
            guest guestobj = new guest();
        }
         if (e.getSource() == AdminstrationBt) {
            //obj.dispose();
            obj.setResizable(false);
            //obj.dispose(); // destroy the lauch page when newwindow call
            userAdm = new JTextField();
            userAdm.setBounds(40 ,450,150,50);
            //user.setPreferredSize(new Dimension(250,40));
            userAdm.setFont(new Font("Consolas", Font.PLAIN, 20));
            userAdm.setForeground(new Color(0x00FF00));
            userAdm.setBackground(Color.BLACK);
            userAdm.setCaretColor(Color.white);

             JLabel adminlaEL = new JLabel(" Welcome to Admin login");
             adminlaEL.setBounds(30,270,400,250);
             adminlaEL.setFont(new Font("Consolas", Font.PLAIN,30));
             adminlaEL.setForeground(new Color(0x00000));

            userAdm.setText("Username");

            passAdm = new JPasswordField();
            passAdm.setBounds(40 ,500,150,50);
            //   password.setPreferredSize(new Dimension(250,40));
            passAdm.setFont(new Font("Consolas", Font.PLAIN, 20));
            passAdm.setForeground(new Color(0x00FF00));
            passAdm.setBackground(Color.BLACK);
            passAdm.setCaretColor(Color.white);
            passAdm.setText("Password");

            admBt = new JButton(" Sumbit");
            admBt.setBounds(200,500,100,50);
            admBt.addActionListener(this);

            obj.add(adminlaEL);
            obj.add(userAdm);
            obj.add(passAdm);
            obj.add(admBt);



           // System.out.println(" user.............. : " + userAdm.getText() +", name : "+ name + " PASSWORD : " + passAdm.getText() + ", password " + pass);
        }
         if (e.getSource() == admBt)
        {
                 // System.out.println(" user : " + userAdm.getText() + ", name : " + name + " PASSWORD : " + passAdm.getText() + ", password " + pass);
            String name = userAdm.getText();
            String pass = passAdm.getText();
             if (name.equals("admin") && pass.equals("123"))
             {
                 admBt.setEnabled(false);  // one we sumbit second time we didn't submitted
                 userAdm.setEditable(false);
                 passAdm.setEditable(false);
                 System.out.println(" successfully entered ...........");
                 obj.dispose();
                 Admin adminObj = new Admin();
                 //   JOptionPane.showMessageDialog(null," Successfully entered");
//                 //  Admin adminObj = new Admin();
            }else {
                 JOptionPane.showMessageDialog(null , " you entered wrong username or password");
             }
         }

    }
}
