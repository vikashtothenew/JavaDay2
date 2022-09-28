package Banking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class BOI {
    static double boi_roi = 7.8;
    static int boiRemainingBalance=5000;
    enum AccountType{
            SAVING,
        CURRENT;
    }
    static
    public void show_details(){
        System.out.println("Current Rate of Interest of BOI BANK : "+boi_roi);
    }
    public void printDetails(){
        System.out.println("BOI was established in 1885");
    }

    public void debitMoney(int money) throws InsufficientAmountException{
        File file = new File("boi.txt");
        try(BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            if (money > boiRemainingBalance) {

                br.write("++BOI Statement++");
                br.write("\nTransaction failed at : "+timeStamp);
                br.write("\nPLEASE TRY AGAIN!!");
                throw new InsufficientAmountException("Insufficient Balance  in your account");
            } else {
                int amountbeforeWithdrawl=boiRemainingBalance;
                boiRemainingBalance -= money;
                System.out.println("Your remaining balance : " + boiRemainingBalance);
                br.write("++BOI Statement++");
                br.write("\nTime of transaction "+timeStamp);
                br.write("\nAmount before withdrawl:"+amountbeforeWithdrawl);
                br.write("\nAmount Withdrawl : "+money);
                br.write("\n Remaining Amount after Withdrawl :"+boiRemainingBalance);
                br.write("\nThank You!");
            }

        }catch (IOException e){
            System.out.println("Unable to read file"+file.toString());
        }
    }

}
