import java.util.ArrayList;

public class bankDB {
    bankProvider[] bank=new bankProvider[5];
    bankDB(){
        bank[0].setBalance(100000);
        bank[0].accountNum="123456789";
        bank[0].mobile="012345678";
        bank[1].setBalance(200000);
        bank[1].accountNum="223456789";
        bank[1].mobile="012345672";
        bank[2].setBalance(300000);
        bank[2].accountNum="323456789";
        bank[2].mobile="012345673";
        bank[3].setBalance(400000);
        bank[3].accountNum="423456789";
        bank[3].mobile="012345674";
        bank[4].setBalance(500000);
        bank[4].accountNum="523456789";
        bank[4].mobile="012345675";

    }
    public boolean check(bankProvider inputBank) {
        for (int i = 0; i < 5; i++) {
            if (inputBank.accountNum== this.bank[i].accountNum) {
                return true;
            }
        }
        return false;
    }
}
