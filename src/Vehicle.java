
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Vehicle 
{
	protected Image[] image;
	protected int x;
	protected int y;
	protected int w;
        protected int h;
        protected int dx;
        protected int dy;	
        protected long count = 0;
        public Vehicle()
        {
        }
	
	public Vehicle(String path, int x, int y)
	{
            
           image =new Image[3];
		this.x = x;
		this.y = y;
		for(int i=1;i<4;i++)
                {
		ImageIcon imageIcon = new ImageIcon(path+i+".png");
		image[i-1] = imageIcon.getImage();
                }
		w = image[0].getWidth(null);
                h = image[0].getHeight(null);
	}
	
	public Vehicle(String path, MyPoint p)
	{
            image =new Image[3];
		x = p.getX();
		y = p.getY();
                for(int i=1;i<4;i++)
                {
		ImageIcon imageIcon = new ImageIcon(path+i+".png");
		image[i-1] = imageIcon.getImage();
                }
		
		w = image[0].getWidth(null);
                h = image[0].getHeight(null);
	}
	
	public Rectangle getBounds()
        {
	    return new Rectangle(x-w/2, y-w/2, w, h);
	}
       
	
	
	
	public void paintComponent(Graphics2D g) 
	{
                  
		    int num = (int)(getCount()%3);   
          g.drawImage(image[num], x - image[num].getWidth(null)/2, y - image[num].getHeight(null)/2, null);
                g.setColor(new Color(255,0,0)); 
	       //g.drawRect(x-w/2, y-w/2, w, h);//Only to show image bounds, can be removed
             
               
              
		     count++;
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public abstract void move();
	public abstract void Fire();
	
	
	public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image[] getImage() {
        
        return image;
    }

    /**
     * @return the dx
     */
    public int getDx() {
        return dx;
    }

    
    public int getDy() {
        return dy;
    }

    /**
     * @return the count
     */
    public long getCount() {
        return count;
    }

   
  

    
	
	
}
