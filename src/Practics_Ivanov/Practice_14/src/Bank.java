import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Bank
{
    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    public Bank(){
        accounts = new HashMap<>();
    }
    public void addAcc(String name, Account account)
    {
        accounts.put(name,account);
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount){
        if(accounts.containsKey(fromAccountNum) && accounts.containsKey(toAccountNum)) {
            Account oneAcc = accounts.get(fromAccountNum);
            Account twoAcc = accounts.get(toAccountNum);
            System.out.println("_______________________________________________");
            System.out.println(fromAccountNum + ": " + oneAcc.getMoney());
            System.out.println(toAccountNum + ": " + twoAcc.getMoney());
            System.out.println( "Сумма перевода: " + amount);
            if (!oneAcc.isBlockAcc() && !twoAcc.isBlockAcc()) {
                if(amount > 50000){
                    try{
                        if(isFraud(fromAccountNum, toAccountNum, amount)){
                            System.out.println("Блокировка аккаунтов!!!");
                            System.out.println("Подозрительная операция!!!");
                            oneAcc.setBlockAcc(true);
                            twoAcc.setBlockAcc(true);
                        }
                        else {
                            if (oneAcc.getMoney() - amount >= 0) {
                                oneAcc.setMoney(oneAcc.getMoney() - amount);
                                twoAcc.setMoney(twoAcc.getMoney() + amount);
                                System.out.println("Перевод выполнен успешно!");
                                System.out.println(fromAccountNum + ": " + getBalance(fromAccountNum));
                                System.out.println(toAccountNum + ": " + getBalance(toAccountNum));
                                accounts.put(fromAccountNum, oneAcc);
                                accounts.put(toAccountNum, twoAcc);
                            } else {
                                System.out.println("Недостаточно средств");
                            }
                        }
                    }catch (InterruptedException ex){
                        System.out.println("Аккаунты заблокированы");
                    }
                }
                else{
                    if(oneAcc.getMoney() - amount >= 0){
                        oneAcc.setMoney(oneAcc.getMoney()-amount);
                        twoAcc.setMoney(twoAcc.getMoney()+amount);
                        System.out.println("Перевод выполнен успешно!");
                        System.out.println(fromAccountNum + ": " + getBalance(fromAccountNum));
                        System.out.println(toAccountNum + ": " + getBalance(toAccountNum));
                        accounts.put(fromAccountNum, oneAcc);
                        accounts.put(toAccountNum, twoAcc);
                    }
                    else{
                        System.out.println("Недостаточно средств");
                    }
                }
            } else {
                System.out.println("Один из аккаунтов заблокирован");
            }
            System.out.println("_______________________________________________");
            System.out.println();
        }
        else{
            System.out.println("Ошибка!!!");
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }
}
