/*strat menu class */ 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Menu extends Account_INFO {
    String Acc,pass;          // declear string
    Scanner M_input=new Scanner(System.in);  // creating scanner class object
	 
public void view() {
    System.out.println("\n************WELCOME*********************\n");
    System.out.println("\nENTER  CHOICE : ");
    System.out.println("\nPRESS 1 FOR CHECK BALANCE : ");
    System.out.println("\nPRESS 2 FOR WITHDRAW FUNDS  : ");
    System.out.println("\nPRESS 3 FOR DISPOSIT :  ");
    System.out.println("\nPRESS 4 FOR EXIT  : ");
    System.out.println("\nENTER  CHOICE :");
    int choice=M_input.nextInt();  // get input
    // using switch case
    switch(choice){     
        case 1:         
            System.out.println("New Saving Balance Is : "+MoneyFormat.format(GetCheckBalance())); // print our account balance
            break;
       case 2:
           getCheckWithdrawInput();  // go to getCheckWithdrawInput() method and get withdraw money with your account
           break;
       case 3:
            getCheckDipositeInput(); // go to getCheckDipositeInput() method and take money dipost your account 
            break;
       case 4:   
           System.out.println("THANK YOU FOR USING OUR ATM.\n ");
           System.exit(0);  // exit out this atm
           break;
        default:     
            System.out.println("INVALIED INPUT.\n ");  // print default 
    }
 
}


public void LogIn() throws IOException {
	System.out.println("\n************LOGIN*********************\n");
          
         
        System.out.print("WELCOME TO UNITY ATM ....");
        System.out.print("\nENTER YOUR ACCOUNT NUMER: ");
        Acc = M_input.next();   // get account number
        SetCustomerNum(Integer.valueOf(Acc));  // call a method and sent account nummber
            
        System.out.print("\nENTER YOUR PIN NUMER: ");
        pass = M_input.next();  // get pin number
        SetPinNumber(Integer.valueOf(pass));   // call a method and sent pin number
        // create file for read
        FileReader Read=new FileReader("C:/Users/emon/Documents/NetBeansProjects/emon/tex.txt");
        // create an BufferedReader object ;
        BufferedReader Br=new BufferedReader(Read);   
        String line;    // Declare string
        Boolean test=false;   // delcare test false
        while ((line = Br.readLine()) != null)   // this loop will run till br.readLine not equals to null 
        {
            String[] token = line.split("\\s");  // seperate string using space
            //System.out.println(token[0]+" "+token[1]+" "+token[2]);
            if(Acc.equals(token[1]) && pass.equals(token[2]) ) {  // check our acc is equals to token[1] and pass is equals to token[2]
            	   System.out.println("SUCCESSFULLY LOG IN \n");  // print message  
            	   test=true; 
            	   while(true){  // strat while
                        view();  // call method view()
            	   }
            }
        }
        // if test is false
        if(!test) {
           System.out.println("WRONG INFORMATION.PLEASE TRY AGAIN.\n\nENTER 1 TO MOVE TO REGISTER PAGE .\n\nENTER 2 FOR MOVE TO LOGIN PAGE.\n");
           int choice=input.nextInt();  // get a choice again
            switch(choice){  // strat a switch case
                case 1:
                    Registr();  // go to Registr() method 
                    break;
                case 2:
                    LogIn();   // go to LogIn() method 
                    break;
               default:
                   System.out.println("INVALIED INPUT.\n "); // print default
            }
           }
    }
          
public void Registr() throws IOException {
    String account,password,Cname;
           System.out.println("\n************REGESTRATION*********************\n");
           System.out.print("\nENTER YOUR NAME : ");
            Cname=M_input.nextLine();  // get name 
           System.out.print("\nACCOUNT NUMBER : ");
            account= M_input.nextLine();  // get name 
           System.out.print("\nPIN NUMBER : ");
            password= M_input.nextLine();  // get pin
           
           String str = Cname+" "+account+" "+password;   // Store all of user 
           // BufferedWriter class create a object 
           BufferedWriter write = new BufferedWriter(new FileWriter("C:/Users/emon/Documents/NetBeansProjects/emon/tex.txt", true));
           write.append(str);  // using append mode to write
           write.newLine();  // get new line
           write.close();   // close 
           System.out.println("HELLO,"+Cname+"  YOU ARE SUCCESSFULLY REGISTERED..!!\n");
           LogIn();  // go to login
    }
}