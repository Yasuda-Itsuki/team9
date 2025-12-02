import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goku here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goku extends Actor
{
    /**
     * Act - do whatever the Goku wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int currentX = getX(); // 現在のX座標を取得
        int currentY = getY(); // 現在のY座標を取得
        int down = 4;         // 下に移動する速度（ピクセル数）
        setLocation(currentX, currentY + down); 
        
        if (Greenfoot.isKeyDown("space")){
        int currentA = getX(); // 現在のX座標を取得
        int currentB = getY(); // 現在のY座標を取得
        int up = -8;         // 上に移動する速度（ピクセル数）
        setLocation(currentA, currentB + up);
        }
   
    }    


    
    

}
