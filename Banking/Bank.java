package Banking;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) throws InsufficientAmountException{
        Scanner scanner = new Scanner(System.in);

        SBI sbi_bank = new SBI();
        BOI boi_bank = new BOI();
        ICICI icici_bank = new ICICI();

        //showing details of each bank

        sbi_bank.show_details();
        boi_bank.show_details();
        icici_bank.show_details();

        //printing details of each bank
        sbi_bank.printDetails();
        icici_bank.printDetails();
        boi_bank.printDetails();

        System.out.println("Press : 1 to debit amount from SBI Account");
        System.out.println("Press : 2 to debit amount from BOI Account");
        System.out.println("Press : 3 to debit amount from ICICI Account");
        System.out.println("Please choose the bank option : ");

        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("Welcome to SBI");
                System.out.println("Please enter the amount that you want to withdrawn");
                int debitSBIMoney= scanner.nextInt();
                sbi_bank.debitMoney(debitSBIMoney);
                break;
            case 2:
                System.out.println("Welcome to BOI");
                System.out.println("Please enter the amount that you want to debit");
                int debitBOIMoney= scanner.nextInt();
                sbi_bank.debitMoney(debitBOIMoney);
                break;
            case 3:
                System.out.println("Welcome to ICICI");
                System.out.println("Please enter the amount that you want to debit");
                int debitICICIMoney= scanner.nextInt();
                sbi_bank.debitMoney(debitICICIMoney);
                break;
            default:
                System.out.println("Please Enter the valid bank");
                break;
        }


    }
}
