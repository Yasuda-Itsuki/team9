

import greenfoot.*;  // World, Actor, GreenfootImage, Greenfoot

public class SuperGoku extends Actor {

    // --- 無敵状態管理 ---
    private boolean invincible = false;
    private long invincibleEndMillis = 0L;

    // --- 表示画像 ---
    private GreenfootImage normalImg;
    private GreenfootImage invincibleImg;

    // --- 移動パラメータ ---
    private static final int GRAVITY_DOWN = 4;   // 毎フレーム落下
    private static final int JUMP_UP = -8;       // スペースで上昇

    // --- 無敵付与秒数（バナナ） ---
    private static final int BANANA_INVINCIBLE_SECONDS = 5;

    public SuperGoku() {
        // 画像の配置場所に応じてパスを調整してください
        // 通常はプロジェクトの images フォルダに置き、ファイル名のみで参照します
        normalImg     = new GreenfootImage("goku(kari).png");
        invincibleImg = new GreenfootImage("hantei.png");
        setImage(normalImg);
    }

    /** Act - 毎フレームの処理 */
    public void act() {
        // 1) 移動
        applyMovement();

        // 2) 無敵の時間更新（切れたら解除）
        updateInvincibleState();

        // 3) バナナ取得判定（1体のみ安全に処理）
        handleBananaPickup();

        // 4) 障害物との接触処理（無敵なら破壊、無敵でなければゲームオーバー）
        handleObstacleCollision();

        // 5) hantei との接触（無敵ならスルー、無敵でなければゲームオーバー）
        handleHanteiCollision();
    }

    // --- 移動処理 ---
    private void applyMovement() {
        int x = getX();
        int y = getY();

        // 毎フレーム落下（簡易重力）
        setLocation(x, y + GRAVITY_DOWN);

        // スペースで上昇
        if (Greenfoot.isKeyDown("space")) {
            setLocation(getX(), getY() + JUMP_UP);
        }

        // （任意）↑/↓キーで上下移動したい場合は下記を有効化してください
        /*
        if (Greenfoot.isKeyDown("up"))   setLocation(getX(), getY() - 5);
        if (Greenfoot.isKeyDown("down")) setLocation(getX(), getY() + 5);
        */
    }

    // --- バナナ取得で無敵 ---
    private void handleBananaPickup() {
        banana got = (banana) getOneIntersectingObject(banana.class);
        if (got != null) {
            // 無敵を付与（すでに無敵なら残り時間延長）
            setInvincibleForSeconds(BANANA_INVINCIBLE_SECONDS);

            // 取得音（任意：パスはプロジェクトに合わせて）
            Greenfoot.playSound("china.mp3");

            // バナナを消す
            World w = getWorld();
            if (w != null) {
                w.removeObject(got);
            }
            // 取得直後にゲームオーバー判定へ触れないよう早期 return も可能
            // return;
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

    /** 無敵状態の更新（時間切れなら解除） */
    private void updateInvincibleState() {
        if (invincible && System.currentTimeMillis() >= invincibleEndMillis) {
            invincible = false;
            setImage(normalImg); // 元に戻す（任意）
        }
    }

    /** 現在無敵かどうか（時間切れチェック込み） */
    private boolean isInvincible() {
        updateInvincibleState();
        return invincible;
    }

    // --- 障害物への衝突処理 ---
    private void handleObstacleCollision() {
        Actor hit = getOneIntersectingObject(Ozyama.class);
        if (hit == null) hit = getOneIntersectingObject(Ozyama_up.class);
        if (hit == null) hit = getOneIntersectingObject(Ryu.class);

        if (hit != null) {
            if (isInvincible()) {
                // 無敵中は障害物を破壊
                Greenfoot.playSound("bakuhatsu.wav");
                World w = getWorld();
                if (w != null) w.removeObject(hit);
            } else {
                // 無敵でない → ゲームオーバー
                gameOver();
            }
        }
    }

    // --- hantei（判定オブジェクト）との衝突 ---
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

    // --- ゲームオーバー処理 ---
    private void gameOver() {
        World w = getWorld();
        if (w != null) {
            w.showText("GAME OVER", w.getWidth() / 2, w.getHeight() / 2);
        }
        Greenfoot.playSound("bakuhatsu.wav"); // 任意のSE
        Greenfoot.stop();
    }
}

