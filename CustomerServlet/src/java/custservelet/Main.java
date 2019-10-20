/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custservelet;

/**
 *
 * @author Johanna
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Test calling RESTful web service with country as parameter i.e. PH");
        CountryClient countryTester = new CountryClient();
        countryTester.getCountry("PH");

        System.out.println("Test calling REST for Customer Listing");
        CustomerClient customerTester = new CustomerClient();
        customerTester.getCustomers();

        System.out.println("Test calling REST customer specific client");
        customerTester.getCustomer("1");
    }
}
