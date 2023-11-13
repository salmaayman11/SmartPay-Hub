import java.util.Objects;
import java.util.Scanner;

public class InstaPay {
    UtilityBills bill;
    Transfer transferStrategy;
    Account account;
    public void signUp() {
        account.signUp();
    }
    public Boolean transfer( String type){
        if(type=="");
        return null;
    }
    public String getMobile(){
        return account.provider.getMobile();
    }
    public float getBalance(){
        return account.provider.getBalance();
    }
    public Boolean verify(){
        return true;
    }
    public Boolean Bill(String Type){
        System.out.println("1. Inquire - 2.Pay bill");
        int option=new Scanner(System.in).nextInt();
        double random= Math.random();
        if(option==1) {
            if(Objects.equals(Type, "Water")) {
                System.out.println("Name: " +account.username);
                System.out.println("Water bills"+random);
                System.out.println("Do you want to pay bills y/n");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    return bill.pay(account.provider);

            }
                else
                    return false;
            }
            if(Objects.equals(Type, "Electricity")) {
                System.out.println("Name: " +account.username);
                System.out.println("Electricity bills"+random);
                System.out.println("Do you want to pay bills y/n");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    return bill.pay(account.provider);

                }
                else
                    return false;
            }
            if(Objects.equals(Type, "Gas")) {
                System.out.println("Name: " +account.username);
                System.out.println("Gas bills"+random);
                System.out.println("Do you want to pay bills y/n");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    return bill.pay(account.provider);

                }
                else
                    return false;
            }

        }
        if(option==2) {
            if(Type=="Water"){
                return bill.pay(account.provider);
            }
            if(Type=="Electricity"){
                return bill.pay(account.provider);
            }
            if(Type=="Gas"){
                return bill.pay(account.provider);
            }

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
