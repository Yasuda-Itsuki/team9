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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
<<<<<<< HEAD
        super(600, 400, 1); 
       
=======
<<<<<<< HEAD
        super(800, 450, 1);
        showText( "SCORE", 600, 15 );
=======
        super(800, 450, 1);  
        addObject( new Goku(), 400,200);
>>>>>>> afe5ed6b2a958776aff5a1b0e90c5aa69e87b393
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
        
>>>>>>> b95dfbc311a888923a4ebc0ae5f10f0393a732b3
    }
    
}
