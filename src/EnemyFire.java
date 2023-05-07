/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author Bilal Ahmad
 */
public class EnemyFire extends Vehicle 
{
    private int cy;

    public void setCy(int cy) {
        this.cy = cy;
    }
    public EnemyFire(String path,int x,int y)
    {
        super(path,x,y);
        setCy(new Random().nextInt(2)+5);
    }
    public void Fire()
    {
        
    }
    public void move()
    {
        
        super.moveTo(this.x,this.getY()+cy);
    }
}
