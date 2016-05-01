/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.business;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author John
 */
@Entity
public class TransItems implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transItemsId;
    
    private String transFrom, transTo;
    
    private double transAmt;
    
    private Timestamp dateTime = Timestamp.valueOf(LocalDateTime.MIN);
    
    private double checkingBalance, savingsBalance;
        
    public TransItems() {} //Default Constructor

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setTransItemsId(Long transItemsId) {
        this.transItemsId = transItemsId;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }    
                
    public Long getTransItemsId() {
        return transItemsId;
    }

    public String getTransFrom() {
        return transFrom;
    }

    public void setTransFrom(String transFrom) {
        this.transFrom = transFrom;
    }

    public String getTransTo() {
        return transTo;
    }

    public void setTransTo(String transTo) {
        this.transTo = transTo;
    }

    public double getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double balance) {
        this.checkingBalance = balance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }
}   