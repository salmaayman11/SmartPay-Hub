public class AccTransfer implements Transfer {

    String mobile ;
    AccountDB accountDB;
    AccountProvider senderAccProvider;
    public AccTransfer(String mobile, AccountDB accountDB,AccountProvider senderAccProvider ){
        this.mobile=mobile;
        this.accountDB=accountDB;
        this.senderAccProvider=senderAccProvider;
    }
    public Boolean transfer(String userName, float amount){
        System.out.println("Transferring to InstaPay Account");
        if (accountDB.check(userName)){
            Account receiverAcc = accountDB.getAccount(userName); ;

            if(senderAccProvider.getBalance()>=amount){
                float senderUpdatedBalance =senderAccProvider.getBalance() - amount;
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
