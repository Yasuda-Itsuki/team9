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
        
<<<<<<< HEAD
        addObject( new Goku(), 400,200);
        spawnRyu(); // 右の外から出現
=======
<<<<<<< HEAD
        //Goku初期位置設定・追加
        addObject( new Goku(), 100,200);
=======
        addObject( new Goku(), 300,200);
>>>>>>> 47edecaf28235a485478a9931f38fc96d9c47791
>>>>>>> e80212fa6f056011bc3ec28ce08a62e349c14021
    }
        public void act() {
        
        // ランダムにOzyamaを追加（毎フレーム1/100の確率）
        if (Greenfoot.getRandomNumber(100) == 0) {
            addObject(new Ozyama(), 800, 440);
        }
        
        // ランダムにOzyama_upを追加（毎フレーム1/100の確率）
        if (Greenfoot.getRandomNumber(100) == 0) {
            addObject(new Ozyama_up(), 800, 0);
        }
        
        scorecount++;
        
        showText(""+scorecount, 700,15);
        
    }
    
        public void spawnRyu() {
        int randomY = Greenfoot.getRandomNumber(450);  // 0〜449 のランダムY
        Ryu ryu = new Ryu();
        addObject(ryu, getWidth() + 50, randomY);
    }
}
    
       
    
    
    

