package Banking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ICICI {
    double icici_roi = 7.8;
    static int iciciRemainingBalance=5000;
    enum AccountType{
        SAVING,
        CURRENT;
    }
    public void show_details(){
        System.out.println("Current Rate of Interest of ICICI BANK : "+icici_roi);
    }

    public void debitMoney(int money) throws InsufficientAmountException{
        File file = new File("icici.txt");
        try(BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            if (money > iciciRemainingBalance) {

                br.write("++ICICI Status++");
                br.write("\nTransaction failed at : "+timeStamp);
                br.write("\nPLEASE TRY AGAIN!!");
                throw new InsufficientAmountException("Insufficient Balance in your account");
            } else {
                int amountbeforeWithdrawl=iciciRemainingBalance;
                iciciRemainingBalance -= money;
                System.out.println("Your remaining balance : " + iciciRemainingBalance);
                br.write("++ICICI Status++");
                br.write("\nTime of transaction "+timeStamp);
                br.write("\nAmount before withdrawl:"+amountbeforeWithdrawl);
                br.write("\nAmount Withdrawl : "+money);
                br.write("\nRemaining Amount after Withdrawl :"+iciciRemainingBalance);
                br.write("\nThank You!");
            }

        }catch (IOException e){
            System.out.println("Unable to read file"+file.toString());
        }
    }

    public void printDetails(){
        System.out.println("ICICI was established in 1953");
    }

}
