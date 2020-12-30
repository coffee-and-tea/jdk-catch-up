package coffee_and_tea.jdk8.jep155_concurrency_updates;

public class WaitNotifyDemo {

    public static void main(String[] args) {
        CheckBankAccount account = new CheckBankAccount();

        Runnable payroll = () -> {
            while(true) {
                account.deposit(10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable payBill = () -> {
            while (true) {
                account.payBill(50);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread getPaid = new Thread(payroll);
        Thread billPaid = new Thread(payBill);

        getPaid.start();
        billPaid.start();
    }

}

class CheckBankAccount extends BankAccount {

    @Override
    public synchronized void deposit(int amount) {
        while(this.balance + amount > 100) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Deposit: " + amount + " ,Current balance: " + balance);
        this.balance += amount;
        this.notifyAll();
    }

    public synchronized void payBill(int amount) {
        while (this.balance - amount < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pay bill: " + amount + " ,Current balance: " + balance);
        this.balance -= amount;
        this.notifyAll();
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
