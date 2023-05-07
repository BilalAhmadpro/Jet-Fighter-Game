/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Bilal Ahmad
 */
public class Fighter extends Vehicle 
{
     
    public Fighter(String path, int x, int y)
	{
		super(path, x, y);
                
	}
	
	public Fighter(String path, MyPoint p)
	{
		super(path, p);
	}
	
    @Override
	public void move()
      {
          
          
               moveTo(x,y+3);
          
        
      }
        public void Fire()
        {
        }
        
	

}
