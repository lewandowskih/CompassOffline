package com.example.hubert.compassoffline;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateView();
    }

    public void onRefreshButtonClick(View v){
        calculateView();
    }

    private void calculateView(){
        TextView tv = findViewById(R.id.textView);
        Calendar c = Calendar.getInstance();
        int hours = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);
        int seconds = c.get(Calendar.SECOND);
        int fullseconds = hours * 3600 + minutes * 60 + seconds;


        ImageView iv = findViewById(R.id.imageView2);
        iv.setRotation(180);
        double angle = (float) (fullseconds / 240.0);
        tv.setText(getString(R.string.TV_information, angle, hours, minutes, seconds));

        iv.setRotation((float)angle);
    }
}
