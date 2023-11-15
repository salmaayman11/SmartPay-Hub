public class BankTransfer implements Transfer {
    String mobile ;
    BankProvider senderBankProvider;
    AccountDB accountDB;
    BankDB bankDB;
    public BankTransfer(String mobile,BankProvider senderBankProvider,AccountDB accountDB, BankDB bankDB){
        this.mobile = mobile;
        this.senderBankProvider = senderBankProvider;
        this.accountDB = accountDB;
        this.bankDB = bankDB;
    }
    public Boolean transfer(String receiverAccountNo, float amount){
        System.out.println("Transferring to bank account");
        BankProvider receiverAcc =  new BankProvider(receiverAccountNo);
        if (bankDB.check(receiverAcc)){

            if(senderBankProvider.getBalance()>=amount){
                float senderUpdatedBalance = senderBankProvider.getBalance()-amount;
                float receiverUpdatedBalance= receiverAcc.getBalance()+amount;

                senderBankProvider.setBalance(senderUpdatedBalance);
                receiverAcc.setBalance(receiverUpdatedBalance);

                System.out.println("Successful Transfer");
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
