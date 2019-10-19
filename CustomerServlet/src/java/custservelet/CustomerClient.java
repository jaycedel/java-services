/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custservelet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CustomerClient {

    private static final String BASE_URI = "http://localhost:8080/WebApplication1/webresources/custs.customers/";

    public static void main(String[] args) {
        CustomerClient customerTester = new CustomerClient();
        customerTester.getCustomers();
        customerTester.getCustomer("1");
    }

    /*
    This will call the rest service for customers
     */
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        try {

            //https://chillyfacts.com/java-send-url-http-request-read-xml-response/
            URL obj = new URL(BASE_URI);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            //System.out.println(response.toString());
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(response.toString())));

            //https://stackoverflow.com/questions/14566596/loop-through-all-elements-in-xml-using-nodelist
            Element docElement = doc.getDocumentElement();
            NodeList nodeList = docElement.getChildNodes();
            int length = nodeList.getLength();

            for (int i = 0; i < length; i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nodeList.item(i);
                    if (el.getNodeName().contains("customer")) {
                        String id = el.getElementsByTagName("id").item(0).getTextContent();
                        String name = el.getElementsByTagName("name").item(0).getTextContent();
                        String country = el.getElementsByTagName("country").item(0).getTextContent();
                        String balance = el.getElementsByTagName("balance").item(0).getTextContent();
                        Customer cust = new Customer(Integer.parseInt(id), name, country, Double.parseDouble(balance));
                        customers.add(cust);
                        System.out.println("Adding ".concat(name));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return customers;
    }

    public Customer getCustomer(String customerId) {
        Customer customer = null;
        try {

            //https://chillyfacts.com/java-send-url-http-request-read-xml-response/
            URL obj = new URL(BASE_URI.concat(customerId));
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            //System.out.println(response.toString());
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(response.toString())));

            //https://stackoverflow.com/questions/14566596/loop-through-all-elements-in-xml-using-nodelist

            NodeList errNodes = doc.getElementsByTagName("customers");
            if (errNodes.getLength() > 0) {
                Element el = (Element) errNodes.item(0);
                String id = el.getElementsByTagName("id").item(0).getTextContent();
                String name = el.getElementsByTagName("name").item(0).getTextContent();
                String country = el.getElementsByTagName("country").item(0).getTextContent();
                String balance = el.getElementsByTagName("balance").item(0).getTextContent();
                customer = new Customer(Integer.parseInt(id), name, country, Double.parseDouble(balance));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print("Getting name ");
        System.out.print(customer.getName());
        return customer;
    }

}
