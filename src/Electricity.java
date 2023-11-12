import java.lang.Math;
public class Electricity extends UtilityBill {
    float amount;
    public Electricity(){
        this.amount= (float) Math.random()*(1000-200+1)+200;
    }

    public boolean pay(AccountProvider provider){
        if (provider.getBalance() >= this.amount) {
            provider.setBalance(provider.getBalance()-this.amount);
            return true;
            //System.out.println("Payment successful. Remaining balance: $" + provider.getBalance());
        } else {
            //System.out.println("Insufficient funds. Payment failed.");
            return false;
        }
    }

    public String getType(){
        return "Electricity";
    }
}
