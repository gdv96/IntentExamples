package com.unisannio.gdevanno.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Intent fromCaller = getIntent();
        String param = fromCaller.getStringExtra(getResources().getString(R.string.key));
        TextView tv = (TextView) findViewById(R.id.msg);
        tv.setText("Please evaluation" +String.valueOf(param));
        result = (EditText) findViewById(R.id.result);
    }

    public void done(View v){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(getResources().getString(R.string.resultKey), result.getText().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}