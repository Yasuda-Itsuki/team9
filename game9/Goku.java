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
        
         if (isTouching(banana.class)) {
            // 触れているbananaを削除
            removeTouching(banana.class);

            // 現在位置を取得
            World world = getWorld();
            int x = getX();
            int y = getY();

            // 変身先のオブジェクトを生成（例：SuperGoku）
            SuperGoku superGoku = new SuperGoku();

            // 同じ場所に追加
            world.addObject(superGoku, x, y);

            // 自分（Goku）を削除
            world.removeObject(this);
        }
   
    }    


    
    

}
