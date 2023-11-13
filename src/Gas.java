import java.lang.Math;
public class Gas extends UtilityBill {
    float amount;
    public Gas(){
        this.amount= (float) Math.random()*(200-100+1)+100;
    }

    public String getType(){
        return "Gas";
    }
}
