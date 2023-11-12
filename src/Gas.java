import java.lang.Math;
public class Gas extends UtilityBill {
    float amount;
    public Gas(){
        this.amount= (float) Math.random()*(200-100+1)+100;
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
        return "Gas";
    }
}
