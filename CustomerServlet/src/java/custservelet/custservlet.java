package custservelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unique.TEMPConvertServer_Service;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Johanna
 */
public class custservlet extends HttpServlet {

    private ServletContext context;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/TEMP_Convert_Server.wsdl")
    private TEMPConvertServer_Service service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String custId = request.getParameter("custId");
        CustomerClient client = new CustomerClient();
        if (action == null) {
            //Call customer rest populating request object customers
            request.setAttribute("customers", client.getCustomers());
            context.getRequestDispatcher("/list.jsp").forward(request, response);
        }

        if ("search".equals(action)) {
            //call rest for customer details
            Customer customer = client.getCustomer(custId);

            //Call rest for country details
            CountryClient countryRestCall = new CountryClient();
            Country countryDetails = countryRestCall.getCountry(customer.getCountry());
            customer.setLatitude(countryDetails.getLatitude());
            customer.setLongtitude(countryDetails.getLongtitude());
            customer.setCountryName(countryDetails.getCountryName());
            customer.setCurrencyCode(countryDetails.getCurrencyCode());
            request.setAttribute("customer", customer);
            context.getRequestDispatcher("/customer.jsp").forward(request, response);
        }

        if ("temperature".equals(action)) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                float temp = Float.parseFloat(request.getParameter("txt1"));

                String btn = request.getParameter("b1");

                if (btn.equals("Fahrenheit")) {
                    out.print("Temperature in fahrenheit: " + celsiusToFah(temp));
                }
                if (btn.equals("Celsius")) {
                    out.print("Temperature in Celsius :" + fahToCelsius(temp));
                }
            }
        }
    }

    private float celsiusToFah(float temp) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.unique.TEMPConvertServer port = service.getTEMPConvertServerPort();
        return port.celsiusToFah(temp);
    }

    private float fahToCelsius(float temp) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.unique.TEMPConvertServer port = service.getTEMPConvertServerPort();
        return port.fahToCelsius(temp);
    }
}
