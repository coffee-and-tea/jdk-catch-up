package coffee_and_tea.jdk15.jep360_sealed_classes_preview;

public sealed interface AccountDeposit permits DebitAccount, SavingAccount, CreditAccount {
    void deposit(int amount);
}
