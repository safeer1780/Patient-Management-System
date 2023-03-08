package PMS;
import java.sql.*;

public class Database
{

    public  Connection con = null;
    public  Statement st = null;
    public  ResultSet set = null;

    Database()
    {}

    public void connectionestablish() throws SQLException {
        String msAccDB = "C:\\Users\\safee\\Desktop\\ass2//PMSDB.accdb";
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        con = DriverManager.getConnection(dbURL);
        System.out.println("connection  is successfulyy connected");
    }
    public Connection getconection() throws SQLException {
        String msAccDB = "C:\\Users\\safee\\Desktop\\ass2//PMSDB.accdb";
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        con = DriverManager.getConnection(dbURL);
        return con;
    }

    public void CreateStatements () throws SQLException {

        st = con.createStatement();
        System.out.println(" statement is created ");
    }
    public void exetQuery(String sqlqurey) throws SQLException {
        st.executeUpdate(sqlqurey);
        System.out.println("query executed successfully ");
    }

    public ResultSet getresult(String sqlgetresult) throws SQLException {
            set = st.executeQuery(sqlgetresult);

            return set;
    }
    public void connectionClosed() throws SQLException {
        con.close();
        System.out.println("connection closed ");
    }




}
