/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custservelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        
       // List<Customer> customers = client.get_response();

        if (action == null) {
            request.setAttribute("customers", client.getCustomers());
            context.getRequestDispatcher("/list.jsp").forward(request, response);
        }

        if ("search".equals(action)) {
            request.setAttribute("customer", client.getCustomer(custId));
            context.getRequestDispatcher("/customer.jsp").forward(request, response);
        }
    }

}
