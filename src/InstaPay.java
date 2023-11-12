import java.util.Scanner;

public class InstaPay {
    UtilityBills bill;
    Transfer transferStrategy;
    Account account;
    public void signUp() {
        System.out.println("1. Bank account\n2. Wallet Account\nEnter option number");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.nextLine();
        System.out.println("Enter mobile number");
        String mobileNum = new Scanner(System.in).nextLine();

        switch (opt) {
            case "1":
                account = new Account();
                account.setProvider(new walletProvider(mobileNum));
                account.getProvider().verify();
                break;
            case "2":
                System.out.println("Enter your account number");
                String bankNum = new Scanner(System.in).nextLine();
                account=new Account();
                account.setProvider(new bankProvider (bankNum,mobileNum);
                account.getProvider().verify();
        }
    }
    public Boolean transfer( String type){
        return null;
    }
    public String getMobile(){

    }
    public float getBalance(){

    }
    public Boolean verify(){

    }
    public Boolean payBill(String Type){

    }

    public void signIn(String username,String pass){

    }
    public void singUp() {

    }
}
