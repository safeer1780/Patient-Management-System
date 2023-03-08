package PMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class guest extends JFrame implements ActionListener
{
    JMenuBar menuBar;
    JMenu Menue ;
    JMenu toolBar;
    JMenu searchRecord;
    JMenuItem print;
    JMenu helpMeue;
    JMenuItem searchPatientByName ,searchPatientByID;
    JMenuItem us , changePassword;

    JMenuItem searchTool;
    JMenuItem printTol;

    ImageIcon searchRecordIcon;
    ImageIcon PrintIcon;

    guest()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        this.getContentPane().setBackground(Color.cyan);
        this.getContentPane().setLayout(null);
        this.setTitle("GUEST");

        menuBar = new JMenuBar();

        Menue = new JMenu("Menue");
        toolBar = new JMenu("ToolBar");
        searchRecord = new JMenu("Search Record");
        print = new JMenuItem("print");
        helpMeue = new JMenu("Help Menue");

        Menue.add(searchRecord);
        Menue.add(print);
        Menue.add(helpMeue);

        searchPatientByName = new JMenuItem("Search Patient By Name");
        searchPatientByID = new JMenuItem("Search Patient By ID");

        searchRecord.add(searchPatientByName);
        searchRecord.add(searchPatientByID);

        us = new JMenuItem("Us");
        changePassword = new JMenuItem("Change Password");

        helpMeue.add(us);
        helpMeue.add(changePassword);

        searchTool = new JMenuItem("Search Patient");
        printTol = new JMenuItem(" Print");

        toolBar.add(searchTool);
        toolBar.add(printTol);

        searchRecordIcon = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\searchPatient.png");
        PrintIcon = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\print.png");

        searchTool.setIcon(searchRecordIcon);
        printTol.setIcon(PrintIcon);



        menuBar.add(Menue);
        menuBar.add(toolBar);

        searchPatientByName.addActionListener(this);
        searchPatientByID.addActionListener(this);

        us.addActionListener(this);
        changePassword.addActionListener(this);

        searchTool.addActionListener(this);

        print.addActionListener(this);

        this.setJMenuBar(menuBar);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == searchPatientByName)
        {
            try {
                patientDataCatchbyName patientOBJ = new patientDataCatchbyName();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == searchPatientByID)
        {
            try {
                patientDataCatch byIDobj = new patientDataCatch();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == print)
        {
            JLabel printlable = new JLabel(" Print ");
            printlable.setBounds(10,10,400,50);
            printlable.setFont(new Font(null , Font.PLAIN,25));

            this.add(printlable);
            this.setVisible(true);
        }
        if (e.getSource() == us)
        {
            JPanel usPanel = new JPanel();
            JLabel usLabel = new JLabel("Welcome to PMS\n ");
            JLabel contactLable = new JLabel("contacts :  whatsapp numb : 00937  ");
            JLabel emailLable = new JLabel("Email :@gmail.com ");
          //  contactLable.setSize(30,30);
          //  usLabel.setSize(30,30);
            usLabel.setBounds(10,20,150,100);
            contactLable.setBounds(10,65,500,100);
            emailLable.setBounds(10,80,500,100);


            usPanel.setBounds(70,10,300,100  );
            usPanel.setBackground(Color.green);

            usPanel.add(emailLable);
            usPanel.add(usLabel);
            usPanel.add(contactLable);
            this.add(usPanel);
            usPanel.setVisible(true);
            this.setVisible(true);
        }
        if (e.getSource() == searchTool)
        {
            try {
                patientDataCatchbyName patientObjDATA = new patientDataCatchbyName();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == printTol)
        {
            JLabel printlable = new JLabel(" Print ");
            printlable.setBounds(20,240,400,50);
            printlable.setFont(new Font(null , Font.PLAIN,25));
        }

    }
}
