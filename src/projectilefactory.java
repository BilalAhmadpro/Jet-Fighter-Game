


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public  class projectilefactory extends AbstractFactory
{

    @Override
   public  Vehicle getVehicle(String name) {
         if(name.equalsIgnoreCase("Bullet"))
         {
             return new Bullet("src/Sprites/PlayerFire/",0,0);
         }
         else if (name.equalsIgnoreCase("Enemyfire"))
         {
              return new EnemyFire("src/Sprites/EnemyFire/",0,0);
         }
         else if(name.equalsIgnoreCase("explosion"))
         {
             return new Explosion("src/Sprites/Explosion/",0,0);
         }
         else{
              System.out.println("Nulllllllllllllllllllll");
             return null;
         }
    }
 
    
}
