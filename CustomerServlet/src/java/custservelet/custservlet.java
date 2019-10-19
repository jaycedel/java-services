package custservelet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Johanna
 */
public class custservlet extends HttpServlet {

    private ServletContext context;

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

            request.setAttribute("customer", customer);
            context.getRequestDispatcher("/customer.jsp").forward(request, response);
        }
    }

}
