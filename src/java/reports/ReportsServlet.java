/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.swing.UIManager.get;
import murach.business.Reports;
import murach.business.User;

/**
 *
 * @author John
 */

public class ReportsServlet extends HttpServlet {

    private String url;
    
    int currentMth = Calendar.getInstance().get(Calendar.MONTH);
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();  //Get sessiion object
        
        List<User> users = Reports.selectMonthlyUsers();
        
        
        for (int i = 0; i < users.size(); i++) {
            users.get(i);
            
        }
        
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
        
} 
