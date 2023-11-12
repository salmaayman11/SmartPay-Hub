public abstract class UtilityBill {
    float amount;
    public abstract boolean pay(AccountProvider provider);
    public void printBill(){
        System.out.println("Bill Type: " + this.getType());
        System.out.println("Amount: $" + this.amount);
    }
    public abstract String getType();
}
