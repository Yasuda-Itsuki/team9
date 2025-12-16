import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class banana extends Actor
{
    /**
     * Act - do whatever the banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-6);

       int x = getX();
        // x座標が0ならオブジェクトを削除
        if (x == 0) {
        getWorld().removeObject(this);
    }

    }    
}
