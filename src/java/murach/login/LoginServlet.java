/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.login;

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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url;
        HttpSession session = request.getSession();  //Get session object
        
        //Get parameters from request.
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //Verify data is correct and redirect to appropriate page.
        User user = (User) session.getAttribute("user"); //Get user object
        
        if (user == null) {
            String messageNull = "You are not registered or no longer registered. " +
                             "Please <a href=\"new_customer.jsp\">register now</a>.";
            
            session.setAttribute("messageNull", messageNull); //Set message if error.
            url = "/login.jsp"; //Set url to "login" page.
        }
        
        else if(user.getUserName().equals(userName) && //Match the user userName property
           user.getPassword().equals(password))   //Match the user password property
        {
            url = "/account_activity.jsp";
        }
        else
        {
            url = "/login_failure.jsp";
        }
        
        //Forward request and response objects to url.
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
         
    }
}
