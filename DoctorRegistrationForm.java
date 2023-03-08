package PMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorRegistrationForm implements ActionListener
{
    JFrame frameDoctor ;
    Database daObj = new Database();
    Connection docConection = null;

    JLabel DoctorNameLable=new JLabel("NAME");
    JLabel DoctorIDlable=new JLabel("ID");
    JLabel DiseaseLable=new JLabel("Disease specialist");

    JTextField NameTextfield=new JTextField("enter the name ");
    JTextField IDTextField=new JTextField("enter the ID");
    JTextField diseasesField=new JTextField("enter the disease");
    JButton saveButton=new JButton("save");
    JButton cancelButton=new JButton("Cancel");

    DoctorRegistrationForm()
    {
        CreateRegistration();
        setlocationAndSize();
        addDoctComp();
        actionEvent();
    }

    public void CreateRegistration()
    {
        //Setting properties of JFrame
        frameDoctor=new JFrame();
        frameDoctor.setTitle("Doctor Registration Form");
        frameDoctor.setBounds(40,40,380,450);
        frameDoctor.getContentPane().setBackground(Color.cyan);
        frameDoctor.getContentPane().setLayout(null);
        frameDoctor.setVisible(true);
        frameDoctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDoctor.setResizable(false);
    }
    public void setlocationAndSize()
    {

        DoctorNameLable.setBounds(20,20,40,70);
        DoctorIDlable.setBounds(20,70,80,70);
        DiseaseLable.setBounds(20,120,120,70);

        NameTextfield.setBounds(180,43,165,23);
        IDTextField.setBounds(180,93,165,23);
        diseasesField.setBounds(180,143,165,23);

        saveButton.setBounds(35,200,100,35);
        cancelButton.setBounds(150,200,100,35);
    }
    public void addDoctComp()
    {

        frameDoctor.add(DoctorNameLable);
        frameDoctor.add(DoctorIDlable);
        frameDoctor.add(DiseaseLable);

        frameDoctor.add(NameTextfield);
        frameDoctor.add(IDTextField);
        frameDoctor.add(diseasesField);

        frameDoctor.add(saveButton);
        frameDoctor.add(cancelButton);
    }
    public void actionEvent()
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
                docConection = daObj.getconection();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            try {
                daObj.CreateStatements();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

            try {
                DatabaseMetaData metaObj = docConection.getMetaData();


                PreparedStatement Pstatementdoc = docConection.prepareStatement("insert into Doctor values(?,?,?)");
                System.out.println(" insert values in doctoe");
                // specefying values of parameter
                Pstatementdoc.setInt(1, Integer.parseInt(IDTextField.getText()));
                Pstatementdoc.setString(2,NameTextfield.getText());
                Pstatementdoc.setString(3,diseasesField.getText());
                System.out.println("inserted in databsae");

                Pstatementdoc.executeUpdate();
                System.out.println("executed in database");

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }


            try {
                System.out.println(" successfully saved in data base ");
                JOptionPane.showMessageDialog(null , " data successfully stored");
                daObj.connectionClosed();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            frameDoctor.dispose();

        }
        if(e.getSource() == cancelButton)
        {
            cancelButton.setEnabled(false);
            frameDoctor.dispose();
        }

    }



}
