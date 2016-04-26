/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.reset;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;

/**
 *
 * @author John
 */
public class PasswordResetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        HttpSession session = request.getSession();  //Get sessiion object
        
        String url;
                
        //Get parameter from request.
        String userName = request.getParameter("userName");
        String password = request.getParameter("passwordCurrent");
        String passwordNew = request.getParameter("passwordNew");
        
        //Store in User Object
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        
        //Verify new password.
        if (UserDB.userNameExists(user.getUserName()) == false ||  
            UserDB.passwordExists(user.getPassword()) == false)    
        {
            String message = "User name and/or current passward entered incorrectly." +
                              " Password cannot be reset until verification of" +
                              " user name and current password. Please try again.";
            
            session.setAttribute("message", message); //Set message if error.
            url = "/password_reset.jsp"; //Set url to "new_customer" page.     
        }
        else if (passwordNew == null || passwordNew.isEmpty() || passwordNew.contains(" ")
            || passwordNew.length() < 8 || passwordNew.length() > 25) {
            
            String message = "Password is not reset. Please enter a valid new" +
                              " password: cannot be blank, minimum 8 characters," +
                              " maximum 25 characters and no spaces.";
            
            session.setAttribute("message", message); //Set message if error.
            url = "/password_reset.jsp"; //Set url to "new_customer" page.            
        }
        else {
            
            password = passwordNew;
            user.setPassword(password);                  //Set to new password
            UserDB.update(user);
            
            String message = "";                           //Clear message
            session.setAttribute("message", message);      
            
            session.setAttribute("user", user);           //Add user to session
            url = "/login.jsp";                //Redlrect
                     
        }

        //Forward request and response objects to url.
        getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
         
    }
}
