package AccountProvider;

public class WalletProvider implements AccountProvider {
    String mobile;
    float balance;
    public WalletProvider(String mobile) {
        this.mobile = mobile;
    }
    WalletProvider(String mobile, float balance){
        this.mobile = mobile;
        this.balance = balance;
    }
    public String getMobile(){
        return mobile;
    }
    public float getBalance(){
        return balance;
    }
    public boolean verify() {
        WalletProvider w = WalletDB.check(this);
        if(w == null) return false;
        this.mobile = w.getMobile();
        this.balance = w.getBalance();
        return true;
    }
    public void setBalance(float bal) {
        this.balance = bal;
    }
}
