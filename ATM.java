 
import java.io.IOException;
import java.util.Scanner;
/*libary*/
// declare main class ATM
public class ATM {
    public static void main(String args[]) throws IOException{ // using throws IOException to ignore error
    
     
      System.out.print("***********************************************************************\n\n\n");
      System.out.print("***              WELCOME UNITY ATM BANK                  ***\n\n");
      System.out.print("***********************************************************************\n\n");
    
     System.out.println("ENTER YOUR CHOICE :\n");
     System.out.println("ENTER 1 IF YOU WANT TO REGISTER :\n");
     System.out.println("ENTER 2 IF YOU WANT TO LOGIN :\n");
     Menu op=new Menu();  // create a object
        
        Scanner input=new Scanner(System.in);  
        int choice=input.nextInt();    // get input
                    switch(choice){    // switch case
                    case 1: 
                        op.Registr();    // go to Registr() method 
                        break;
                    case 2:
                        op.LogIn();  // go to LogIn() method
                        break;
                    default:
                        System.out.println("INVALIED INPUT.\n ");
                }
   
    }
}
