package UtilityBill;

import java.lang.Math;
import java.util.Random;

public class Electricity extends UtilityBill {
    public Electricity(){
        Random random = new Random();
        this.amount = 50 + random.nextFloat() * (1000 - 50);
    }

    public String getType(){
        return "Electricity";
    }
}
