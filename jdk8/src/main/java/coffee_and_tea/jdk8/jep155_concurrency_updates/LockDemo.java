package coffee_and_tea.jdk8.jep155_concurrency_updates;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {
        BankAccountWithTransferWithLock account1 = new BankAccountWithTransferWithLock("0", 0);
        BankAccountWithTransferWithLock account2 = new BankAccountWithTransferWithLock("1", 0);

        Runnable runnable1 = () -> account1.transfer(account2, 10);
        Runnable runnable2 = () -> account2.transfer(account1, 10);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // this would create a dead lock, need to kill the execution
        thread1.start();
        thread2.start();
    }
}

class BankAccountWithTransferWithLock {

    String accountNbr;
    int balance;

    Lock transferLock = new ReentrantLock();

    public BankAccountWithTransferWithLock(String accountNbr, int balance) {
        this.accountNbr = accountNbr;
        this.balance = balance;
    }

    public String getAccountNbr() {
        return accountNbr;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void transfer(BankAccountWithTransferWithLock anotherAccount, int amount) {

        lockTransfer(anotherAccount);
        System.out.println("Transfer from: " + accountNbr + " to: " + anotherAccount.getAccountNbr() + " of $" + amount);
        this.withdraw(amount);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        anotherAccount.deposit(amount);
        System.out.println("Transfer completed, unlock now");
        this.transferLock.unlock();
        anotherAccount.transferLock.unlock();
    }

    private void lockTransfer(BankAccountWithTransferWithLock anotherAccount) {
        boolean myLock = this.transferLock.tryLock();
        boolean otherLock = anotherAccount.transferLock.tryLock();
        while( !(myLock && otherLock)) {
            if(myLock) {
                this.transferLock.unlock();
            }
            if(otherLock) {
                anotherAccount.transferLock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock = this.transferLock.tryLock();
            otherLock = anotherAccount.transferLock.tryLock();
        }
    }
}
