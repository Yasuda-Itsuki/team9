import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);  
        addObject( new Goku(), 400,200);
    }
        public void act() {
        
        // ランダムにOzyamaを追加（毎フレーム1/100の確率）
        if (Greenfoot.getRandomNumber(100) == 0) {
            addObject(new Ozyama(), 800, 440);
        }
        
        // ランダムにOzyamaを追加（毎フレーム1/100の確率）
        if (Greenfoot.getRandomNumber(100) == 0) {
            addObject(new Ozyama_up(), 800, 0);
        }

        
    }
}
