public class Main {
    public static void main(String[] args){
        Account account = new SavingAccount(100_00, " card onwers name");
        Account account1 = new CreditAccount(-100_00, " card onwers name");
        Account account2 = new ChecingAccount(100_00, " card onwers name");

        account.pay(10_000);
        account.transfer(account1, 10_000);
        account.addMoney(150_00);

        System.out.println("");

        account1.pay(15_000);
        account1.transfer(account2, 10_000);
        account1.addMoney(150_00);

        System.out.println("");

        account2.pay(15_000);
        account2.transfer(account, 50_000);
        account2.addMoney(35_000);

    }
}
