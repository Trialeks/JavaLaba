
package pkg6laba;

import pkg6laba.Movable;

public class MovablePoints  implements Movable
{
    public int xv;
    public int yv;
    public int xn;
    public int yn;
    public int speedxn;
    public int speedxv;
    public int speedyn;
    public int speedyv;
    MovablePoints()
    {}
    MovablePoints(int xv,int yv,int xn,int yn, int speedxn,int speedxv,int speedyn,int speedyv)
    {
        this.xv=xv;
        this.yv=yv;
        this.xn=xn;
        this.yn=yn;
        this.speedxn=speedxn;
        this.speedyv=speedyv;
        this.speedxv=speedxv;
        this.speedyn=speedyn;
    }
    public void proverka()
    {
        if(speedxn!=speedxv&&speedyv!=speedyn)
        {
            System.out.println("Ошибка");
            System.exit(0);
        }
    }
     @Override
    public void moveLeft()
    {
       System.out.println("Новые координаты: ("+(xv-speedxv)+";"+yv+") ("+(xn-speedxn)+";"+yn+")");
    }
    @Override
     public void moveRight()
    {
       System.out.println("Новые координаты: ("+(xv+speedxv)+";"+yv+") ("+(xn+speedxn)+";"+yn+")");
    }
     @Override
     public void moveUp()
    {
       System.out.println("Новые координаты: ("+xv+";"+(yv-speedyv)+") ("+xn+";"+(yn-speedyn)+")");
    }
     @Override
      public void moveDown()
    {
       System.out.println("Новые координаты: ("+xv+";"+(yv+speedyv)+") ("+xn+";"+(yn+speedyn)+")");
    }
    
}
