/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.newcustomer;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import murach.business.User;

/**
 *
 * @author John
 */
public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Create session
        HttpSession session = request.getSession();  //Get session object
        
        String url;
                
        //Get parameters from request.
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String email = request.getParameter("email");
        String userName = lastName + zip; //Assigned userName for now.
        String password = "welcome1";     //Assigned password for now.
        
        //Verify all fields are filled out correctly.
        //Store data in user object.
        User user = new User(firstName, lastName, phone, address, city, 
                            state, zip, email, userName, password);
                    
            if(user.getFirstName() == null || user.getFirstName().isEmpty() ||
               user.getLastName() == null || user.getLastName().isEmpty() ||
               user.getPhone() == null || user.getPhone().isEmpty() ||
               user.getAddress() == null || user.getAddress().isEmpty() ||
               user.getCity() == null || user.getCity().isEmpty() ||
               user.getState() == null || user.getState().isEmpty() ||
               user.getZip() == null || user.getZip().isEmpty() ||
               user.getEmail() == null || user.getEmail().isEmpty() ||
               user.getUserName() == null || user.getUserName().isEmpty() ||
               user.getPassword() == null || user.getPassword().isEmpty()) {
                
               String message = "Please fill out all the text boxes.";
               
               session.setAttribute("message", message); //Set message if error.
               url = "/new_customer.jsp"; //Set url to "new_customer" page.            
            }
            else if (user.getPassword().contains(" ") ||  //No white spaces
                     user.getPassword().length() < 8 ||   //Min. 8 characters
                     user.getPassword().length() > 25) {  //Max. 25 characters
                String message = "Please enter a valid password:" +
                                 " minimum 8 characters, maximum 25 characters"  
                                 + " and no spaces.";
                
                session.setAttribute("message", message); //Set message if error.
                url = "/new_customer.jsp"; //Set url to "new_customer" page. 
            }
            else {
                //Clear all messages
                String message = "";                         
                session.setAttribute("message", message);
                
                String messageNull = "";                           
                session.setAttribute("messageNull", messageNull);  
                
                session.setAttribute("user", user); //Set user object in session.
                url = "/success.jsp"; //Set url to "success" page.        
            }
        
        //Forward request and response objects to url.
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
