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

<<<<<<< HEAD
        
=======
      

        move(-6);
>>>>>>> ab4c4d6b111d287c64be6489b9e81f9c9679bd24


        int randomSpeed = Greenfoot.getRandomNumber(10);
        move(-randomSpeed);
        

  
<<<<<<< HEAD
          Actor actor = getOneIntersectingObject( Goku.class );
 
            if( actor != null ){
=======
          


        Actor actor = getOneIntersectingObject( hantei.class );

        if( actor != null ){
>>>>>>> ab4c4d6b111d287c64be6489b9e81f9c9679bd24
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
=======

            
        }  


>>>>>>> ab4c4d6b111d287c64be6489b9e81f9c9679bd24

            
           }  

           
           int x = getX();
        // x座標が0ならオブジェクトを削除
<<<<<<< HEAD
            if(x == 0) {
                getWorld().removeObject(this);
          }
          
        } 


        
   } 

=======
        if (x == 0) {
        getWorld().removeObject(this);
    }
}
    }  
>>>>>>> ab4c4d6b111d287c64be6489b9e81f9c9679bd24

