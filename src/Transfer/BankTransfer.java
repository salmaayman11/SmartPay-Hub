package Transfer;

import Account.AccountDB;
import AccountProvider.AccountProvider;
import AccountProvider.BankDB;
import AccountProvider.BankProvider;

import java.util.Scanner;

public class BankTransfer implements Transfer {
    AccountProvider senderBankProvider;

    public BankTransfer(AccountProvider senderBankProvider) {
        this.senderBankProvider = senderBankProvider;
    }

    public Boolean transfer(float amount){
        System.out.println("Enter receiver bank account number");
        Scanner scanner = new Scanner(System.in);
        String receiverAccountNo = scanner.nextLine();
        BankProvider receiverAcc = BankDB.check(receiverAccountNo);
        if (receiverAcc != null){
            if(senderBankProvider.getBalance()>=amount){
                float senderUpdatedBalance = senderBankProvider.getBalance()-amount;
                float receiverUpdatedBalance= receiverAcc.getBalance()+amount;

                senderBankProvider.setBalance(senderUpdatedBalance);
                receiverAcc.setBalance(receiverUpdatedBalance);

                System.out.println("Successful Transfer.Transfer");
                return true;
            }
            else{
                System.out.println("Insufficient Balance.");
                return false;
            }
        }else{

            System.out.println("Invalid Account Number");
            return false;
        }

    }

}
