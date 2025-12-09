import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    
    private int scorecount = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){    
        
        super(800, 450, 1);
        showText( "SCORE", 600, 15 );
        

       

        //Goku初期位置設定・追加
        addObject( new Goku(), 100,200);
      
        
        
       




    }
        public void act() {
        
        
        // ランダムにOzyamaを追加（毎フレーム1/100の確率）
        if (Greenfoot.getRandomNumber(300) == 0) {
            addObject(new Ozyama(), 800, 440);
        }
        
        // ランダムにOzyama_upを追加（毎フレーム1/100の確率）
        if (Greenfoot.getRandomNumber(100) == 0) {
            addObject(new Ozyama_up(), 800, 0);
        } 
        
       
        
         if (scorecount > 0 && scorecount % 500 == 0) {
            spawnRyu();
        }
        scorecount++;
        
        
        showText(""+scorecount, 700,15);
        
    }
    
        public void spawnRyu() {
        int randomY = Greenfoot.getRandomNumber(450);  
        Ryu ryu = new Ryu();
        addObject(ryu, getWidth() + 50, randomY);
    }
}
    
       
    
    
    

