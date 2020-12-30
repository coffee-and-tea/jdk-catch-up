package coffee_and_tea.jdk8.jep155_concurrency_updates;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinDemo {

    public static void main(String[] args) {

        BankAccountWithTransferWithLock account1 = new BankAccountWithTransferWithLock("0", 0);
        BankAccountWithTransferWithLock account2 = new BankAccountWithTransferWithLock("1", 0);

        ForkJoinPool pool = new ForkJoinPool();

        ThreadLocalRandom currentRandom = ThreadLocalRandom.current();
        int transferTimes = currentRandom.nextInt(10);
        System.out.println("Total transfer times: " + transferTimes);
        RepeatTransfer rt = new RepeatTransfer(account1, account2, transferTimes);

        pool.invoke(rt);
    }
}

class RepeatTransfer extends RecursiveAction {

    BankAccountWithTransferWithLock fromAccount;
    BankAccountWithTransferWithLock toAccount;
    int transferTimes;

    public RepeatTransfer(BankAccountWithTransferWithLock fromAccount, BankAccountWithTransferWithLock toAccount, int transferTimes) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transferTimes = transferTimes;
    }

    @Override
    protected void compute() {
        if (transferTimes == 1) {
            executeTransfer();
        } else {
            invokeAll(
                    new RepeatTransfer(fromAccount, toAccount, transferTimes/2),
                    new RepeatTransfer(fromAccount, toAccount, transferTimes - transferTimes/2)
            );
        }
    }

    private void executeTransfer() {
        System.out.println("Thread: " + Thread.currentThread() + " run transfer from account 1 to account 2");
        fromAccount.transfer(toAccount, 10);
        System.out.println("Thread: " + Thread.currentThread() + " completed");
    }
}
