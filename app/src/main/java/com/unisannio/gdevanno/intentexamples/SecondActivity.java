package com.unisannio.gdevanno.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent fromCaller = getIntent();
        int param = fromCaller.getIntExtra(getResources().getString(R.string.key),-1);
        if(param>-1){
            TextView tv = (TextView)findViewById(R.id.textView);
            tv.setText(String.valueOf(param));
        }
    }
}