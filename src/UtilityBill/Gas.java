package UtilityBill;

import java.util.Random;

public class Gas extends UtilityBill {
    public Gas() {
        Random random = new Random();
        this.amount = 50 + random.nextFloat() * (200 - 50);
    }

    public String getType(){
        return "Gas";
    }
}
