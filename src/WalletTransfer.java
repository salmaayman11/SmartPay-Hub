public class WalletTransfer implements Transfer{
    String mobile ;
    WalletProvider senderWalletProvider;
    public WalletTransfer(String mobile, WalletProvider senderWalletProvider ) {
        this.mobile = mobile;
        this.senderWalletProvider = senderWalletProvider;
    }
    public Boolean transfer(String receiverMobileNo, float amount){
        System.out.println("Transferring to bank account");
        WalletProvider receiverWallet = new WalletProvider(receiverMobileNo);
        if (walletDB.check(receiverWallet)){
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
