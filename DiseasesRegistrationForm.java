package PMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiseasesRegistrationForm implements ActionListener
{
    JFrame frameDisease ;
    Database diseasedatabase = new Database();
    Connection diseaseConection = null;

    JLabel diseaseNameLable=new JLabel("NAME");
    JLabel diseaseIDlable=new JLabel("ID");
    JLabel diseaseDescritionLable=new JLabel("Disease Description");

    JTextField diseaseNameTextfield=new JTextField("enter the Disease name ");
    JTextField diseaseIDTextField=new JTextField("enter the Diseases ID");
    JTextField diseasesDescritionField=new JTextField("enter the disease Discription");
    JButton saveButton=new JButton("save");
    JButton cancelButton=new JButton("Cancel");

   DiseasesRegistrationForm()
   {
       CreateRegistrationDisease();
       setlocationAndSize();
       addDoctComp();
       actionEventdisease();

   }
    public void CreateRegistrationDisease()
    {
        //Setting properties of JFrame
        frameDisease=new JFrame();
        frameDisease.setTitle("Diseases Registration Form");
        frameDisease.setBounds(40,40,380,450);
        frameDisease.getContentPane().setBackground(Color.cyan);
        frameDisease.getContentPane().setLayout(null);
        frameDisease.setVisible(true);
        frameDisease.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDisease.setResizable(false);
    }
    public void setlocationAndSize()
    {

        diseaseNameLable.setBounds(20,20,40,70);
        diseaseIDlable.setBounds(20,70,80,70);
        diseaseDescritionLable.setBounds(20,120,120,70);

        diseaseNameTextfield.setBounds(180,43,165,23);
        diseaseIDTextField.setBounds(180,93,165,23);
        diseasesDescritionField.setBounds(180,143,165,23);

        saveButton.setBounds(35,200,100,35);
        cancelButton.setBounds(150,200,100,35);
    }
    public void addDoctComp()
    {

        frameDisease.add(diseaseNameLable);
        frameDisease.add(diseaseIDlable);
        frameDisease.add(diseaseDescritionLable);

        frameDisease.add(diseaseNameTextfield);
        frameDisease.add(diseaseIDTextField);
        frameDisease.add(diseasesDescritionField);

        frameDisease.add(saveButton);
        frameDisease.add(cancelButton);
    }
    public void actionEventdisease()
    {
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == saveButton)
        {
            saveButton.setEnabled(false);


            try {
                // patobj.connectionestablish();
                diseaseConection = diseasedatabase.getconection();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                diseasedatabase.CreateStatements();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

            try {
                DatabaseMetaData metaObji = diseaseConection.getMetaData();


                PreparedStatement Pstatementdis = diseaseConection.prepareStatement("insert into Disease values(?,?,?)");
                System.out.println(" insert values in disease");
                // specefying values of parameter
                Pstatementdis.setInt(1, Integer.parseInt(diseaseIDTextField.getText()));
                Pstatementdis.setString(2,diseaseNameTextfield.getText());
                Pstatementdis.setString(3,diseasesDescritionField.getText());
                System.out.println("inserted in databsae");

                Pstatementdis.executeUpdate();
                System.out.println("executed in database");

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }


            try {
                System.out.println(" successfully saved in data base ");
                JOptionPane.showMessageDialog(null , " data successfully stored");
                diseasedatabase.connectionClosed();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            frameDisease.dispose();

        }
        if(e.getSource() == cancelButton)
        {
            cancelButton.setEnabled(false);
            frameDisease.dispose();
        }
    }



}
