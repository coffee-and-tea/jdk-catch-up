package coffee_and_tea.jdk15.jep384_records_second_preview;


public record BalanceRecord(int balance) implements AccountDeposits {

    @Override
    public void deposit(int amount) {
        // can't do anything since balance is final, just a record
    }

    public static void main(String[] args) {
        BalanceRecord record1 = new BalanceRecord(10);
        BalanceRecord record2 = new BalanceRecord(10);

        System.out.println(record1 == record2);
        System.out.println(record1.equals(record2));

        System.out.println(record1.getClass().isRecord());
    }
}
