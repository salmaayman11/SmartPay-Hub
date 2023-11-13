import java.lang.Math;
public class Electricity extends UtilityBill {
    float amount;
    public Electricity(){
        this.amount= (float) Math.random()*(1000-200+1)+200;
    }

    public String getType(){
        return "Electricity";
    }
}
