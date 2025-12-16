import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperGoku here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperGoku extends Actor
{
    /**
     * Act - do whatever the SuperGoku wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int currentX = getX(); // Gokuと同じ
        int currentY = getY(); // 
        int down = 4;         // 
        setLocation(currentX, currentY + down); 
        
        if (Greenfoot.isKeyDown("space")){
        int currentA = getX(); //
        int currentB = getY(); // 
        int up = -8;         // 
        setLocation(currentA, currentB + up);
        }
        
         if (isTouching(banana.class)) {
            
            removeTouching(banana.class);
        }
        
            if (isTouching(Ozyama.class)) {
            
            removeTouching(Ozyama.class);
        
        }
        
             if (isTouching(Ozyama_up.class)) {
            
            removeTouching(Ozyama_up.class);
            
    }
}
}
