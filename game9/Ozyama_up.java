import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ozyama_up here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ozyama_up extends Actor
{
    public Ozyama_up(){
    GreenfootImage img = getImage();
    int scale = 60 + Greenfoot.getRandomNumber(70); // 60〜140%
    img.scale(img.getWidth() * scale / 100, img.getHeight() * scale / 100);
    setImage(img);
}
    /**
     * Act - do whatever the Ozyama_up wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isGameOver = false;
    
    
    public void act() 
    {
<<<<<<< HEAD
        move(-3);
      

   Actor actor = getOneIntersectingObject( Goku.class );
=======
     move(-3);
     Actor actor = getOneIntersectingObject( hantei.class );
>>>>>>> cac716c305adbb7395504dab165e6db4b6012060
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
