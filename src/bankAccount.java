import java.util.ArrayList;

public class bankAccount extends Account {
    ArrayList<bankAccount> accounts;

    bankAccount(String username){
        System.out.println("mariam");
    }
    public void addAccount(bankAccount account)
    {
        accounts.add(account);
    }
    public boolean transferToBank(int amount, String accountNum) {
        accountProvider bankTrans=new bankProvider(accountNum);
        if (bankTrans.verify()){
            //bank1.balance= bank1.balance-amount;
            bankTrans.addToBalance(amount);
        }

    }
}
