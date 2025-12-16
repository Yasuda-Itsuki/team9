import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootSound bgm = null;
    GreenfootImage back;
    GreenfootImage back_flop;
    int back_dx = -5; // スクロール速度(マイナスにすると左から右)
    int back_x = 0;
    int back_width;
    boolean flop = false;
    
    private int scorecount = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){    
        super(800, 450, 1); // 画像サイズをセットする
        bgm = new GreenfootSound( "china.mp3" );
        back = new GreenfootImage( "./images/bg_unkai_yama.jpg" );
        back_flop = new GreenfootImage( "./images/bg_unkai_yama_hanten.jpg" );
        back_width = back.getWidth();
        
        showText( "SCORE", 600, 15 );
        
  
        //Goku初期位置設定・追加
        addObject( new Goku(), 100,200);

    }

        public void act() {
        //背景の動きの追加
        back_x += back_dx;
        if( back_x > 0){
            back_x -= back_width;
            flop = !flop;
        }
        if( back_x < -back_width ){
            back_x += back_width;
            flop = !flop;
        }
        getBackground().drawImage( flop ? back_flop : back, back_x, 0 );
        getBackground().drawImage( flop ? back : back_flop, back_x+back_width, 0 );   
        
        
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
        
         if (scorecount > 0 && scorecount % 700 == 0) {
            spawnbanana();
        }
        scorecount++;
        
        
        showText(""+scorecount, 700,15);
        
        }
    
        public void spawnRyu() {
        int randomY = Greenfoot.getRandomNumber(450); 
        Ryu ryu = new Ryu();
        addObject(ryu, getWidth() + 50, randomY);
        }
        

             public void spawnbanana() {  
        banana Banana = new banana();
        addObject(Banana, getWidth() + 50, 200);
        }

         public void started(){
             bgm.playLoop();
         }
    
         public void stopped(){
             bgm.stop();
         }
}
    
       
    
    
    

