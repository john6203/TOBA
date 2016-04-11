/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.reset;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import murach.business.User;

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
        String passwordNew = request.getParameter("passwordNew");
        
        //Verify new password.
        if (passwordNew == null || passwordNew.isEmpty() || passwordNew.contains(" ")
            || passwordNew.length() < 8 || passwordNew.length() > 25) {
            String message = "Password is not reset. Please enter a valid new" +
                              " password: cannot be blank, minimum 8 characters," +
                              " maximum 25 characters and no spaces";
            
            session.setAttribute("message", message); //Set message if error.
            url = "/password_reset.jsp"; //Set url to "new_customer" page.            
        }
        else {
            User user = (User) session.getAttribute("user"); //Get user object
            
            user.setPassword(passwordNew);                  //Set to new password
            
            String message = "";                           //Clear message
            session.setAttribute("message", message);      
            
            session.setAttribute("user", user);           //Add user to session
            url = "/account_activity.jsp";                //Redlrect
        }

        //Forward request and response objects to url.
        getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
         
    }
}
