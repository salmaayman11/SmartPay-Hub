import java.util.ArrayList;

public class AccountDB {
    ArrayList<Account> accounts;
    public boolean check(Account acc){
        for (int i = 0; i < 5; i++) {
            if (acc.username == this.accounts[i].username) {
                return true;
            }
        }
        return false;
    }
    public boolean add(Account acc){
        if(!check(acc)){
            accounts.add(acc);
            return true;
        }
        return false;
    }

}
