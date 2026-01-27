import greenfoot.*;

public class ryu_hantei extends Actor
{
    private Ryu ryu;   // 追従する本体Ryu

    // ★ Ryuを受け取るコンストラクタ
    public ryu_hantei(Ryu r)
    {
        ryu = r;

        getImage().scale(40, 65);
        getImage().setTransparency(0); // 当たり判定だけなら透明
    }

    public void act() 
    {
        // Goku / SuperGoku に当たったらゲームオーバー
        if (isTouching(hantei.class)) {
            Goku.isGameOver = true;
            getWorld().showText("GAME OVER", 400, 200);
            getWorld().showText("PRESS R TO RESTART", 400, 250);
            Greenfoot.stop();
        }
        
        if (ryu == null || ryu.getWorld() == null) {
            getWorld().removeObject(this);
            return;
        }

        // ★ Ryu に追従
        setLocation(ryu.getX() + 3, ryu.getY() + 15);
    }
}
