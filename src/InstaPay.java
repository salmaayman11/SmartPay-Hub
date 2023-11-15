import java.util.Objects;
import java.util.Scanner;

public class InstaPay {
    UtilityBill bill;
    Transfer transferStrategy;
    Account account;
    public String getUsername() {
        return account.getUserName();
    }
    public Boolean transfer(String type){
//        Bank
        if(type.equalsIgnoreCase("1")){
            if (!(account.getProvider() instanceof BankProvider)) {
                System.out.println("You cannot transfer to bank account");
                return false;
            }
            System.out.println("enter the account number you want to transfer to");
            String accno=new Scanner((System.in)).nextLine();
            System.out.println("Enter the amount you want to transfer");
            float amount =new Scanner(System.in).nextFloat();

            return transferStrategy.transfer(accno,amount);
        }
//        Instapay
        else if(type.equalsIgnoreCase ("2")){
            System.out.println("enter your username");
            String user=new Scanner(System.in).nextLine();
            System.out.println("Enter amount to be transferred");
            float amount =new Scanner(System.in).nextFloat();
            return transferStrategy.transfer(user,amount);
        }
//        Wallet
        else if(type.equalsIgnoreCase("3")){
            System.out.println("enter your Mobile number");
            String mobile=new Scanner(System.in).nextLine();
            float amount =new Scanner(System.in).nextFloat();
            return transferStrategy.transfer(mobile,amount);
        } else System.out.println("Undefined type");
        return false;
    }
    public String getMobile(){
        return account.provider.getMobile();
    }
    public float getBalance(){
        return account.provider.getBalance();
    }
    public void Bill(String Type) {
        if (Type.equalsIgnoreCase("water") || Type.equalsIgnoreCase("electricity") || Type.equalsIgnoreCase("gas")) {
            System.out.println("1. Inquire - 2. Pay bill");
            int option = new Scanner(System.in).nextInt();
            if (option == 1) {
                if (Type.equalsIgnoreCase("Water")) {
                    bill = new Water();
                }
                if (Type.equalsIgnoreCase("Electricity")) {
                    bill = new Electricity();
                }
                if (Type.equalsIgnoreCase("Gas")) {
                    bill = new Gas();
                }
                System.out.println("Name: " + account.username);
                bill.printBill();
                System.out.println("Do you want to pay bills y/n");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    bill.pay(account.provider);
                }
            }

            if (option == 2) {
                 bill.pay(account.provider);
            }
            System.out.println("You entered wrong option");
        }
    }
    public void signIn(){
        this.account = Account.signIn();
        if(account == null) System.out.println("Account not found!");
    }
    public void signUp() {
        account = new Account();
        account.signUp();
    }
    public boolean auth() {
        return account != null;
    }
    public AccountProvider getProvider() {
        return account.getProvider();
    }
}
