/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bilal Ahmad
 */
public class Bomber extends Vehicle
{
   
   
     
     public Bomber (String path,int x,int y)
    {
     
       super(path,x,y);
       dx=3;
       dy=3;
      
     }
    @Override
    public void move()
   {
      moveTo(x,y+dy);
   }
    
    
    @Override
    public void Fire()
    {
      
    }
    
        
    

    
   
}
