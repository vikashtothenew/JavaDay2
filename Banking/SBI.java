package Banking;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SBI {
    static double sbi_roi = 7.2;
    static int sbiRemainingBalance=5000;
    enum AccountType {
        SAVING,
        CURRENT;
    }
    public void show_details(){
        System.out.println("Current Rate of Interest of SBI BANK : "+sbi_roi);
    }
    public void printDetails(){
        System.out.println("SBI bank was established in 1948");
    }

    public void debitMoney(int money) throws InsufficientAmountException{
        File file = new File("sbi.txt");
        try(BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            if (money > sbiRemainingBalance) {
                br.write("++SBI Statement++");
                br.write("\nTransaction failed at : "+timeStamp);
                br.write("\nPLEASE TRY AGAIN!!");
                throw new InsufficientAmountException("Insufficient Balance in your account");
            } else {
                int amountbeforeWithdrawl=sbiRemainingBalance;
                sbiRemainingBalance -= money;
                System.out.println("Your remaining balance : " + sbiRemainingBalance);
                br.write("++SBI Statement++");
                br.write("\nTime of transaction "+timeStamp);
                br.write("\nAmount before withdrawl:"+amountbeforeWithdrawl);
                br.write("\nAmount withdrawl : "+money);
                br.write("\nRemaining Amount after withdrawl :"+sbiRemainingBalance);
                br.write("\nThank You!");
            }

        }catch (IOException e){
            System.out.println("Unable to read file"+file.toString());
        }

    }

}
