package coffee_and_tea.jdk9.jep193_variable_handles;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VarHandleDemo {

    public static void main(String[] args) {

        BankAccount bankAccountWithConcurrencyIssue = new BankAccountWithConcurrencyIssue();
        BankAccount bankAccountVarHandle = new BankAccountVarHandle();

        Runnable depositToBankAccountWithConcurrencyIssue =
                () -> bankAccountWithConcurrencyIssue.deposit(100);
        Runnable depositToBankAccountVarHandle = () -> bankAccountVarHandle.deposit(100);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10000; i++) {
            executorService.submit(depositToBankAccountWithConcurrencyIssue);
            executorService.submit(depositToBankAccountVarHandle);
        }
        try {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);
            System.out.println("Bank account with concurrency issue amount: " + bankAccountWithConcurrencyIssue.getAmount());
            System.out.println("Bank account with VarHandle amount: " + bankAccountVarHandle.getAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

abstract class BankAccount {

    int amount;

    abstract void deposit(int depositAmount);

    public int getAmount() {
        return amount;
    }
}

class BankAccountVarHandle extends BankAccount {

    @Override
    void deposit(int depositAmount) {
        try {
            VarHandle amountHandle =
                    MethodHandles.lookup().findVarHandle(BankAccountVarHandle.class, "amount", int.class);
            amountHandle.getAndAdd(this, depositAmount);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

class BankAccountWithConcurrencyIssue extends BankAccount {

    public void deposit(int depositAmount) {
        amount += depositAmount;
    }

}