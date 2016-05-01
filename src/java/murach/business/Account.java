/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author John
 */

@Entity
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    public enum AccountType {CHECKING, SAVINGS;}
    
    private double checkingBalance = 0.00;
    private double savingBalance = 0.00;
	
    private AccountType accountType;
    
    @ManyToOne	
    private User user;
		
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<TransItems> transactions;
    
    public Account(User user) {
        this.user = user;
        transactions = new ArrayList<>();
        
    }
        
    public void addTransactions(TransItems item) {
                 
        for (int i = 0; i < transactions.size(); i++) {
            TransItems get = transactions.get(i);
            
                return;
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
        return savingBalance;
    }

    public void setSavingsBalance(double savingBalance) {
        this.savingBalance = savingBalance;
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
            this.savingBalance += credit;
        }
     }
    
    public void debit(double debit, Account.AccountType acctType) {        
        if(acctType.equals(Account.AccountType.CHECKING)) {
           this.checkingBalance -= debit; 
        }
        else {
            this.savingBalance -= debit;
        }       
    }

    public AccountType getType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
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

} 




          
   
    
