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
import murach.data.UserDB;

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
        HttpSession session = request.getSession();  //Get sessiion object
        
        String url;
                
        //Get parameters from request.
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //Verify data is correct and redirect to appropriate page.
        
       User user = new User();
       user.setUserName(userName);
       user.setPassword(password);
        
        if (UserDB.userNameExists(user.getUserName()) &&  
            UserDB.passwordExists(user.getPassword()))    
        {
            url = "/account_activity.jsp"; //User name and password match
            
            session.setAttribute("user", user);
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
