package AccountProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class WalletDB {
    static ArrayList<WalletProvider> wallets = new ArrayList<WalletProvider>(Arrays.asList(
            new WalletProvider("01270856065", 2080),
            new WalletProvider("01207682391", 65166.256F),
            new WalletProvider("01125964742", 135.5F),
            new WalletProvider("01025879631", 500),
            new WalletProvider("01270856065", 10000),
            new WalletProvider("01024825873", 2.11F),
            new WalletProvider("01270856665", 0)
    ));
    public static WalletProvider check(WalletProvider inputWallet) {
        for (WalletProvider wallet : wallets) {
            if(Objects.equals(wallet.getMobile(), inputWallet.getMobile())) {
                return wallet;
            }
        }
        return null;
    }
}
