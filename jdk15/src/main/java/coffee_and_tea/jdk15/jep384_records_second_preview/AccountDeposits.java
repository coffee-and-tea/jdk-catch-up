package coffee_and_tea.jdk15.jep384_records_second_preview;

public sealed interface  AccountDeposits permits BalanceRecord {

    void deposit(int amount);
}
