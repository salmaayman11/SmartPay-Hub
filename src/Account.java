import java.util.Objects;
import java.util.Scanner;

public class Account {
    String username;
    String password;
    AccountProvider provider;

    Account(){}
    Account(String username,String password) {
        this.username=username;
        this.password=password;
    }
    //System.out.println("the bill of " + bill.getType() + bill.getAmount());


    public static Account signIn() {
        System.out.println("Enter your username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Enter your password");
        String password = new Scanner(System.in).nextLine();
        Account account=new Account(username,password);
        if (account.verify()) {
            return account;
        }
        return null;
    }
    public void signUp() {
        System.out.println("1. Wallet account\n2. Bank Account\nEnter option number");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.nextLine();
        System.out.println("Enter mobile number");
        String mobileNum = new Scanner(System.in).nextLine();

        switch (opt) {
            case "1":
                setProvider(new WalletProvider(mobileNum));
                if(!getProvider().verify()) {
                    System.out.println("Invalid mobile number");
                    return;
                }
                break;
            case "2":
                System.out.println("Enter your account number");
                String bankNum = new Scanner(System.in).nextLine();
                setProvider(new BankProvider (bankNum,mobileNum));
                if(!getProvider().verify()) {
                    System.out.println("Invalid account or mobile number");
                    return;
                }
        }
        if(!OTP.generateOTP()){
            System.out.println("OTP cannot be generated!");
            return;
        }
        System.out.println("Enter your username");
        username=new Scanner(System.in).nextLine();
        System.out.println("Enter your pass");
        password=new Scanner(System.in).nextLine();
        while(AccountDB.check(username)) {
            System.out.println("Enter a unique username");
            username=new Scanner(System.in).nextLine();
        }
        while(!(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"))){
            System.out.println("Enter another password ");
            password=new Scanner(System.in).nextLine();
        }
        AccountDB.add(this);
    }

    public void setProvider(AccountProvider provider) {
        this.provider = provider;
    }
    private boolean verify() {
        Account acc = AccountDB.check(this);
        if(acc == null) return false;
        this.password = acc.password;
        this.username = acc.getUserName();
        this.provider = acc.getProvider();
        return true;
    }
    public AccountProvider getProvider(){
        return provider;
    }
    public String getUserName(){
        return this.username;
    }
}
