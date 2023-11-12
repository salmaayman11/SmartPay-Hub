import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class BankDB {
    static ArrayList<BankProvider> banks = new ArrayList<BankProvider>(Arrays.asList(
            new BankProvider("123", "01270856065", 2080),
            new BankProvider("456", "01207682391", 65166.256F),
            new BankProvider("1354658", "01125964742", 135.5F),
            new BankProvider("661", "01025879631", 500),
            new BankProvider("01168", "01270856065", 10000),
            new BankProvider("9632548", "01024825873", 2.11F),
            new BankProvider("0606609", "01270856665", 0)
    ));
    public static boolean check(BankProvider inputBank) {
        for (BankProvider bank : banks) {
            if(bank.getAccountNum() == inputBank.getAccountNum() && bank.getMobile() == inputBank.getMobile()) {
                inputBank = bank;
                return true;
            }
        }
        return false;
    }
}
