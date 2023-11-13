import java.lang.Math;
public class Water extends UtilityBill {
    float amount;
    public Water(){
        this.amount= (float) Math.random()*(400-200+1)+200;
    }

    public String getType(){
        return "Water";
    }
}
