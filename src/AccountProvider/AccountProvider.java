package AccountProvider;

public interface AccountProvider {
    public String getMobile();
    public float getBalance();
    public boolean verify();
    public void setBalance(float balance);
}
