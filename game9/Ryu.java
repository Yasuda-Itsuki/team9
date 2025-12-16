import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ryu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ryu extends Actor
{   
    public void act() 
    {
<<<<<<< HEAD
        move(-6);

        Actor actor = getOneIntersectingObject( hantei.class );
=======
        int randomSpeed = Greenfoot.getRandomNumber(10);
        move(-randomSpeed);
        
        
        Actor actor = getOneIntersectingObject( Goku.class );
>>>>>>> 6b0d2f57f18af6060be0416d343dcdc41836474b
        if( actor != null ){
            getWorld().showText( "GAME OVER", 400, 200 );
            Greenfoot.stop();
        }
        
        Actor Super_actor = getOneIntersectingObject( SuperGoku.class );
        if( Super_actor != null ){
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
