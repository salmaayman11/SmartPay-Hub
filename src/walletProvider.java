public class walletProvider {
    String mobile;
    float balance;
    walletDB wallet;
    walletProvider(String mobile){
        this.mobile=mobile;
    }
    public String getMobile(){
        return mobile;
    }
    public float getBalance(){
        return balance;
    }
    public boolean verify(){
        return wallet.check(this);
    }
    public void setBalance(float balance){

    }
}
