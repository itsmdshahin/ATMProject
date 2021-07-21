 
import java.text.DecimalFormat;
import java.util.Scanner;
public class Account_INFO {
    // instance variable  
    private int customerNumber;
    private int pinNumber;
    private double checkBalance;
   
    Scanner input=new Scanner(System.in);  // Create an scanner object
    DecimalFormat MoneyFormat=new DecimalFormat("'$'####,##,##0.00");  // set decimal format
    
    public void SetCustomerNum(int customerNumber){   // set customer number 
        this.customerNumber=customerNumber;  
    }
    
    public int GetCustomerNumber(){   //method to get customer number
        return  customerNumber;   // return customer number
    }
    
    public void SetPinNumber(int pinNumber){  //method to set pin number
       this. pinNumber=pinNumber;  
    }
    
    public int GetPinNumber(){  // get Pin number
        return pinNumber;   // return pin number
    }
    
    public double GetCheckBalance(){  // get Main balance  
        return checkBalance;   // return our main balance 
    }
   
    public double CalCheckWithdraw(double amount){  // withdraw some money using this method
        checkBalance=checkBalance-amount;   // main balance - user enter balance
        return checkBalance;   // return our  main balance
    }
    
    public double CalCheckDiposite(double amount){   // Diposite some money using this method
        checkBalance += amount;    // main balance + user enter balance
        return   checkBalance;   // return our  main balance
    }
    
    public void getCheckWithdrawInput(){
        System.out.println("\nENTER THE AMOUNT YOU WANT TO WITHDRAW :");  
        double amount = input.nextDouble();
        if(checkBalance-amount>=0){     // if our accout is no less than equals 0 
            // call methodCalCheckWithdraw 
              System.out.println("\nNOW YOUR NEW ACCOUNT BALANCE IS: "+MoneyFormat.format(CalCheckWithdraw(amount)) );
        }
        else {
            // print our main balance
              System.out.println("\nYOU HAVE NOT SUFFECIENT BALANCE.YOU HAVE ONLY $ "+checkBalance);
        }
    }
    
    
    public void getCheckDipositeInput(){
       System.out.println("\nYOUR ACCOUNT BALANCE IS : "+MoneyFormat.format(checkBalance));   // print balance
        System.out.println("\nENTER THE AMOUNT YOU WANT TO DIPOSITE IN YOUR MAIN ACCOUNT : ");
        double amount =input.nextDouble();   // get input
        if((checkBalance+amount)>=0){ 
            // call method CalCheckDipostie  
            System.out.print("\nYOUR NEW MAIN BALANCE IS : "+MoneyFormat.format(CalCheckDiposite(amount)));
        }
        else {
              System.out.print("\nBALANCE CAN NOT BE NEGATIVE .\n");  /// print
        }
    }
}