public abstract class Account {
    protected int balance;
    protected String accountName;

    public Account(int balance, String accountName){
        this.balance = balance;
        this.accountName = accountName;
    }

    public int getBalance(){
        return balance;
    }

    public abstract boolean pay(int amount);

    public abstract boolean transfer(Account account, int amount);

    public abstract boolean addMoney(int money);

    @Override
    public String toString(){
        return accountName;
    }
}
