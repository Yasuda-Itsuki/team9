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
    
    private long startTimeMillis;
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        if( Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-5 );
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setLocation( x,y+5 );
        }
        
         if (isTouching(banana.class)) {
            
            removeTouching(banana.class);
        }
        
            if (isTouching(Ozyama.class)) {
            
            removeTouching(Ozyama.class);
            Greenfoot.playSound( "bakuhatsu.wav" );
        
        }
        
             if (isTouching(Ozyama_up.class)) {
            
            removeTouching(Ozyama_up.class);
            Greenfoot.playSound( "bakuhatsu.wav" );
            
    }

}
}
