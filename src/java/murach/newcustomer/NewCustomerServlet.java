/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.newcustomer;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import murach.business.Account;

import murach.business.User;
import murach.data.AccountDB;
import murach.data.UserDB;

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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //Verify all fields are filled out correctly.
        //Store data in user object.
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setAddress(address);
        user.setCity(city);
        user.setState(state);
        user.setZip(zip);
        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(password);
                    
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
            else if (UserDB.emailExists(user.getEmail())) {
                String message = "This email address already exists.<br>" +
                          "Please enter another email address.";
                
                session.setAttribute("message", message);
                url = "/new_customer.jsp";
            }            
            else if (UserDB.userNameExists(user.getUserName())) {
                String message = "This user name already exists.<br>" +
                          "Please enter another user name.";
                
                session.setAttribute("message", message);
                url = "/new_customer.jsp";
            }
            else if (UserDB.passwordExists(user.getPassword())) {
                String message = "This password already exists.<br>" +
                          "Please enter another password.";
                
                session.setAttribute("message", message);
                url = "/new_customer.jsp";
            }            
            else {
                //Clear all messages
                String message = "";                         
                session.setAttribute("message", message);
                
                String messageNull = "";                           
                session.setAttribute("messageNull", messageNull);  
                
                session.setAttribute("user", user); //Set user object in session.
                url = "/success.jsp"; //Set url to "success" page.
                UserDB.insert(user);  //Insert into database.
                
                Account account = new Account(user);
                account.setCheckingBalance(0.0);
                account.setSavingsBalance(25.00);
                session.setAttribute("account", account);
                AccountDB.update(account);
            }
        
        //Forward request and response objects to url.
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
