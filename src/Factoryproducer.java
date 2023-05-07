/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bilal Ahmad
 */
public abstract class Factoryproducer {
    public static AbstractFactory getfactory(boolean a)
    {
        if(a)
        {
                return  new planefactory();
        }
        else if(!a)
        {
            return new projectilefactory();
        }
        else{
             System.out.println("Nulllllllllllllllllllll");
            return null;
        }
    }
}
