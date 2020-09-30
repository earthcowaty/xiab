/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;

/**
 *
 * @author sarun
 */
public class BankFacade {

    /**
     * @param args the command line arguments
     */
    static ArrayList<AccountIf> cust1Accounts = new ArrayList();//สร้างArraylistเพื่อเก็บข้อมูลบัญชีทั้งหมดของลูกค้าคนที่ 1
    static ArrayList<AccountIf> cust2Accounts = new ArrayList();//สร้างArraylistเพื่อเก็บข้อมูลบัญชีทั้งหมดของลูกค้าคนที่ 2
    static CustomerIf cust1 = new BankCustomer("Earth", cust1Accounts);//สร้างข้อมูลลูกค้าคนที่ 1
    static CustomerIf cust2 = new BankCustomer("Xiang", cust2Accounts);//สร้างข้อมูลลูกค้าคนที่ 2
    
    //contructor ของ BankFacade
      public BankFacade () {
       AccountIf acc = new BankAccount(0001); //สร้างหมายเลขบัญชีแรกสำหรับลูกค้าคนที่หนึ่ง
       cust1Accounts.add(acc); //add หมายเลขบัญชีไปเก็บไว้ใน Arraylist ของลูกค้าคนที่1
       acc = new BankAccount(0002); //สร้างหมายเลขบัญชีที่สองสำหรับลูกค้าคนที่หนึ่ง
       cust1Accounts.add(acc); //add หมายเลขบัญชีไปเก็บไว้ใน Arraylist ของลูกค้าคนที่1
       acc = new BankAccount(0003); //สร้างหมายเลขบัญชีแรกสำหรับลูกค้าคนที่สอง
       cust2Accounts.add(acc); //add หมายเลขบัญชีไปเก็บไว้ใน Arraylist ของลูกค้าคนที่2
       acc = new BankAccount(0004); //สร้างหมายเลขบัญชีที่สองสำหรับลูกค้าคนที่สอง
       cust2Accounts.add(acc); //add หมายเลขบัญชีไปเก็บไว้ใน Arraylist ของลูกค้าคนที่2
    }
    
    public static void main(String[] args) {
      BankFacade obj = new BankFacade(); //สร้าง obj จาก BankFacade
      obj.doDeposit(2000,cust1,0001); //ฝากเงินให้ลูกค้าคนที่ 1 เลขบัญชี 0001
      obj.getBankAccount(cust1,0001); //แสดงยอดเงินของบัญชี 0001 
      obj.getBanCustomer("Earth"); 
      obj.doDeposit(1000,cust2,0003);
      obj.getBankAccount(cust2,0004);
      obj.getBanCustomer("Xiang");
    }
    
    //ฝากเงินให้ลูกค้าคนที่ x เลขบัญชี xx
     public void doDeposit (double amt, CustomerIf cust, int accNo){
        AccountIf acc = cust.getAccount(accNo);
        acc.deposit(amt);
        System.out.println("Deposit Success");
        System.out.println("-----------------------------------");
    }
    
    //แสดงยอดเงินของบัญชี x
    public void getBankAccount(CustomerIf cust, int accNo){ 
        AccountIf acc = cust.getAccount(accNo);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
        System.out.println("-----------------------------------");
    }
    
    //แสดงข้อมูลบัญชีทั้งหมดของลูกค้าคนที่ x รวมถึงแสดงยอดเงินในทุกบัญชีที่มีอยู่
    public void getBanCustomer(String custName) {
    if (cust1.getCustomerName().equals(custName)) { //เช็คว่าเป็นลูกค้าคนที่1 
        ArrayList<AccountIf> accounts = cust1.getllAccounts();
        System.out.println("Customer and account information");
        System.out.println("Name = " + cust1.getCustomerName());
        System.out.println("Has " + cust1.getNumAccounts() + " accounts");
        for(AccountIf account : accounts) {
            System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
           
        }
    } else if (cust2.getCustomerName().equals(custName)) { //เช็คว่าเป็นลูกค้าคนที่2
        ArrayList<AccountIf> accounts = cust2.getllAccounts();
        System.out.println("Customer and account information");
        System.out.println("Name = " + cust2.getCustomerName());
        System.out.println("Has " + cust2.getNumAccounts() + " accounts");
        for(AccountIf account : accounts) {
            System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
           
        }
    }
     System.out.println("-----------------------------------");
    }
}
