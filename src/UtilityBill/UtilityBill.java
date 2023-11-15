package UtilityBill;

import AccountProvider.AccountProvider;

public abstract class UtilityBill {
    float amount;
    public void pay(AccountProvider account) {
        if (account.getBalance() >= this.amount) {
            account.setBalance(account.getBalance()-this.amount);
            System.out.println("Payment successful. Remaining balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Payment failed.");
        }
    }
    public void printBill(){
        System.out.println("Bill Type: " + this.getType());
        System.out.println("Amount: $" + this.amount);
    }
    public abstract String getType();
}

