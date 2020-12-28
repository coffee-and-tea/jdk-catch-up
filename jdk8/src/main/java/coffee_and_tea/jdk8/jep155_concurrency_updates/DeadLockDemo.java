package coffee_and_tea.jdk8.jep155_concurrency_updates;

public class DeadLockDemo {

    public static void main(String[] args) {
        BankAccountWithTransfer account1 = new BankAccountWithTransfer("0", 0);
        BankAccountWithTransfer account2 = new BankAccountWithTransfer("1", 0);

        Runnable runnable1 = () -> account1.transfer(account2, 10);
        Runnable runnable2 = () -> account2.transfer(account1, 10);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // this would create a dead lock, need to kill the execution
        thread1.start();
        thread2.start();
    }
}

class BankAccountWithTransfer {

    String accountNbr;
    int balance;

    public BankAccountWithTransfer(String accountNbr, int balance) {
        this.accountNbr = accountNbr;
        this.balance = balance;
    }

    public String getAccountNbr() {
        return accountNbr;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    public synchronized void withdraw(int amount) {
        this.balance -= amount;
    }

    public synchronized void transfer(BankAccountWithTransfer anotherAccount, int amount) {
        System.out.println("Transfer from: " + accountNbr + " to: " + anotherAccount.getAccountNbr() + " of $" + amount);
        this.withdraw(amount);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        anotherAccount.deposit(amount);
    }
}
