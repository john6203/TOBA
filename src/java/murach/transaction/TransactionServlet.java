/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.transaction;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import murach.business.Account;
import murach.data.AccountDB;
import murach.business.TransItems;

/**
 *
 * @author John
 */
public class TransactionServlet extends HttpServlet {

    private Timestamp dateTime;
    
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
        
        //Get transactions
        Account account = (Account) session.getAttribute("account");
                
        //Perform transfer
        if("Checking".equals(transFrom) && "Savings".equals(transTo) &&
           !account.badFunds(Account.AccountType.CHECKING, account.getCheckingBalance(), 
            transAmt) ) {
            
            //Debit checking            
            account.debit(transAmt, Account.AccountType.CHECKING);
            account.setCheckingBalance(account.getCheckingBalance());
                        
            //Credit savings             
            account.credit(transAmt, Account.AccountType.SAVINGS);
            account.setSavingsBalance(account.getSavingsBalance());
            
        }        
        else if("Checking".equals(transTo) && "Savings".equals(transFrom) &&
           !account.badFunds(Account.AccountType.SAVINGS, account.getSavingsBalance(), 
            transAmt) ) {
            
            //Debit checking
            account.debit(transAmt, Account.AccountType.SAVINGS);
            account.setSavingsBalance(account.getSavingsBalance());
                        
            //Credit savings
            account.credit(transAmt, Account.AccountType.CHECKING);
            account.setCheckingBalance(account.getCheckingBalance());
        }
        else {
            //Error message
            String message = "Insufficient Funds";
            
            session.setAttribute("message", message);
            url = "/transaction.jsp";
        }
        
        TransItems transItem = new TransItems();
        transItem.setDateTime(dateTime);
        transItem.setTransItemsId(Long.MIN_VALUE);
        transItem.setTransFrom(transFrom);
        transItem.setTransTo(transTo);
        transItem.setTransAmt(transAmt);
        transItem.setCheckingBalance(transItem.getCheckingBalance());
        transItem.setSavingsBalance(transItem.getSavingsBalance());
        
        account.addTransactions(transItem);
        session.setAttribute("account", account);
            url = "/account_activity.jsp";
            AccountDB.update(account);
        
        
        
         
    }
}
