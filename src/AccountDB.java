
import java.util.ArrayList;
import java.util.Arrays;

public class AccountDB {
    //ArrayList<Account> accounts;
    static ArrayList<Account> accounts = new ArrayList<Account>(Arrays.asList(
            new Account("Tony_70", "S3cur3P@ss"),
            new Account("Sony_10", "P@ssw0rd1"),
            new Account("Mona_15", "Str0ngP@ss"),
            new Account("Salama_00", "Ch@ll3ng3Me!"),
            new Account("Mariam_20", "P@ssw0rd!12"),
            new Account("Peter_70", "H1ghlyS3cur3#"),
            new Account("Harry_70", "R@nd0mP@ss!")
    ));

    public static boolean check(Account inputAccount) {
        for (Account acc : accounts) {
            if(acc.username == inputAccount.username && acc.password==inputAccount.password) {
                return true;
            }
        }
        return false;
    }
    public static boolean check(String inputUsername) {
        for (Account acc : accounts) {
            if(acc.username == inputUsername) {
                return true;
            }
        }
        return false;
    }
    public static boolean add(Account acc){
        if(!check(acc)){
            accounts.add(acc);
            return true;
        }
        return false;
    }

    public static Account getAccount(String inputUsername) {
        for (Account acc : accounts) {
            if(acc.username == inputUsername) {
                return acc;
            }
        }
        return null;
    }
}
