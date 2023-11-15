package Transfer;

import Account.*;
import AccountProvider.*;

import java.util.Scanner;

public class AccTransfer implements Transfer {

    AccountProvider senderAccProvider;

    public AccTransfer(AccountProvider senderAccProvider) {
        this.senderAccProvider = senderAccProvider;
    }

    public Boolean transfer(float amount){
        System.out.println("Enter the username of the account you want to transfer to");
        String userName=new Scanner((System.in)).nextLine();
        if (AccountDB.check(userName)){
            Account receiverAcc = AccountDB.getAccount(userName); ;

            if(senderAccProvider.getBalance()>=amount){
                float senderUpdatedBalance = senderAccProvider.getBalance() - amount;
                float receiverUpdatedBalance= senderAccProvider.getBalance() + amount;
                senderAccProvider.setBalance(senderUpdatedBalance);
                receiverAcc.getProvider().setBalance(receiverUpdatedBalance);
                System.out.println("Successful Transfer");
                return true;
            }
            else{
                System.out.println("Insufficient Balance.");
                return false;
            }
        }else{

            System.out.println("Invalid Account");
            return false;
        }

    }
}
