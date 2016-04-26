/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author John
 */

 
public class Account implements Serializable {
    
    private double balance = 0, debit = 0, credit = 0;
    private int type;
    private User user;

    public Account() {
         
    }
    
    public Account(User user, double balance) {
        
        this.user = new User();
        this.balance = balance;
    }
    
     
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
       
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
        
    public double credit(double credit) {
        if(credit <= 0) {
            return balance;
        }
        else {
            credit += balance;
        }
        return balance;
        }
    
    public double debit(double debit) {
        if (debit <= 0 || debit >= balance) {
            return balance;
        }
        else {
            debit -= balance;
        }
        return balance;
    }
   
    public enum Accounts {
    
     CHECKING(1), SAVINGS(2);
     
     Accounts(int value)
     {
         this.value = value;
     }
     
    private final int value;

    public int getValue(){return value;}
    }
    
    
}




          
   
    
