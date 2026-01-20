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

        move(-4);

        move(-6);


        int randomSpeed = Greenfoot.getRandomNumber(10);
        move(-randomSpeed);
        
<<<<<<< HEAD
  
          Actor actor = getOneIntersectingObject( Goku.class );
=======


        Actor actor = getOneIntersectingObject( hantei.class );
>>>>>>> cac716c305adbb7395504dab165e6db4b6012060
        if( actor != null ){
            Goku.isGameOver = true;
            getWorld().showText( "GAME OVER", 400, 200 );
            Greenfoot.stop();
          
           
        }
        
        Actor Super_actor = getOneIntersectingObject( hantei.class );
        if( Super_actor != null ){
            Goku.isGameOver = true;
            getWorld().showText( "GAME OVER", 400, 200 );
            Greenfoot.stop();
<<<<<<< HEAD
            
        }  
=======
        } 
>>>>>>> cac716c305adbb7395504dab165e6db4b6012060

        int x = getX();
        // x座標が0ならオブジェクトを削除
        if (x == 0) {
        getWorld().removeObject(this);
    }
    }  
}
