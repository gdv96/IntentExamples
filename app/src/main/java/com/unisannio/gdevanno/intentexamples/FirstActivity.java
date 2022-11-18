package com.unisannio.gdevanno.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    private EditText edit;
    private final int rCode = 1963;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edit = (EditText) findViewById(R.id.input);
    }
}