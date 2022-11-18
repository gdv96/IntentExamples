package com.unisannio.gdevanno.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

    public void explicit(View v){
        Intent i = new Intent(this, SecondActivity.class);
        int param;
        try {
            param = Integer.parseInt(edit.getText().toString());
        }
        catch (NumberFormatException nfe){
            param = 0;
        }
        i.putExtra(getResources().getString(R.string.key), param);
        this.startActivity(i);
    }

    public void web(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://" + edit.getText().toString())):
        this.startActivity(intent);
    }


}