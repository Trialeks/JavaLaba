
public class BankRoom implements Runnable {
    private Bank bank;
    public BankRoom(Bank bank){
        this.bank = bank;
    }

    public void run() {
        for(int i = 0; i < 10; i++){
            bank.transfer(String.valueOf((int)(Math.random()*99)), String.valueOf((int)(Math.random()*99)), (long)((Math.random()*(40000))+30000));
        }

    }


}
