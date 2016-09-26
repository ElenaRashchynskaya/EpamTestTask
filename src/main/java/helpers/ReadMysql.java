package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/23/2016.
 */
public class ReadMysql {

    private static Logger log = Logger.getLogger("testLog");

    public static List<Account> run() {
        log.info("Read data from MySQL");
        List<Account> accountList = new ArrayList<Account>();

        DataBaseSelectHelper db = new DataBaseSelectHelper("jdbc:mysql://localhost/", "test", "root", "");
        ResultSet rs = db.query("SELECT login,password FROM account");
        try {
            while (rs.next()) {
                log.fine("login = " + rs.getString(1) + "\tpassword = " + rs.getString(2));

                accountList.add(new Account(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            log.severe("Error in rs" + ex);
        }
        db.close();

        //lets print Account list information
        for (Account account : accountList) {
            log.fine(account.toString());
        }

        return accountList;
    }

}




