import java.util.Objects;
import java.util.Scanner;

public class InstaPay {
    UtilityBill bill;
    Transfer transferStrategy;
    Account account;
    public void signUp() {
        account.signUp();
    }
    public Boolean transfer(String type){
        if(type.equalsIgnoreCase("bank")){
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
        else if(type.equalsIgnoreCase("instapay account")){
            System.out.println("enter your username");
            String user=new Scanner(System.in).nextLine();
            float amount =new Scanner(System.in).nextFloat();
            return transferStrategy.transfer(user,amount);
        }
        else if(type.equalsIgnoreCase("wallet")){
            System.out.println("enter your Mobile number");
            String mobile=new Scanner(System.in).nextLine();
            float amount =new Scanner(System.in).nextFloat();
            return transferStrategy.transfer(mobile,amount);
        }
        return false;
    }
    public String getMobile(){
        return account.provider.getMobile();
    }
    public float getBalance(){
        return account.provider.getBalance();
    }
    public Boolean Bill(String Type) {
        if (Type.equalsIgnoreCase("water") || Type.equalsIgnoreCase("electricity") || Type.equalsIgnoreCase("gas")) {
            System.out.println("1. Inquire - 2.Pay bill");
            int option = new Scanner(System.in).nextInt();
            if (option == 1) {
                if (Type.equalsIgnoreCase( "Water")) {
                    bill = new Water();
                }
                if (Type.equalsIgnoreCase( "Electricity")) {
                    bill = new Electricity();
                }
                if (Type.equalsIgnoreCase( "Gas")) {
                    bill = new Gas();
                }
                System.out.println("Name: " + account.username);
                bill.printBill();
                System.out.println("Do you want to pay bills y/n");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    return bill.pay(account.provider);

                } else
                    return false;
            }

            if (option == 2) {
                return bill.pay(account.provider);
            }
            System.out.println("You entered wrong option");
            return false;
        }
        return false;
    }


    public void signIn(String username,String pass){
        Account.signIn();

    }
    public void singUp() {
        account.signUp();

    }
}
