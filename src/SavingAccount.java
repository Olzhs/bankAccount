public class SavingAccount extends Account {
    public SavingAccount(int balance,String accountName){
        super(balance,accountName);
    }

    //Со сберегательного счета нельзя платить, только переводить и пополнять. Также сберегательный не может уходить в минус

    @Override
    public boolean transfer(Account account, int amount){
        if(balance < amount){
            System.out.println(" Недастачно средств для совершения перевода");
            return false;
        }
          if(!account.addMoney(amount)){
             System.out.println("Перевод " + accountName + " на "+ account + " не удался ");
             return false;
         }
         balance -= amount;
         account.balance += amount;
         System.out.println(" Совершен перевод с :" + accountName + " на " + account + " " + amount + " y.e ");
         return  true;
     }

     @Override
    public boolean addMoney(int money){
         System.out.println("Пополнение на сумму в " + money + " успешно совершен ");
         balance += money;
         return true;
     }

     @Override
    public boolean pay(int amount){
         System.out.println("Невозможно провести оплату сберегательным счетом");
         return false;
     }

}



