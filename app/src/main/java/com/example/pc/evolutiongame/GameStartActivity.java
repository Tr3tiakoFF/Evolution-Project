package com.example.pc.evolutiongame;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.pc.evolutiongame.model.Room;
import com.example.pc.evolutiongame.wifidirect.discovery.R;

import static android.os.SystemClock.sleep;

@Deprecated
public class GameStartActivity extends Activity {

    private ImageView imageView;
    private int alpha = 100, red = 243, green = 0, blue = 23;
    private int colorMin = 0, colorMax = 255;
    private int colorChange = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);

        imageView = (ImageView) findViewById(R.id.container);

        render(null);
    }

    private void setNextColor() {
        switch (colorChange) {
            case 1: {
                if (blue == 0) {
                    setNextColorChangeState();
                } else {
                    blue--;
                }
            }
            case 2: {
                if (green == 255) {
                    setNextColorChangeState();
                } else {
                    green++;
                }
            }
            case 3: {
                if (red == 0) {
                    setNextColorChangeState();
                } else {
                    red--;
                }
            }
            case 4: {
                if (blue == 255) {
                    setNextColorChangeState();
                } else {
                    blue++;
                }
            }
            case 5: {
                if (green == 0) {
                    setNextColorChangeState();
                } else {
                    green--;
                }
            }
            case 6: {
                if (red == 255) {
                    setNextColorChangeState();
                } else {
                    red++;
                }
            }
        }
    }

    private void setNextColorChangeState() {
        if (colorChange == 1) {
            colorChange = 2;
        }
        if (colorChange == 2) {
            colorChange = 3;
        }
        if (colorChange == 3) {
            colorChange = 4;
        }
        if (colorChange == 4) {
            colorChange = 5;
        }
        if (colorChange == 5) {
            colorChange = 6;
        }
        if (colorChange == 6) {
            colorChange = 1;
        }
    }

    public void render(Room room) {
        setNextColor();
        imageView.setBackgroundColor(Color.argb(alpha, red, green, blue));
        sleep(100);
    }
}
