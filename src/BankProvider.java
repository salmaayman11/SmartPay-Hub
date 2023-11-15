public class BankProvider implements AccountProvider {
    private String mobile;
    private float balance;
    private String accountNum;
    public BankProvider(String accountNum, String mobile) {
        this.accountNum = accountNum;
        this.mobile = mobile;
    }
    public BankProvider(String accountNum, String mobile, float balance) {
        this.accountNum = accountNum;
        this.mobile = mobile;
        this.balance = balance;
    }
    public String getMobile(){
        return mobile;
    }
    public float getBalance() {
        return balance;
    }
    public String getAccountNum() { return accountNum; }
    public void setBalance(float bal){
        this.balance = bal;
    }
    public boolean verify(){
        BankProvider b = BankDB.check(this);
        if (b == null) return false;
        this.mobile = b.getMobile();
        this.balance = b.getBalance();
        this.accountNum = b.getAccountNum();
        return true;
    }
}
