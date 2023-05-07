/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Bilal Ahmad
 */
public class Explosion extends Vehicle 
{

	
	
	public Explosion(String path, int x, int y)
	{
                
                image =new Image[4];
		this.x = x;
		this.y = y;
		for(int i=1;i<5;i++)
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
                  
		  int num = (int)(getCount()%4);   
                 g.drawImage(image[num], x - image[num].getWidth(null)/2, y - image[num].getHeight(null)/2, null);
                g.setColor(new Color(255,0,0)); 
	      // g.drawRect(x-w/2, y-w/2, w, h);//Only to show image bounds, can be removed
                count++;
	}
	
	
	
	public  void move()
        {
            
        }
	public  void Fire()
        {
            
        }
	

}
