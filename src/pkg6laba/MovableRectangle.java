
package pkg6laba;

import pkg6laba.Rectangle;
import pkg6laba.Movable;

 class MovableRectangle extends Rectangle implements Movable
{
    public int x;
    public int y;
    public int speedx;
    public int speedy;
    MovableRectangle()
    {
    
    }
    MovableRectangle(int x,int y, int speedx,int speedy)
    {
    this.x=x;
    this.y=y;
    this.speedx=speedx;
    this.speedy=speedy;
    }
    @Override
    public void moveLeft()
    {
       System.out.println("Новая координата: ("+(x-speedx)+";"+y+")");
    }
    @Override
     public void moveRight()
    {
       System.out.println("Новая координата: ("+(x+speedx)+";"+y+")");
    }
     @Override
     public void moveUp()
    {
       System.out.println("Новая координата: ("+x+";"+(y-speedy)+")");
    }
     @Override
      public void moveDown()
    {
       System.out.println("Новая координата: ("+x+";"+(y+speedy)+")");
    }
}
