import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        InstaPay instaPay = new InstaPay();
        String ans;
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        do {
            System.out.println("1. Sign in\n2. Sign up");
            if(instaPay.auth()) {
                System.out.println("3. Transfer Money\n4. Inquire\n5. Pay bills");
            }
            System.out.println("Enter (exit) to terminate");
            Scanner scanner = new Scanner(System.in);
            ans = scanner.nextLine();

            if(Objects.equals(ans, "exit")) break;
            if (Objects.equals(ans, "1")) {
                instaPay.signIn();
            } else if(Objects.equals(ans, "2")) {
                instaPay.signUp();
            } else if(instaPay.auth()) {
                if (Objects.equals(ans, "3")) {
                    System.out.println("1. Bank Account\n2. Instapay Account\n3. Wallet");
                    if(instaPay.transfer(scanner.nextLine())) System.out.println("Transaction was made successfully");
                    else System.out.println("Transaction Failed!");
                } else if (Objects.equals(ans, "4")) {
                    System.out.println("Username: " + instaPay.getUsername());
                    System.out.println("Balance: " + instaPay.getBalance());
                } else if (Objects.equals(ans, "5")) {
                    System.out.println("Enter bill of one of those:\nWater\nGas\nElectricity");
                    instaPay.Bill(scanner.nextLine());
                } else System.out.println("Invalid input");
            } else System.out.println("Invalid Input");
        } while(!Objects.equals(ans, "exit"));
    }
}