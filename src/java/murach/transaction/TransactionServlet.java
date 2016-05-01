/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.transaction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import murach.business.Account;
import murach.data.AccountDB;

/**
 *
 * @author John
 */
public class TransactionServlet extends HttpServlet {
    
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
        String transFrom = request.getParameter("transFrom");
        String transTo = request.getParameter("transTo");
        double transAmt = Double.parseDouble(request.getParameter("transAmt"));
        
        //Get AccountDB
        Account account = (Account) session.getAttribute("account");
        
        //Perform transfer
        if("Checking".equals("transFrom") && "Savings".equals("transTo") &&
           !account.badFunds(Account.AccountType.CHECKING, account.getCheckingBalance(), 
            transAmt) ) {
            
            //Debit checking            
            account.debit(transAmt, Account.AccountType.CHECKING);
            account.setCheckingBalance(account.getCheckingBalance());
                        
            //Credit savings             
            account.credit(transAmt, Account.AccountType.SAVINGS);
            account.setSavingsBalance(account.getSavingsBalance());
            
            String message = "";                           //Clear message
            session.setAttribute("message", message);
            
            
            session.setAttribute("account", account);   //Add user to session
            url = "/login.jsp";                   //Redlrect
            AccountDB.update(account);                  //Update user
                
        }
        else {
            //Error message
            String message = "Insufficient Funds";
            
            session.setAttribute("message", message);
        }
        
        if("Checking".equals("transTo") && "Savings".equals("transFrom") &&
           !account.badFunds(Account.AccountType.SAVINGS, account.getSavingsBalance(), 
            transAmt) ) {
            
            //Debit checking
            account.debit(transAmt, Account.AccountType.SAVINGS);
            account.setSavingsBalance(account.getSavingsBalance());
                        
            //Credit savings
            account.credit(transAmt, Account.AccountType.CHECKING);
            account.setCheckingBalance(account.getCheckingBalance());
            
            String message = "";                           //Clear message
            session.setAttribute("message", message);
            
            
            session.setAttribute("account", account);   //Add user to session
            url = "/login.jsp";                   //Redlrect
            AccountDB.update(account);                  //Update user
                
        }
        else {
            //Error message
            String message = "Insufficient Funds";
            
            session.setAttribute("message", message);
        }
         
    }
}
