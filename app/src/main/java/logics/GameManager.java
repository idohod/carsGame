package logics;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class GameManager {
    private int crash;
    private int life;

    public GameManager(int life) {
        this.crash = 0;
        this.life = life;
    }

    public int getCrash() {
        return crash;
    }

    public void setCrash(int crash) {
        this.crash = crash;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    public boolean isGameEnded(){
        return crash == life;
    }

    public void createToast(Context context) {
        Toast.makeText(context,"crash!",Toast.LENGTH_LONG).show();

    }

    public void createVibrator(Vibrator v){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }

    }


}
