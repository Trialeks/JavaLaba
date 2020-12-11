public class Main {
    public static void main(String[] args)
    {
        Bank bank =new Bank();
        for(int i=0;i<100;i++) {
            Account acc = new Account((long) ((Math.random() * (40000)) + 30000), String.valueOf((int) (Math.random() * (19)) + 1));
            bank.addAcc(String.valueOf(i), acc);
        }
        for(int i = 0; i < 4; i++){
            BankRoom render = new BankRoom(bank);
            new Thread(render).start();
        }

    }
}
