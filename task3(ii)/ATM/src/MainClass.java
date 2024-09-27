import java.util.Scanner;

public class MainClass{
    public static void main(String[] args){
        atminterface operate = new atmimplement();
        int atmnumber= 12345;
        int atmpin= 1234;
        Scanner in= new Scanner(System.in);
        
        System.out.println("Welcome to the Atm Machine");
        System.out.print("Enter ATM number: ");
        int atmNumber = in.nextInt();
        
        System.out.print("Enter PIN: ");
        int atmPin = in.nextInt();
        
        if((atmnumber==atmNumber)&&(atmpin==atmPin)){
            while(true){
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
                System.out.println("Enter Choice : ");
                int choice=in.nextInt();
                if(choice==1){
                    operate.viewBalance();
                }
                else if(choice==2){
                    System.out.println("Enter Amount to WithDraw");
                    double withdrawAmount = in.nextDouble();
                    operate.withdrawAmount(withdrawAmount);
                }
                else if(choice==3){
                    System.out.println("Enter Amount to Deposit");
                    double depositAmount = in.nextDouble();
                    operate.depositAmount(depositAmount);
                }
                else if(choice==4){
                    operate.checkTransactionHistory();

                }
                else if(choice==5){
                    System.out.println("Collect your ATM Card\n THANK YOU");
                    System.exit(0);
                }
                else{
                    System.out.println("Pleae enter correct choice");
                }

                
            }
        }else{
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0);
        }

        
    }
}