package com.example.ball;
import android.animation.ObjectAnimator;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView ball;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = findViewById(R.id.ball);
        container = findViewById(R.id.container);

        animateBall();
    }
    private void animateBall() {
        // Rotate the ball
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(ball, View.ROTATION, 0f, 360f);
        rotateAnimator.setDuration(60000); // 1 minute
        rotateAnimator.setInterpolator(new LinearInterpolator());
        rotateAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        rotateAnimator.start();

        // Change size and color after 1 minute
        container.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeBallSizeAndColor();
            }
        }, 60000);
    }

    private void changeBallSizeAndColor() {
        // Change size
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ball.getLayoutParams();
        layoutParams.width = layoutParams.height = convertDpToPixel(240); // radius 6
        ball.setLayoutParams(layoutParams);

        // Change color
        GradientDrawable drawable = (GradientDrawable) ball.getDrawable();
        drawable.setColor(getResources().getColor(android.R.color.holo_green_dark));

        // Restart animation
        animateBall();
    }

    private int convertDpToPixel(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
