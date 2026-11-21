import java.util.Scanner;

class OptionException extends Exception {
    OptionException(String message) {
        super(message);
    }
}

class BANK_ACCOUNT {
    String username = new String();
    int BANK_AMOUNT = 0;
    char method;
    BANK_ACCOUNT(String username, int initial_amount) {
        this.username = username;
        BANK_AMOUNT += initial_amount;
    }
    BANK_ACCOUNT(String username) {
        this.username = username;
    }
    synchronized int DEPOSITE(int AMOUNT) {
        BANK_AMOUNT += AMOUNT;
        System.out.println(username + " has deposited " + AMOUNT + " current amount is: "+ BANK_AMOUNT);
        return BANK_AMOUNT;
    }
    synchronized int WITHDRAW(int AMOUNT) {
        if(BANK_AMOUNT < AMOUNT) {
            System.out.println(username + " tried to withdraw "+ AMOUNT + " from the BANK but his current balance is "+BANK_AMOUNT);
        }
        else {
            BANK_AMOUNT -= AMOUNT;
            System.out.println(username + " has withdrawn " + AMOUNT + " current amount is: "+ BANK_AMOUNT);
        }
        return BANK_AMOUNT;
    }
}

class WithDrawThread implements Runnable {
    BANK_ACCOUNT reference;
    int amount;
    WithDrawThread(int amount, BANK_ACCOUNT user) {
        this.reference = user;
        this.amount = amount;
    }
    public void run() {
        reference.WITHDRAW(this.amount);
    }
}

class DepositeThread implements Runnable {
    BANK_ACCOUNT reference;
    int amount;
    DepositeThread(int amount, BANK_ACCOUNT user) {
        this.reference = user;
        this.amount = amount;
    }
    public void run() {
        reference.DEPOSITE(this.amount);
    }
}

public class bank_system {
    public static void main(String argv[]) throws OptionException, InterruptedException {
        Scanner text = new Scanner(System.in);
        Scanner number = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String username = text.nextLine();
        
        BANK_ACCOUNT bank;
        System.out.print("Do your bank have any existing amount??: ");
        char confirm = text.next().charAt(0);
        if(confirm == 'y' || confirm == 'Y') {
            System.out.print("Enter amount: ");
            int amount = number.nextInt();
            bank = new BANK_ACCOUNT(username,amount);
        }
        else if(confirm == 'n' || confirm == 'N') {
            bank = new BANK_ACCOUNT(username);
        }
        else {
            throw new OptionException("Invalid option");
        }
        
        char RUNNING = 'y';
        while(RUNNING == 'y') {
            System.out.println("Hello "+username+"\nEnter\nW for withdraw\nD for deposite");
            System.out.print("Your response: ");
            char option = text.next().toLowerCase().charAt(0);
            
            if(option == 'd') {
                System.out.print("Enter amount to deposit: ");
                int changeAmount = number.nextInt();
                DepositeThread deposit = new DepositeThread(changeAmount, bank);
                Thread t1 = new Thread(deposit);
                t1.start();
            }
            else if(option == 'w') {
                System.out.print("Enter amount to withdraw: ");
                int changeAmount = number.nextInt();
                WithDrawThread withdraw = new WithDrawThread(changeAmount, bank);
                Thread t2 = new Thread(withdraw);
                t2.start();
            }
            else {
                throw new OptionException("Invalid option");
            }
            System.out.print("DO you want to continue?: ");
            RUNNING = text.next().toLowerCase().charAt(0);
        }
        return;
    }
}