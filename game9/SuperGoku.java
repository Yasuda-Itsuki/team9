
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SuperGoku extends Actor {

    // 無敵状態管理
    private boolean invincible = false;
    private long invincibleEndMillis = 0L;

    // 表示用（任意）：通常と無敵時で画像を切替したい場合
    private GreenfootImage normalImg;
    private GreenfootImage invincibleImg;

    // 移動パラメータ
    private static final int GRAVITY_DOWN = 4;   // 毎フレーム落下
    private static final int JUMP_UP = -8;       // スペースで上昇

    // 無敵付与秒数（バナナで付与）
    private static final int BANANA_INVINCIBLE_SECONDS = 5;

    public SuperGoku() {
        // 画像準備（存在するパスに合わせてください）
        normalImg = new GreenfootImage("images/goku(kari).png");
        invincibleImg = new GreenfootImage("images/hantei.png"); // 無敵時の見た目に相応の画像があれば
        setImage(normalImg);
    }

    public void act() {
        // 1) 移動
        applyMovement();

        // 2) 無敵の時間更新（切れたら解除）
        updateInvincibleState();

        // 3) バナナ取得判定（1体のみ安全に処理）
        banana got = (banana) getOneIntersectingObject(banana.class);
        if (got != null) {
            // 無敵を付与（連続取得なら残り時間延長）
            setInvincibleForSeconds(BANANA_INVINCIBLE_SECONDS);

            // 取得音（任意）
            Greenfoot.playSound("sounds/china.mp3");

            // バナナを消す
            World w = getWorld();
            if (w != null) {
                w.removeObject(got);
            }

            // 取得直後にゲームオーバー判定に当たらないよう、ここで早期 return も可
            // return;
        }

        // 4) 障害物との接触処理
        handleObstacleCollision();

        // 5) （必要なら）判定用オブジェクト hantei との接触時も無敵考慮
        handleHanteiCollision();
    }

    private void applyMovement() {
        int x = getX();
        int y = getY();

        // 重力相当の落下
        setLocation(x, y + GRAVITY_DOWN);

        // スペースで上昇
        if (Greenfoot.isKeyDown("space")) {
            setLocation(getX(), getY() + JUMP_UP);
        }
    }

    /** 無敵を seconds 秒付与（すでに無敵なら延長） */
    private void setInvincibleForSeconds(int seconds) {
        long now = System.currentTimeMillis();
        if (invincible) {
            invincibleEndMillis += seconds * 1000L; // 延長
        } else {
            invincible = true;
            invincibleEndMillis = now + seconds * 1000L;
            setImage(invincibleImg); // 見た目切替（任意）
        }
    }

    /** 現在無敵かどうか（時間切れチェック込み） */
    private boolean isInvincible() {
        updateInvincibleState();
        return invincible;
    }

    /** 無敵状態の更新（時間切れなら解除） */
    private void updateInvincibleState() {
        if (invincible && System.currentTimeMillis() >= invincibleEndMillis) {
            invincible = false;
            setImage(normalImg); // 戻す（任意）
        }
    }

    /** 障害物への衝突処理：無敵なら障害物を消す、そうでなければゲームオーバー */
    private void handleObstacleCollision() {
        Actor hit = getOneIntersectingObject(Ozyama.class);
        if (hit == null) {
            hit = getOneIntersectingObject(Ozyama_up.class);
        }
        if (hit == null) {
            hit = getOneIntersectingObject(Ryu.class);
        }

        if (hit != null) {
            if (isInvincible()) {
                // 爆発音＆障害物排除
                Greenfoot.playSound("sounds/bakuhatsu.wav");
                World w = getWorld();
                if (w != null) {
                    w.removeObject(hit);
                }
            } else {
                // 無敵でない → ゲームオーバー
                gameOver();
            }
        }
    }

    /** hantei（判定）と接触したら：無敵なら無視、無敵でなければゲームオーバー */
    private void handleHanteiCollision() {
        hantei h = (hantei) getOneIntersectingObject(hantei.class);
        if (h != null) {
            if (isInvincible()) {
                // 無敵中はスルー
                return;
            } else {
                gameOver();
            }
        }
    }

    /** ゲームオーバー処理（必要に応じて世界を止めたり、リセットしたり） */
    private void gameOver() {
        // 演出やBGM停止、テキスト表示など
        World w = getWorld();
        if (w != null) {
            w.showText("GAME OVER", w.getWidth() / 2, w.getHeight() / 2);
        }
        Greenfoot.playSound("sounds/bakuhatsu.wav"); // 好みで変更
        Greenfoot.stop();
    }
}


