package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/22/2016.
 */


public class ReadCSVFile {
    private static Logger log = Logger.getLogger("testLog");

    public static ArrayList<Account> run() throws IOException {

        log.info("Read data from CSV");
        List<Account> accountList = new ArrayList<Account>();
        String csvFile = "data/login_password.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
//
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] accountLine = line.split(cvsSplitBy);
                log.fine("Account email= " + accountLine[0] + " , password=" + accountLine[1] + "]");

                accountList.add(new Account(accountLine[0], accountLine[1]));
            }

            //lets print Account list information
            for (Account account : accountList) {
                log.fine(account.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.warning("Read CSV - Failed: "+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            log.warning("Read CSV - Failed: "+e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return (ArrayList<Account>) accountList;
    }


}
