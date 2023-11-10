import java.util.ArrayList;

public class walletDB {
    walletProvider[] wallets=new walletProvider[5];
    walletDB(){
        wallets[0].setBalance(100000);
        wallets[0].mobile="012345678";
        wallets[0].setBalance(200000);
        wallets[0].mobile="012345672";
        wallets[0].setBalance(300000);
        wallets[0].mobile="012345673";
        wallets[0].setBalance(400000);
        wallets[0].mobile="012345674";
        wallets[0].setBalance(500000);
        wallets[0].mobile="012345675";
    }
    public boolean check(walletProvider wallet){
        for (int i = 0; i < 5; i++) {
            if (wallet.getMobile() == this.wallets[i].getMobile()) {
                return true;
            }
        }
        return false;
    }
}
