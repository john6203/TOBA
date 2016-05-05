/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author John
 */

@Entity
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId = 0L;
    
    public enum AccountType {CHECKING, SAVINGS;}
    
    private double checkingBalance = 0.00;
    private double savingsBalance = 0.00;
    
    private double credit = 0.00, debit = 0.00;
        
    private List<TransItems> transactions = new ArrayList<>();
    
    @ManyToOne	
    private User user;

    public Account() {
    }
       
    public Account(User user) {
        this.user = user;            
    }
    
    public void addTransaction(TransItems item) {
                 
        for (int i = 0; i < transactions.size(); i++) {
            transactions.get(i);
                            
            }
        transactions.add(item);  
        }    
                    
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingBalance) {
        this.savingsBalance = savingBalance;
    }
            
       
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void credit(double credit, Account.AccountType acctType) {
        if(acctType.equals(Account.AccountType.CHECKING)) {
           this.checkingBalance += credit; 
        }
        else {
            this.savingsBalance += credit;
        }
     }
    
    public void debit(double debit, Account.AccountType acctType) {        
        if(acctType.equals(Account.AccountType.CHECKING)) {
           this.checkingBalance -= debit; 
        }
        else {
            this.savingsBalance -= debit;
        }       
    }
                
    public boolean badFunds (Account.AccountType accountType, double balance, 
                             double debit) {
        return balance < debit;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public List<TransItems> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransItems> transactions) {
        this.transactions = transactions;
    }
    
    

} 




          
   
    
