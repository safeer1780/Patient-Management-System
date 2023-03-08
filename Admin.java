package PMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends JFrame implements ActionListener
{
    Database databaseAdmin = new Database();
    Connection adminConnection = null;
    ResultSet adminResult = null;
    JPanel patientRegisterpanel;
    JMenuBar menuBar;
    JMenu Menue ;
    JMenu toolBar;
    JMenu mangaeRecord;
    JMenu searchRd;
    JMenu helpMeue;
    JMenu UpdateRecord;
    JMenuItem addNewPat , addNewDoc , addNewDis , deletePatintRd ;
    JMenuItem udatePatient , updateDoctor;

    JMenuItem searchPatientByName ,searchPatientByID ,searchPatientByDiseases , searchPatientByDoctor , searchDoctorByName;

    JMenuItem us , changePassword;

    JMenuItem addPatientTool;
    JMenuItem addDoctorTool;
    JMenuItem searchPatientTool;
    JMenuItem printTool;

    ImageIcon addPatientIcon;
    ImageIcon searchPatientIcon;
    ImageIcon addNewDoctorIcon;
    ImageIcon PrintIcon;
    Admin()
    {
        this.setTitle("Admin ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.cyan);
        this.getContentPane().setLayout(null);

        menuBar = new JMenuBar();
        Menue = new JMenu("Menue");
        toolBar = new JMenu("ToolBar");
        mangaeRecord = new JMenu("Manage Record");
        searchRd = new JMenu("Search Record");
        helpMeue = new JMenu("Help Menue");


        Menue.add(mangaeRecord);
        Menue.add(searchRd);
        Menue.add(helpMeue);


        addNewPat = new JMenuItem("Add New Patient");
        addNewDoc = new JMenuItem("Add new Doctor");
        addNewDis = new JMenuItem("Add new Diseases");
        deletePatintRd = new JMenuItem("Delete Patient");


        UpdateRecord = new JMenu("Update Record");

        mangaeRecord.add(addNewPat);
        mangaeRecord.add(addNewDoc);
        mangaeRecord.add(addNewDis);
        mangaeRecord.add(deletePatintRd);
        mangaeRecord.add(UpdateRecord);

        udatePatient = new JMenuItem("Update Patient");
        updateDoctor = new JMenuItem("Update Doctor");

        UpdateRecord.add(udatePatient);
        UpdateRecord.add(updateDoctor);

//        mangaeRecord.addActionListener(this);
//        searchRd.addActionListener(this);
//        helpMeue.addActionListener(this);
        searchPatientByName = new JMenuItem("Search Patient By Name");
        searchPatientByID = new JMenuItem("Search Patient By ID");
        searchPatientByDoctor = new JMenuItem("Search Patient By Doctor");
        searchPatientByDiseases = new JMenuItem("Search Patient By Diseases");
        searchDoctorByName = new JMenuItem("Search Doctor By Name");

        searchRd.add(searchPatientByName);
        searchRd.add(searchPatientByID);
        searchRd.add(searchPatientByDiseases);
        searchRd.add(searchPatientByDoctor);
        searchRd.add(searchDoctorByName);

        us = new JMenuItem("Us");
        changePassword = new JMenuItem("Change Password");

        helpMeue.add(us);
        helpMeue.add(changePassword);

        addPatientTool = new JMenuItem("ADD Patient");
        addDoctorTool = new JMenuItem("ADD doctor");
        searchPatientTool = new JMenuItem("Search Patient");
        printTool = new JMenuItem("Print");

        addPatientIcon = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\patient.png");
        addNewDoctorIcon = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\addDoctor.png");
        searchPatientIcon = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\searchPatient.png");
        PrintIcon = new ImageIcon("C:\\Users\\safee\\Desktop\\ass2\\print.png");

        addPatientTool.setIcon(addPatientIcon);
        addDoctorTool.setIcon(addNewDoctorIcon);
        searchPatientTool.setIcon(searchPatientIcon);
        printTool.setIcon(PrintIcon);

        toolBar.add(addPatientTool);
        toolBar.add(addDoctorTool);
        toolBar.add(searchPatientTool);
        toolBar.add(printTool);


        addNewPat.addActionListener(this);
        addNewDoc.addActionListener(this);
        addNewDis.addActionListener(this);
        deletePatintRd.addActionListener(this);

        udatePatient.addActionListener(this);
        updateDoctor.addActionListener(this);

        searchDoctorByName.addActionListener(this);
        searchPatientByID.addActionListener(this);
        searchPatientByName.addActionListener(this);
        searchPatientByDiseases.addActionListener(this);
        searchPatientByDoctor.addActionListener(this);

        us.addActionListener(this);
        changePassword.addActionListener(this);

        addPatientTool.addActionListener(this);
        addDoctorTool.addActionListener(this);
        searchPatientTool.addActionListener(this);
        printTool.addActionListener(this);




        menuBar.add(Menue);
        menuBar.add(toolBar);

        this.setJMenuBar(menuBar);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() ==addNewPat )
        {
            PatientRegistration obj = new PatientRegistration();
//            patientRegisterpanel = new JPanel();
//            this.add(patientRegisterpanel);
//            patientRegisterpanel.setPreferredSize(new Dimension(400,400));
//            patientRegisterpanel.setBackground(Color.blue);
//
//
//            JTextField pName = new JTextField();
//            pName.setText("Patient Name");
//
//            patientRegisterpanel.add(pName);
//            this.add(patientRegisterpanel);

//            patientRegisterpanel.setVisible(true);

        }
        if (e.getSource() == addNewDoc)
        {
            DoctorRegistrationForm docForm = new DoctorRegistrationForm();
        }
        if (e.getSource() == addNewDis)
        {
            DiseasesRegistrationForm diseaseObj = new DiseasesRegistrationForm();
        }
        if (e.getSource() == deletePatintRd)
        {
            int delete = Integer.parseInt(JOptionPane.showInputDialog("Enter the deleted id to deleted"));
            try {
                adminConnection = databaseAdmin.getconection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                databaseAdmin.CreateStatements();

                String deleterecord = "Delete from patient where ID = "+ delete;
                databaseAdmin.exetQuery(deleterecord);
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                JOptionPane.showMessageDialog(null,"patient ID is deleted successfully");
                databaseAdmin.connectionClosed();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }


        }
        if (e.getSource() == udatePatient)
        {
            String enterthecoloName = JOptionPane.showInputDialog(" Enter the Patient coloum Name ");
            int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID to update "));
            String updatedWord = JOptionPane.showInputDialog(" Enter the updated value");

            try {
                adminConnection = databaseAdmin.getconection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                databaseAdmin.CreateStatements();
              //  String update = "UPDATE patient SET [Doctor_Name] = 'shahid'  where ID = "+ ID;
                String update = "UPDATE patient SET "+"["+enterthecoloName+"]"+" = "+"'"+ updatedWord+"'"+"  where ID = "+ ID;
                databaseAdmin.exetQuery(update);
                System.out.println("executeed succsfully done ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                databaseAdmin.connectionClosed();
                JOptionPane.showMessageDialog(null,"update success fully done ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == updateDoctor)
        {
            String enterthecoloName = JOptionPane.showInputDialog(" Enter the Doctor coloum Name ");
            int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID to update "));
            String updatedWord = JOptionPane.showInputDialog(" Enter the updated value");

            try {
                adminConnection = databaseAdmin.getconection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                databaseAdmin.CreateStatements();
                //  String update = "UPDATE patient SET [Doctor_Name] = 'shahid'  where ID = "+ ID;
                String update = "UPDATE Doctor SET "+"["+enterthecoloName+"]"+" = "+"'"+ updatedWord+"'"+"  where Doctor_ID = "+ ID;
                databaseAdmin.exetQuery(update);
                System.out.println("executeed succsfully done ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                databaseAdmin.connectionClosed();
                JOptionPane.showMessageDialog(null,"update success fully done ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == searchPatientByID)
        {
            try {
                patientDataCatch dataCatch = new patientDataCatch();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
//            JComboBox IDBox = new JComboBox();
//
//            try {
//                adminConnection = databaseAdmin.getconection();
//
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//                throw new RuntimeException(ex);
//            }
//            try {
//                databaseAdmin.CreateStatements();
//
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//            String searchById = "Select *from patient where ID = 433";
//            try {
//                adminResult = databaseAdmin.getresult(searchById);
//                while (adminResult.next())
//                {
//                    System.out.println(adminResult.getInt(1)+"\t"+ adminResult.getString(2)+"\t"
//                            +adminResult.getString(3)+"\t"+adminResult.getString(4)+"\t"+adminResult.getString(5)
//                            +"\t"+adminResult.getString(6)+"\t"+adminResult.getString(7));
//                }
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//
//            try {
//                databaseAdmin.connectionClosed();
//                JOptionPane.showMessageDialog(null,"update success fully done ");
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
        }
        if (e.getSource() == searchPatientByName)
        {
            try {
                patientDataCatchbyName catchobj = new patientDataCatchbyName();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource()== searchPatientByDiseases)
        {
            try {
                patientDataCatchbyDiseases dieseasesObj = new patientDataCatchbyDiseases();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }if (e.getSource() == searchPatientByDoctor)
    {
        try {
            patientDataCatchByDoctorName doctorName = new patientDataCatchByDoctorName();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
        if (e.getSource() == searchDoctorByName)
        {
            try {
                doctorDataCatchByName doctorData = new doctorDataCatchByName();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == us)
        {
            JPanel usPanel = new JPanel();
            JLabel usLabel = new JLabel("Welcome to PMS\n ");
            JLabel contactLable = new JLabel("contacts :  whatsapp numb : 00937  ");
            JLabel emailLable = new JLabel("Email : @gmail.com ");
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
        if(e.getSource() == addPatientTool)
        {
            PatientRegistration obj = new PatientRegistration();
        }
        if (e.getSource() == addDoctorTool)
        {
            DoctorRegistrationForm docForm = new DoctorRegistrationForm();
        }
        if(e.getSource() == searchPatientTool)
        {
            try {
                patientDataCatch dataCatch = new patientDataCatch();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == printTool)
        {
            JLabel printlable = new JLabel(" Print ");
            printlable.setBounds(10,10,400,50);
            printlable.setFont(new Font(null , Font.PLAIN,25));

            this.add(printlable);
            this.setVisible(true);
        }

    }
}
