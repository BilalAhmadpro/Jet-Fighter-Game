


import java.awt.event.KeyEvent;



public class Player extends Vehicle
{
     private Vehicle b1;
     private AbstractFactory abs;
     private  static Player p;
     
	private Player(String path, int x, int y)
	{
		super(path, x, y);
               
	}
        public static Player getInstance()
        {
            if(p==null)
            {
            p=new Player("src/Sprites/BF-109E/Type-1/Animation/", 0, 0);
           
            }
           return p;
        }
	
	
       
	
     @Override
	public void move()
	{
          
		this.x += getDx();
		this.y += getDy();
	}
	
	public void keyPressed(KeyEvent e) 
	{
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 5;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -5;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 5;
        }
        if (key == KeyEvent.VK_SPACE) {
            Fire();
        }
    }
     
	public void Fire()
	{
            abs=Factoryproducer.getfactory(false);
            b1=abs.getVehicle("Bullet");
            b1.moveTo(super.getX(), super.getY());
            Board.m.add(b1);
            
	}
       

    public void keyReleased(KeyEvent e) 
    {        
        int key = e.getKeyCode();
         
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    /**
     * @return the b1
     */
   

    /**
     * @param b1 the b1 to set
     */
   

    /**
     * @return the mm
     */
    
}
