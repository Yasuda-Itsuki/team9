

import greenfoot.*;  // World, Actor, GreenfootImage, Greenfoot

public class SuperGoku extends Actor {

    // Act - 毎フレームの処理 //
    public void act() {
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