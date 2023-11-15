import Account.*;
import AccountProvider.*;
import Transfer.*;
import UtilityBill.*;

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
        System.out.println("Enter the amount you want to transfer");
        float amount =new Scanner(System.in).nextFloat();
        if(type.equalsIgnoreCase("1")){
            if (!(account.getProvider() instanceof BankProvider)) {
                System.out.println("You cannot transfer to bank account");
                return false;
            }
            transferStrategy = new BankTransfer(account.getProvider());
        }
//        Instapay
        else if(type.equalsIgnoreCase ("2"))
            transferStrategy = new AccTransfer(account.getProvider());
//        Wallet
        else if(type.equalsIgnoreCase("3"))
            transferStrategy = new WalletTransfer(account.getProvider());
        else System.out.println("Undefined type");
        return transferStrategy.transfer(amount);
    }
    public float getBalance(){
        return account.getProvider().getBalance();
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
                System.out.println("Name: " + account.getUserName());
                bill.printBill();
                System.out.println("Do you want to pay bills y/n");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    bill.pay(account.getProvider());
                }
            }
            if (option == 2) {
                 bill.pay(account.getProvider());
            }
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
