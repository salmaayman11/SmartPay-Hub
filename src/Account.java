import java.util.Scanner;

public class Account {
    String username;
    String password;
    AccountProvider provider;


    public static Account signIn() {
        return null;
    }

    public void signUp() {
        System.out.println("1. Bank account\n2. Wallet Account\nEnter option number");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.nextLine();
        System.out.println("Enter mobile number");
        String mobileNum = new Scanner(System.in).nextLine();

        switch (opt) {
            case "1":
                setProvider(new walletProvider(mobileNum));
                getProvider().verify();
                break;
            case "2":
                System.out.println("Enter your account number");
                String bankNum = new Scanner(System.in).nextLine();
                setProvider(new bankProvider (bankNum,mobileNum);
                getProvider().verify() ;

        }
        OTP otp=new OTP();
        if(otp.generateOTP()){

        }
    }

    public void setProvider(AccountProvider provider) {
        this.provider = provider;
    }


    public AccountProvider getProvider(){
        return provider;
    }
}