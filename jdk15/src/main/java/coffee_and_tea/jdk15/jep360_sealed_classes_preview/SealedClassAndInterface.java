package coffee_and_tea.jdk15.jep360_sealed_classes_preview;

import java.util.Arrays;

public class SealedClassAndInterface {

    public static void main(String[] args) {
        System.out.println("BankAccount is seealed?" + BankAccount.class.isSealed());
        System.out.println(Arrays.toString(BankAccount.class.permittedSubclasses()));
    }
}

sealed class BankAccount permits DebitAccount, SavingAccount, CreditAccount {
    int balance;
}

final class SavingAccount extends BankAccount implements AccountDeposit {

    @Override
    public void deposit(int amount) {
        balance += amount;
    }
}

non-sealed class CreditAccount extends BankAccount implements AccountDeposit {

    @Override
    public void deposit(int amount) {
        balance += amount;
    }
}

sealed class DebitAccount extends BankAccount implements AccountDeposit permits InterestFreeDebitAccount {

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

}

final class InterestFreeDebitAccount extends DebitAccount {

}

