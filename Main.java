package PMS;
import javax.swing.*;
import java.sql.*;
import javax.swing.*;
import java.sql.*;

public class Main {
//    static final String Driver = "com.mysql.jdbc.Driver";
//    static final String url = "jdbc:mysql://localhost/mydatabase";
//    static final String dbuser = "root";
//    static final String dbpassword ="2b3c4d5f";

    public static void main(String[] args) throws SQLException {


//        ResultSet setdata = null;
//
//        Database database = new Database();
//        database.connectionestablish();
//        database.CreateStatements();
       // String logintab = "Create table login " + "(userName VARCHAR(32), " + "passwrod VARCHAR(32))";
       // database.exetQuery(logintab);
//        String insertLogin = "Insert into login values" +"(shahid,sha123)";
//        database.exetQuery(insertLogin);

//        String getlogin = "Select * from login";
//        setdata = database.getresult(getlogin);
//        while(setdata.next()) {
//            System.out.println(setdata.getString(1) + "\t" + setdata.getString(2));
//        }
//
//       // System.out.println(database.getresult(getlogin));
//        database.connectionClosed();





//        Connection con = null;
//        Statement st = null;
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("connecting to selected databse... ");
//            con = DriverManager.getConnection(url,dbuser,dbpassword);
//            System.out.println("connecting to database successfully....");
//            System.out.println("Creating table in selected database");
//
//            st = con.createStatement();
//
//            String sql = "CREATE TABLE LOGING" + "(userName VARCHAR(100)," + "PASSROD VARCHAR(100))";
//            st.executeUpdate(sql);
//            System.out.println("Table created is given database....");
//
//        }catch (SQLException E)
//        {
//            E.printStackTrace();
//        }catch (Exception EC)
//        {
//            EC.printStackTrace();
//        }finally {
//            try
//            {
//                if(st != null)
//                    con.close();
//
//            }catch (SQLException EP)
//            {
//                EP.printStackTrace();
//            }
//
//        }
//        try{
//            if(con != null)
//                con.close();
//        }catch (SQLException EA)
//        {
//            EA.printStackTrace();
//        }
//        System.out.println("good bye");


        login page = new login();


        System.out.println("Hello world!");
    }
}