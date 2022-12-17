public class ChecingAccount extends Account {
    public ChecingAccount(int balance, String accauntName) {
        super(balance, accauntName);
    }

    //Расчетный может выполнять все три операции, но не может уходить в минус.

    @Override
    public boolean transfer(Account account, int amount) {
        if (balance < amount) {
            System.out.println("Недастаточно средств для совершения перевода!!! " + "Пожалуйста поплните свой счет...");
            return false;
        }

        if (!account.addMoney(amount)) {
             System.out.println("Перевод с: " + account + " на " + account + " не удался");
            return false;

        }

        balance -= amount;
        account.balance += amount;
        System.out.println("Перевод с: " + account + " на " + account + " " + amount + " y.e");
        return false;
    }

    @Override
    public boolean addMoney(int money){
        System.out.println("Пополнение на сумму в " + money + " успешно переведено!" );
        balance += money;
        return false;
    }

    @Override
    public boolean pay(int amount){
        if(balance >= amount){
            System.out.println("Оплата на сумму " + amount + " успешно переведена! ");
            balance -= amount;
            return true;
        }else {
            System.out.println("Недастаточно средств для оплаты!" + "Пожалуйста поплните свой счет...");
            return false;
        }
    }
}