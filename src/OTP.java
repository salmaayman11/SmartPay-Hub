import java.util.Scanner;
import java.util.Random;

public class OTP {
    public static Boolean generateOTP(){
        Random random = new Random();
        int randomNum = random.nextInt();
        System.out.println(randomNum);
        System.out.println("Enter the num");
        Scanner scanner=new Scanner(System.in);
        int num= scanner.nextInt();
        if(num==randomNum){
            return  true;
        }
         return false;
    }
}
