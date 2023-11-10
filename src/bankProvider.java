public class bankProvider implements accountProvider{
    String mobile;
    float balance;
    String accountNum;
    bankDB bank;
    public bankProvider(String accountNum){
        this.accountNum=accountNum;
    }
    public String getMobile(){
        return mobile;
    }

    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance){
        this.balance=balance;
    }
    public void addToBalance(float amount){
        this.balance=this.balance+amount;
    }
    public boolean verify(){
        return bank.check(this);
    }

}
