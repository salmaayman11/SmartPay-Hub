package UtilityBill;

import java.lang.Math;
import java.util.Random;

public class Water extends UtilityBill {
    public Water() {
        Random random = new Random();
        this.amount = 50 + random.nextFloat() * (300 - 50);
    }

    public String getType(){
        return "Water";
    }
}
