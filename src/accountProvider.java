public interface accountProvider {
    public String getMobile();
    public float getBalance();
    public void addToBalance(float amount);
    public boolean verify();
    public void setBalance(float balance);
}
