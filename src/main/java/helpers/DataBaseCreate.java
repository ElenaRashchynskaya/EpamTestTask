package helpers;

import java.sql.*;
import java.util.logging.Logger;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;

/**
 * Created by Lenovo on 9/23/2016.
 */
public class DataBaseCreate {

    private static Logger log = Logger.getLogger("testLog");

    public static void main(String[] args) {
        Connection cn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                cn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
                try {
                    st = cn.createStatement();
                    st.executeUpdate("CREATE TABLE account(id INT(3)PRIMARY KEY,login VARCHAR(20),password VARCHAR(20))");
                    st.executeUpdate("INSERT INTO account VALUES(1,'nemanskaja39@tut.by','avtotest_08082016')");
                    st.executeUpdate("INSERT INTO account VALUES(2,'ncremo01@tut.by','avtotest_2016')");
                    st.executeUpdate("INSERT INTO account VALUES(3,'nemanskaja39_2@tut.by','avtotest_24082016')");
                    st.executeUpdate("INSERT INTO account VALUES(4,'nemanskaja39_3@tut.by','avtotest_25082016')");
                    st.executeUpdate("INSERT INTO account VALUES(5,'nemanskaja39_4@tut.by','avtotest_26082016')");
                    st.executeUpdate("INSERT INTO account VALUES(6,'nemanskaja39_5@tut.by','avtotest_2016')");
                    st.executeUpdate("INSERT INTO account VALUES(7,'nemanskaja39_6@tut.by','avtotest_2016')");
                    st.executeUpdate("INSERT INTO account VALUES(8,'nemanskaja39_7@tut.by','avtotest_2016')");
                    st.executeUpdate("INSERT INTO account VALUES(9,'nemanskaja39_8@tut.by','avtotest_2016')");
                    st.executeUpdate("INSERT INTO account VALUES(10,'nemanskaja39_9@tut.by','avtotest_2016')");
                    st.executeUpdate("INSERT INTO account VALUES(11,'nemanskaja39_10@tut.by','avtotest_2016')");


                    st.close();
                } catch (SQLException ex) {
                    log.info("Error in Statement" + ex);
                }
                cn.close();
            } catch (SQLException ex) {
                log.info("Error in create Connection" + ex);
            }
        } catch (ClassNotFoundException ex) {
            log.info("Error in downloadDriver" + ex);
        }
    }
}
