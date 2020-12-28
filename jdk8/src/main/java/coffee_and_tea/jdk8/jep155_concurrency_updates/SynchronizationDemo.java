package coffee_and_tea.jdk8.jep155_concurrency_updates;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SynchronizationDemo {

    public static void main(String[] args) throws InterruptedException {

        demoWithoutSynchronization();

        demoSyncMethod();

        demoSyncObject();

        demoVolatile();

        demoAtomic();
    }

    private static void demoAtomic() throws InterruptedException {
        AtomicBankAccount bankAccount = new AtomicBankAccount();
        System.out.println("Result from atomic bank account:");
        executeDeposit(bankAccount);
    }

    private static void demoVolatile() throws InterruptedException {
        VolatileBankAccount bankAccount = new VolatileBankAccount();
        System.out.println("Result from volatile bank account:");
        executeDeposit(bankAccount);
    }

    private static void demoSyncObject() throws InterruptedException {
        SyncObjectBankAccount bankAccount = new SyncObjectBankAccount();
        System.out.println("Result from synchronized object bank account:");
        executeDeposit(bankAccount);
    }

    private static void demoSyncMethod() throws InterruptedException {
        SyncMethodBankAccount bankAccount = new SyncMethodBankAccount();
        System.out.println("Result from synchronized method bank account:");
        executeDeposit(bankAccount);
    }

    private static void demoWithoutSynchronization() throws InterruptedException {
        NoSyncBankAccount bankAccount = new NoSyncBankAccount();
        System.out.println("Result from no sync bank account:");
        executeDeposit(bankAccount);
    }

    private static void executeDeposit(BankAccount bankAccount) throws InterruptedException {
        Runnable runnable =
                () -> IntStream.range(0, 100).parallel().forEach(
                        i -> bankAccount.deposit(i)
                );

        Thread deposits1 = new Thread(runnable);
        Thread deposits2 = new Thread(runnable);
        Thread deposits3 = new Thread(runnable);
        Thread deposits4 = new Thread(runnable);
        Thread deposits5 = new Thread(runnable);
        deposits1.start();
        deposits2.start();
        deposits3.start();
        deposits4.start();
        deposits5.start();
        deposits1.join();
        deposits2.join();
        deposits3.join();
        deposits4.join();
        deposits5.join();

        System.out.println("Current balance: " + bankAccount.getBalance());
        System.out.println("Expected balance: " + 4950*5);
    }
}

abstract class BankAccount {

    protected int balance;

    public BankAccount() {
        this.balance = 0;
    }

    abstract void deposit(int amount);
    abstract int getBalance();
}

class AtomicBankAccount extends BankAccount {

    AtomicInteger balance = new AtomicInteger(0);

    @Override
    void deposit(int amount) {
        this.balance.addAndGet(amount);
    }

    @Override
    int getBalance() {
        return this.balance.get();
    }
}

class VolatileBankAccount extends BankAccount {

    private volatile int balance;

    @Override
    void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    int getBalance() {
        return this.balance;
    }
}

class SyncObjectBankAccount extends BankAccount {

    @Override
    void deposit(int amount) {
        synchronized (this) {
            this.balance += amount;
        }
    }

    @Override
    int getBalance() {
        return this.balance;
    }
}

class SyncMethodBankAccount extends BankAccount {

    @Override
    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public synchronized int getBalance() {
        return this.balance;
    }
}

class NoSyncBankAccount extends BankAccount {

    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
