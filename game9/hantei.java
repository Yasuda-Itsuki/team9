import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hantei here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hantei extends Actor
{
    Goku goku = null;
    public hantei()
    {
        // 当たり判定の大きさを調整
        getImage().scale( 70,95 );
        // デバッグが終わったら 255 を 0 にして本体を透明にする
        getImage().setTransparency(0);
        
    }
    
    public void act() 
    {
        /*int currentX = getX(); // 現在のX座標を取得
        int currentY = getY(); // 現在のY座標を取得
        int down = 4;         // 下に移動する速度（ピクセル数）
        setLocation(currentX, currentY + down); 
        
        if (Greenfoot.isKeyDown("space")){
        int currentA = getX(); // 現在のX座標を取得
        int currentB = getY(); // 現在のY座標を取得
        int up = -8;         // 上に移動する速度（ピクセル数）
        setLocation(currentA, currentB + up);
        */
        int x = getX();
        int y = getY();
        if( Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-5 );
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setLocation( x,y+5 );
        }
        
        if(goku == null){
            goku = new Goku();
            goku.getImage().scale( 150, 150 );
            getWorld().addObject(goku,0,0);
        }
        goku.setLocation(getX()+3,getY()+15);
    }
}
