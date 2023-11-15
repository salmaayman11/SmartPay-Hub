package Transfer;

import AccountProvider.*;

import java.util.Scanner;

public class WalletTransfer implements Transfer{
    AccountProvider senderWalletProvider;

    public WalletTransfer(AccountProvider senderWalletProvider) {
        this.senderWalletProvider = senderWalletProvider;
    }

    public Boolean transfer(float amount){
        System.out.println("Enter receiver wallet mobile number");
        Scanner scanner = new Scanner(System.in);
        String receiverMobileNo = scanner.nextLine();
        WalletProvider receiverWallet = WalletDB.check(new WalletProvider(receiverMobileNo));
        if (receiverWallet != null){
            if(senderWalletProvider.getBalance()>=amount){
                float senderUpdatedBalance = senderWalletProvider.getBalance()-amount;
                float receiverUpdatedBalance= receiverWallet.getBalance()+amount;

                senderWalletProvider.setBalance(senderUpdatedBalance);
                receiverWallet.setBalance(receiverUpdatedBalance);
                System.out.println("Successful Transfer");
                return true;
            }
            else{
                System.out.println("Insufficient Balance.");
                return false;
            }
           }else{
            System.out.println("Invalid Wallet Mobile Number");
            return false;
        }

    }

}
