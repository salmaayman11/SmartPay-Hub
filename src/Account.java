import java.util.Objects;
import java.util.Scanner;

public class Account {
    String username;
    String password;
    AccountProvider provider;
    Account(String username,String password) {
        this.username=username;
        this.password=password;
    }


    public static Account signIn() {
        System.out.println("Enter your username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Enter your password");
        String password = new Scanner(System.in).nextLine();
        Account account=new Account(username,password);
        if (AccountDB.check(account)) {
                return account;
        }
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
                setProvider(new WalletProvider(mobileNum));
                getProvider().verify();
                break;
            case "2":
                System.out.println("Enter your account number");
                String bankNum = new Scanner(System.in).nextLine();
                setProvider(new BankProvider (bankNum,mobileNum));
                getProvider().verify() ;

        }
        if(OTP.generateOTP()){
            System.out.println("Enter your username");
            username=new Scanner(System.in).nextLine();
            System.out.println("Enter your pass");
            password=new Scanner(System.in).nextLine();
            }
        Account account=new Account(username,password);
        while(!(AccountDB.check(account))) {
            System.out.println("Enter a unique username");
            username=new Scanner(System.in).nextLine();
        }
        while(!(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"))){
            System.out.println("Enter another password ");
            password=new Scanner(System.in).nextLine();
        }
        AccountDB.add(account);
            }

    public void setProvider(AccountProvider provider) {
        this.provider = provider;
    }


    public AccountProvider getProvider(){
        return provider;
    }
    public String getUserName(){
        return this.username;
    }
}