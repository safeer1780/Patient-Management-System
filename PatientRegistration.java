package PMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientRegistration  implements ActionListener
{

    Database patobj = new Database();
    Connection connobj = null;
    JFrame frame;
    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel fatherNameLabel=new JLabel("FATHER NAME");
    JLabel IDLabel=new JLabel("ID");
    JLabel diseasesLabel=new JLabel("Diseases Area");
    JLabel prscriptionlabel=new JLabel("prscription");
    JLabel doctorlabelName=new JLabel("Docontor Name");
    JTextField nameTextField=new JTextField();
//    JRadioButton maleRadioBtn = new JRadioButton(gender[0]);
//    JRadioButton femaleBtn = new JRadioButton(gender[1]);
    JComboBox genderComboBox=new JComboBox(gender);
    JTextField fatherTextField=new JTextField();
    JTextField IDfield=new JTextField();
    JTextField diseasesField=new JTextField();
    JTextField prescriptionField=new JTextField();
    JTextField DoctorFiled=new JTextField();
    JButton registerButton=new JButton("save");
    JButton resetButton=new JButton("Cancel");


    PatientRegistration()
    {
        CreateRegistration();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();

    }

    public void CreateRegistration()
    {
        //Setting properties of JFrame
        frame=new JFrame();
        frame.setTitle("Patient Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        //Setting Location and Size of Each Component
        nameLabel.setBounds(20,20,40,70);
        genderLabel.setBounds(20,70,80,70);
        fatherNameLabel.setBounds(20,120,100,70);
        IDLabel.setBounds(20,170,100,70);
        diseasesLabel.setBounds(20,220,140,70);
        prscriptionlabel.setBounds(20,270,100,70);
        doctorlabelName.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
//        femaleBtn.setBounds(180,93,165,23);
//        femaleBtn.setSelected(false);
//        maleRadioBtn.setBounds(250,93,165,23);
//        maleRadioBtn.setSelected(true);
        fatherTextField.setBounds(180,143,165,23);
        IDfield.setBounds(180,193,165,23);
        diseasesField.setBounds(180,243,165,23);
        prescriptionField.setBounds(180,293,165,23);
        DoctorFiled.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        //Adding components to Frame
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(fatherNameLabel);
        frame.add(IDLabel);
        frame.add(diseasesLabel);
        frame.add(prscriptionlabel);
        frame.add(doctorlabelName);
        frame.add(nameTextField);
        frame.add(genderComboBox);
//        frame.add(maleRadioBtn);
//        frame.add(femaleBtn);
        frame.add(fatherTextField);
        frame.add(IDfield);
        frame.add(diseasesField);
        frame.add(prescriptionField);
        frame.add(DoctorFiled);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

//    public void searchByID()
//    {
//        for(int i =0 ; i < 3 ; i++)
//        {
//
//        }
//        int arr[] = {}
//
//    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        JRadioButton check = new JRadioButton();
        if(e.getSource() == registerButton)
        {
//            if(maleRadioBtn.isSelected())
//            {
//              check = maleRadioBtn;
//            }else
//                check = femaleBtn;
            registerButton.setEnabled(false);


            try {
               // patobj.connectionestablish();
                connobj = patobj.getconection();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                patobj.CreateStatements();
//                String patient = "Create table patient " + "(ID Integer not null ,Patient_Name VARCHAR(32),"
//                        + "Father_Name VARCHAR(32)," + "Disease_Area VARCHAR(32)," + "Prescription VARCHAR(64),"
//                        + "Doctor_Name VARCHAR(32)," + "Gender VARCHAR(32))";
//                patobj.exetQuery(patient);
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

            try {
                DatabaseMetaData dbmd = connobj.getMetaData();


                PreparedStatement Pstatement = connobj.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
                // specefying values of parameter
                Pstatement.setInt(1, Integer.parseInt(IDfield.getText()));
                Pstatement.setString(2,nameTextField.getText());
                Pstatement.setString(3,fatherTextField.getText());
                Pstatement.setString(4,diseasesField.getText());
                Pstatement.setString(5,prescriptionField.getText());
                Pstatement.setString(6,DoctorFiled.getText());
               // Pstatement.setString(7,check.getText());
                Pstatement.setString(7,genderComboBox.getSelectedItem().toString());

                Pstatement.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }


            try {
                System.out.println(" successfully saved in data base ");
                JOptionPane.showMessageDialog(null , " data successfully stored");
                patobj.connectionClosed();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            frame.dispose();

        }
        if(e.getSource() == resetButton)
        {
            resetButton.setEnabled(false);
            frame.dispose();
        }
    }

}
