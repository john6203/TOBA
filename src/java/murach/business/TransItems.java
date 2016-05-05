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
import javax.persistence.ManyToOne;

/**
 *
 * @author John
 */
@Entity
public class TransItems implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transItemsId;
    
    private String transFrom = "", transTo = "";
    
    private double transferAmt = 0.00;
    
    private Timestamp transDate = Timestamp.valueOf(LocalDateTime.MIN);
    
    private double checkingBalance, savingsBalance, credit, debit;
    
    @ManyToOne       
    private Account account;
                
    public TransItems() {
        
        transItemsId = 0L;
    } //Constructor

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }    
    
    public double getTransferAmt() {
        return transferAmt;
    }

    public void setTransferAmt(double transferAmt) {
        this.transferAmt = transferAmt;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    public Timestamp getDateTime() {
        return transDate;
    }

    public void setDateTime(Timestamp transDate) {
        this.transDate = transDate;
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
        return transferAmt;
    }

    public void setTransAmt(double transAmt) {
        this.transferAmt = transAmt;
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
    
    
    
}   