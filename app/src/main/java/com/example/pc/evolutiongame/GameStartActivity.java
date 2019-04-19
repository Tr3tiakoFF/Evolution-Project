package com.example.pc.evolutiongame;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.example.pc.evolutiongame.core.UiRenderer;
import com.example.pc.evolutiongame.model.Room;

import static android.os.SystemClock.sleep;

public class GameStartActivity extends Activity implements UiRenderer {

    private LinearLayout linearLayout;
    private int alpha = 100, red = 243, green = 0, blue = 23;
    private int colorMin = 0, colorMax = 255;
    private int colorChange = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity);

        linearLayout = (LinearLayout) findViewById(R.id.container);

        new Thread(new Runnable() {
            @Override
            public void run() {
                setNextColor();
                sleep(100);
                render(null);
            }
        }).start();
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

    @Override
    public void render(Room room) {
        linearLayout.setBackgroundColor(Color.argb(alpha, red, green, blue));
    }
}
