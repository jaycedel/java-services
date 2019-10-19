/*
 * This is group assignment 
 */
package com.unique;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dipak Rijal
 */
@WebService(serviceName = "TEMP_Convert_Server")
public class TEMP_Convert_Server {

/**
     * Web service operation to convert Fahrenheit to Celsius.
     */
    @WebMethod(operationName = "FahToCelsius")
    public float FahToCelsius(@WebParam(name = "temp") float temp) {

        float result=(temp-32)*5/9;
        return result;
       
    }

    /**
     * Web service operation to convert Celsius to Fahrenheit. 
     */
    @WebMethod(operationName = "CelsiusToFah")
    public float CelsiusToFah(@WebParam(name = "temp") float temp) {
        float result=(temp*9/5)+32;
        return result;
        
    }
}
