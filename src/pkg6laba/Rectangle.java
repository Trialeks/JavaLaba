
package pkg6laba;


import pkg6laba.MovablePoints;

public abstract class Rectangle
{
     public int a;
     public int b;
      Rectangle()
    {   
    }
    
    Rectangle(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    
    public int getA()
    {
        return a;
    }
    public int getB()
    {
        return b;
    }
    public void setA(int r)
    {
        this.a=r;
    }
    public void setB(int f)
    {
        this.b=f;
    }
    
     public int P=(a+b)*2;
     public int S=a*b;
       
       public void vse()
    {
       System.out.println("Периметр рямоугольника P="+P); 
       System.out.println("Площадь прямоугольника S="+S);
    }
       public static void main(String[] args) 
    {
        MovableRectangle rectangle=new MovableRectangle(2,3,4,5);
        rectangle.moveRight();
        rectangle.moveDown();
        MovablePoints rec=new MovablePoints(2,3,4,5,6,6,7,7);
        rec.proverka();
        rec.moveDown();
        MovablePoints rect=new MovablePoints(2,3,4,5,6,7,8,9);
        rect.proverka();
        rect.moveDown();
         
    }
}
