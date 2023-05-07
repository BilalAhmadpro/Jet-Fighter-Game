


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bilal Ahmad
 */
public class planefactory extends AbstractFactory {
    
    
     @Override
     public Vehicle getVehicle(String name)
     {
         if(name.equalsIgnoreCase("Fighter"))
         {
             return new Fighter("src/Sprites/B-17/Type-1/Animation/",0,0);
         }
         
          if (name.equalsIgnoreCase("Bomber"))
         {
             return new Bomber("src/FighterSprite/FighterSprite/",0,0);
         }
          else{
              System.out.println("Nulllllllllllllllllllll");
              return null;
          }
     
     }

    
}
