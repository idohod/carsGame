package logics;

import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;

public class CoinManager {


    private ShapeableImageView[][] allCoins;

    public CoinManager() {}
    public ShapeableImageView[][] getAllCoins() {
        return allCoins;
    }

    public void setAllCoins(ShapeableImageView[][] allCoins) {
        this.allCoins = allCoins;
    }

    private int coin1PrePosition = 0;
    private int coin1CurPosition = 1;
    private int coin2PrePosition = 2;
    private int coin2CurPosition = 3;

    public int getCoin1PrePosition() {
        return coin1PrePosition;
    }

    public void setCoin1PrePosition(int coin1PrePosition) {
        this.coin1PrePosition = coin1PrePosition;
    }

    public int getCoin1CurPosition() {
        return coin1CurPosition;
    }

    public void setCoin1CurPosition(int coin1CurPosition) {
        this.coin1CurPosition = coin1CurPosition;
    }

    public int getCoin2PrePosition() {
        return coin2PrePosition;
    }

    public void setCoin2PrePosition(int coin2PrePosition) {
        this.coin2PrePosition = coin2PrePosition;
    }

    public int getCoin2CurPosition() {
        return coin2CurPosition;
    }

    public void setCoin2CurPosition(int coin2CurPosition) {
        this.coin2CurPosition = coin2CurPosition;
    }

    public void changeAllCoins() {
        changeCoin1Position();
        changeCoin2Position();
    }

    private void changeCoin1Position() {
        if (coin1PrePosition == allCoins.length) {
            coin1PrePosition = 0;

        }
        if (coin1CurPosition == allCoins.length) {
            coin1CurPosition = 0;
        }

        if (allCoins[coin1PrePosition][4].getVisibility() == View.VISIBLE) {
            allCoins[coin1PrePosition][4].setVisibility(View.INVISIBLE);
            allCoins[coin1CurPosition][4].setVisibility(View.VISIBLE);

            coin1PrePosition++;
            coin1CurPosition++;
        }
    }

    private void changeCoin2Position() {
        if (coin2PrePosition == allCoins.length) {

            coin2PrePosition = 0;
        }
        if (coin2CurPosition == allCoins.length) {
            coin2CurPosition = 0;

        }

        if (allCoins[coin2PrePosition][1].getVisibility() == View.VISIBLE) {
            allCoins[coin2PrePosition][1].setVisibility(View.INVISIBLE);
            allCoins[coin2CurPosition][1].setVisibility(View.VISIBLE);

            coin2PrePosition++;
            coin2CurPosition++;
        }
    }
}
