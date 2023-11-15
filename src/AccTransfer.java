public class AccTransfer implements Transfer {

    String mobile;
    AccountDB accountDB;
    AccountProvider accProvider;
    public AccTransfer(String mobile, AccountDB accountDB,AccountProvider accProvider ){
        this.mobile=mobile;
        this.accountDB=accountDB;
        this.accProvider=accProvider;
    }
    public Boolean transfer(String userName, float amount){
        System.out.println("Transferring to Instapay account");
        if (accountDB.check(userName)){
            Account receiverAcc = accountDB.getAccount(userName); ;

            if(accProvider.getBalance()>=amount){
                float senderUpdatedBalance =accProvider.getBalance()-amount;
                float receiverUpdatedBalance= accProvider.getBalance()+amount;
                accProvider.setBalance(senderUpdatedBalance);
                receiverAcc.provider.setBalance(receiverUpdatedBalance);
                System.out.println("Successful Transfer");
                return true;
            }
            else{
                System.out.println("Insufficient balance.");
                return false;
            }
        }else{

            System.out.println("Invalid Account");
            return false;
        }

    }
}
