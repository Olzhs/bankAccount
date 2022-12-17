import jdk.swing.interop.SwingInterOpUtils;

import java.util.OptionalInt;

public class CreditAccount extends Account{
    public CreditAccount(int balance, String accountName){
        super(balance,accountName);
    }

    //Кредитный не может иметь положительный баланс – если платить с него, то уходит в минус, чтобы вернуть в 0, надо пополнить его.

    @Override
    public boolean transfer(Account account, int amount){
        if(balance < amount){
            System.out.println("Недасточно средств для совершения перевода" + " Если вы хотите совершить перевод для начало вам нужно поплнить счет на нужную сумму! ");
            return false;
        }
        if(!account.addMoney(amount)){
            System.out.println("Перевод " + accountName + " на "+ account + " не удался ");
            return false;
        }
        balance -= amount;
        account.balance += amount;
        System.out.println("Совершен перевод с :" + accountName + " на " + account + " " + amount + " y.e");
        return  true;
    }

    @Override
    public boolean addMoney(int money){
        if (money >= Math.abs(getBalance())){
            balance = Math.abs(balance);
            System.out.println("Кредит погашен");
            return true;
        }else{
            balance += money;
            System.out.println("Пополнение на сумму в " + money + " успешно переведено!");
            return false;
        }
    }

    @Override
    public boolean pay(int ammount){
        balance -= ammount;
        System.out.println("Оплата " + ammount + " успешно проведена! ");
        return true;
    }
}
