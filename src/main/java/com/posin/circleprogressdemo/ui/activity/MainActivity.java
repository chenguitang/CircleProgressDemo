package com.posin.circleprogressdemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.posin.circleprogressdemo.R;
import com.posin.circleprogressdemo.view.CircleProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CircleProgressBar cpbProgress = (CircleProgressBar) findViewById(R.id.cpb_progress);


        cpbProgress.setOnClickListener(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress<=100) {
                    progress +=2.2;
                    final int finalProgress = progress;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "finalProgress: "+finalProgress);
                            cpbProgress.setProgress(finalProgress);
                        }
                    });

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    @Override
    public void onClick(View v) {

    }
}
