public class Account
{
    private long money;
    private String accNumber;
    private boolean blockAcc = false;
    public Account(long money,String accNumber)
    {
        this.accNumber=accNumber;
        this.money=money;
    }

    public void setMoney(long money)
    {
        this.money=money;
    }

    public synchronized long getMoney() {
        return money;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setBlockAcc(boolean blockAcc) {
        this.blockAcc = blockAcc;
    }

    public boolean isBlockAcc() {
        return blockAcc;
    }
}
