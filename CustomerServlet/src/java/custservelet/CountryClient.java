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
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CountryClient {

    private static final String BASE_URI = "http://localhost:8080/COUNTRY_REST/webresources/ws.countries/";

    public static void main(String[] args) {
        CountryClient countryTester = new CountryClient();
        countryTester.getCountry("PH");
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

            NodeList errNodes = doc.getElementsByTagName("countries");
            if (errNodes.getLength() > 0) {
                Element el = (Element) errNodes.item(0);
                String countryName = el.getElementsByTagName("countryName").item(0).getTextContent();
                String currencyCode = el.getElementsByTagName("currencyCode").item(0).getTextContent();
                String latitude = el.getElementsByTagName("latitude").item(0).getTextContent();
                String longtitude = el.getElementsByTagName("longtitude").item(0).getTextContent();

                country = new Country(countryCode, countryName, currencyCode, latitude, longtitude);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(country.toString());
        return country;
    }

}
