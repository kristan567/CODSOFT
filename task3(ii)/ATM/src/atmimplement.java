import java.util.Map;
import java.util.HashMap;

public class atmimplement implements atminterface {

    ATM atm = new ATM();
    Map<Double,String> ministmt= new HashMap<>();

    @Override
    public void viewBalance() {
       
        System.out.println("Available Balance is : "+atm.getbalance());
       
    }

    @Override
    public void depositAmount(double depositAmount) {
        // Add implementation logic here
        ministmt.put(depositAmount," Amount deposited");
        System.out.println(depositAmount+"Deposited Successfully !!");
        atm.setbalance(atm.getbalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%500==0){
            if (withdrawAmount<=atm.getbalance()) {
                System.out.println("Withdrawing: " + withdrawAmount);
                ministmt.put(withdrawAmount," Amount WithDrawn");
                System.out.println("Collect the Cash: " + withdrawAmount);
                
                atm.setbalance(atm.getbalance()-withdrawAmount);
                viewBalance();
            }
            else {
                System.out.println("Insufficient Balance!");
            }
        }else{
            System.out.println("PLease Enter multiple of 500!!");
        }
        
        
        // Add implementation logic here
        
    }

    @Override
    public void checkTransactionHistory() {
        // Add implementation logic here
       for(Map.Entry<Double,String>m:ministmt.entrySet()){
        System.out.println(m.getKey()+""+m.getValue());
       }
    }
}
