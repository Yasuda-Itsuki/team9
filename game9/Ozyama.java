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
        int scale = 50+ Greenfoot.getRandomNumber(100); // 50〜150%
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

        Actor actor = getOneIntersectingObject( hantei.class );
    if( actor != null ){
    getWorld().showText( "GAME OVER", 400, 200 );
    Greenfoot.stop();
}  

       int x = getX();

        // x座標が0ならオブジェクトを削除
        if (x == 0) {
        getWorld().removeObject(this);
    }

    }    
}
