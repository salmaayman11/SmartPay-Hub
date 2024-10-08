package AccountProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
    public static BankProvider check(BankProvider inputBank) {
        for (BankProvider bank : banks) {
            if(Objects.equals(bank.getAccountNum(), inputBank.getAccountNum()) && Objects.equals(bank.getMobile(), inputBank.getMobile())) {
                return bank;
            }
        }
        return null;
    }
    public static BankProvider check(String accNum) {
        for (BankProvider bank : banks) {
            if(Objects.equals(bank.getAccountNum(), accNum)) {
                return bank;
            }
        }
        return null;
    }
}
