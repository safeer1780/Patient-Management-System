package PMS;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class doctorDataCatchByName extends JFrame implements ActionListener
{
    Database databaseEmplo = new Database();
    Connection con = null;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;

    JFrame frame1;
    JLabel l0, l1, l2;
    JComboBox c1;
    JButton b1;


    String ids;
    static JTable table;
    String[] columnNames = {"Doctor_ID ", "Doctor_Name", "Diseases"};
    String from;


    doctorDataCatchByName() throws SQLException {
        l0 = new JLabel(" Doctor Information");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 20));
        l1 = new JLabel("Select Doctor name");
        b1 = new JButton("submit");
        l0.setBounds(100, 50, 350, 40);
        l1.setBounds(75, 110, 75, 20);
        b1.setBounds(150, 150, 150, 20);
        b1.addActionListener(this);
        setTitle("Doctor Info From DataBase");
        this.getContentPane().setBackground(Color.cyan);
        this.getContentPane().setLayout(null);
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(l0);
        add(l1);
        ;
        add(b1);


        try {
            con = databaseEmplo.getconection();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        try {
            databaseEmplo.CreateStatements();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
        //String searchById = "Select *from patient where ID = 433";
        // rs = con.createStatement().executeQuery("Select *from patient");
        //  rs = con.createStatement().getResultSet(searchById);
        String patientdata = "Select *from Doctor";
        rs = databaseEmplo.getresult(patientdata);
        Vector v = new Vector();
        while (rs.next()) {
            ids = rs.getString(2);
            v.add(ids);
        }
        c1 = new JComboBox(v);
        c1.setBounds(150, 110, 150, 20);
        add(c1);
        st.close();
        rs.close();

        databaseEmplo.connectionClosed();
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b1) {
            showTableData();
        }
    }
    public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        //TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // from = (String) c1.getSelectedItem();
        from = (String) c1.getSelectedItem();
        //String textvalue = textbox.getText();
        int DoctorID;
        String DocName = "";
        String Diseases = "";

        try {
            pst = con.prepareStatement("select * from Doctor where Doctor_Name='" + from + "'");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            if (rs.next()) {
                DoctorID = rs.getInt(1);
                DocName = rs.getString(2);
                Diseases = rs.getString(3);

                model.addRow(new Object[]{DoctorID, DocName, Diseases});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
    }
}
