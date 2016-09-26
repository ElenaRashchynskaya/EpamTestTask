package helpers;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Lenovo on 9/22/2016.
 */


public class ReadXMLFile {
    private static Logger log = Logger.getLogger("testLog");

    public static List<Account> run() {
        List<Account> accountList = new ArrayList<Account>();
        log.info("Read data from XML");
        try {

            File fXmlFile = new File("data/login_password.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            log.info("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("account");

            log.info("----------------------------");


            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                accountList.add(getAccount(nodeList.item(temp)));
            }

            log.fine("print Account list information");
            for (Account account : accountList) {
                log.fine(account.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.warning("Read XML - Failed: \"+e.getMessage()");
        }
        return accountList;
    }


    private static Account getAccount(Node node) {

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            Account account = new Account(getTagValue("email", element), getTagValue("password", element));
            return account;
        }
        return null;

    }

    private static String getTagValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getTextContent();

    }
}
