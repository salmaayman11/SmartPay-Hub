public class WalletProvider implements AccountProvider {
    String mobile;
    float balance;
    WalletProvider(String mobile){
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
    public boolean verify(){
        boolean WalletDB.check(this);
    }
    public void setBalance(float bal) {
        this.balance = bal;
    }
}
