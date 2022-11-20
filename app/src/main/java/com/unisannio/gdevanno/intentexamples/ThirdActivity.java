package com.unisannio.gdevanno.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    public TextView tv;
    private int param = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activities);
        Intent fromCaller = getIntent();
        param = fromCaller.getIntExtra(getResources().getString(R.string.key), -1);
        if(param>-1){
            tv = (TextView) findViewById(R.id.textView);
            tv.setText(String.valueOf(param));
            final MyCounter timer = new MyCounter ((param+1)*1000,1000);
            timer.start();
        }

    }

    public class MyCounter extends CountDownTimer{
        public MyCounter(long millisInFuture, long countDownInterval){
            super(millisInFuture, countDownInterval);
        }
       @Override
        public void onFinish(){
            tv.setText("BOOM");
            tv.setTextSize(80);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            tv.setText(String.valueOf(param--));
        }
    }
}