import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ryu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ryu extends Actor
{   
    private boolean isGameOver = false;
    
      public void act() 
     {



         int randomSpeed = Greenfoot.getRandomNumber(10);
         move(-randomSpeed);
        
            int x = getX();
        // x座標が0ならオブジェクトを削除

            if(x == 0) {
                getWorld().removeObject(this);
          

            
            }  

           
      }
          
   } 


        
  


      