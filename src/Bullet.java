/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bilal Ahmad
 */
public class Bullet extends Vehicle 
{
   public Bullet(String path,int x,int y)
  {
      super(path,x,y);

  }
   @Override
  public void move()
  {
      moveTo(x,y-15);
  }
   @Override
  public void Fire()
  {
      
  }
   
}
