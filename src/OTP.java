import java.util.Scanner;

public class OTP {
    public static Boolean generateOTP(){
        int random= (int) Math.random();
        System.out.println(random);
        System.out.println("Enter the num");
        Scanner scanner=new Scanner(System.in);
        int num= scanner.nextInt();
        if(num==random){
            return true;
        }
         return false;
    }
}
