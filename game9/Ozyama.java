import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ozyama here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ozyama extends Actor
{
    
    public Ozyama() {
        GreenfootImage img = getImage();
        int scale = 100 + Greenfoot.getRandomNumber(101); // 50〜150%
        img.scale(img.getWidth() * scale / 100, img.getHeight() * scale / 100);
        setImage(img);
    }

    
    /**
     * Act - do whatever the Ozyama wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-3);
        int x = getX();
        // x座標が0ならオブジェクトを削除
        if (x == 0) {
        getWorld().removeObject(this);
    }

    }    
}
