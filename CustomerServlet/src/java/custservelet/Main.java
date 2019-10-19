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
        System.out.println("CALLING REST COUNTRY CLIENT FOR PHILIPPINES WITH PARAMETER PH");
        CountryClient countryTester = new CountryClient();
        countryTester.getCountry("PH");

        System.out.println("CALLING REST FOR CUSTOMER LISTINGS");
        CustomerClient customerTester = new CustomerClient();
        customerTester.getCustomers();

        System.out.println("CALLING REST CUSTOMER SPECIFIC CLIENT");
        customerTester.getCustomer("1");
    }
}
