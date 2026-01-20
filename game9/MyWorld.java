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
    
    
    public Actor titlelogo = null;
     
    private int scorecount = 0;
    private static int highScore = 0; 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){    
        super(800, 450, 1); // 画像サイズをセットする
        bgm = new GreenfootSound( "china.mp3" );
        
        titlelogo = new TitleLogo();
        addObject(titlelogo,400,200);

        back = new GreenfootImage("bg_unkai_yama.jpg");
        back_flop = new GreenfootImage("bg_unkai_yama_hanten.jpg");
        back_width = back.getWidth();

        
        showText( "SCORE", 600, 15 );

        
        

        showText( "  ↑　上昇", 60, 15 );
        showText( "  ↓　下降", 60, 45 );


    

        addObject( new hantei(), 100, 200 );
        setActOrder(Goku.class, hantei.class);



  
        //Goku初期位置設定・追加
        //addObject( new Goku(), 100,200);


    }
    public void act() {
        
       
        if(titlelogo != null){
            removeObject(titlelogo);
            titlelogo = null;
        }    
            
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
        
        if (back == null || back_flop == null) return;

        getBackground().drawImage( flop ? back_flop : back, back_x, 0 );
        getBackground().drawImage( flop ? back : back_flop, back_x+back_width, 0 );   
        
        
        // ランダムにOzyamaを追加（毎フレーム1/100の確率）
        if (Greenfoot.getRandomNumber(180) == 0) {
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
        

        
        if (scorecount > highScore) {
            highScore = scorecount;
        }


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
    
       
    
    
    

