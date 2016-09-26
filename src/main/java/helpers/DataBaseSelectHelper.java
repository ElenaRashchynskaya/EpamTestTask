package helpers;

import java.sql.*;
import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/23/2016.
 */
public class DataBaseSelectHelper {

    private static Logger log = Logger.getLogger("testLog");

    private Connection cn;
    private Statement st;
    private ResultSet rs;

    public DataBaseSelectHelper(String path, String nameDB, String login, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                cn = DriverManager.getConnection(path + nameDB, login, pass);
                try {
                    st = cn.createStatement();
                } catch (SQLException ex) {
                    log.info("Error in statement" + ex);
                }
            } catch (SQLException ex) {
                log.info("Error in create connection" + ex);
            }
        } catch (ClassNotFoundException ex) {
            log.info("Error in download driver" + ex);
        }
    }

    public void update(String sql) {
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            log.info("Error in apdation" + ex);
        }
    }

    public ResultSet query(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            log.info("Error in query" + ex);
        }
        return rs;
    }

    public void close() {
        try {
            st.close();
            cn.close();
        } catch (SQLException ex) {
            log.info("Error in close" + ex);
        }
    }

}
