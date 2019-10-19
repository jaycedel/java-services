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

public class CountryClient {

    private static final String BASE_URI = "http://localhost:8080/WebApplication1/webresources/custs.customers/";

    public static void main(String[] args) {
        CountryClient customerTester = new CountryClient();
        customerTester.getCountry("PH");
    }

    public Country getCountry(String countryCode) {
        Country country = null;
        try {

            //https://chillyfacts.com/java-send-url-http-request-read-xml-response/
            URL obj = new URL(BASE_URI.concat(countryCode));
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

            NodeList errNodes = doc.getElementsByTagName("customers");
            if (errNodes.getLength() > 0) {
                Element el = (Element) errNodes.item(0);
                String code = el.getElementsByTagName("code").item(0).getTextContent();
                String latitude = el.getElementsByTagName("latitude").item(0).getTextContent();
                String longtitude = el.getElementsByTagName("longtitude").item(0).getTextContent();

                country = new Country(code, latitude, longtitude);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return country;
    }

}
