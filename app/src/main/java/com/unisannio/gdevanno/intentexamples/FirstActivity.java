package com.unisannio.gdevanno.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.SearchManager;
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
        intent.setData(Uri.parse("http://" + edit.getText().toString()));
        this.startActivity(intent);
    }

    public void search(View v){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, edit.getText().toString());
        this.startActivity(intent);
    }

    public void tellCall(View v){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel" + edit.getText().toString()));
        this.startActivity(intent);
    }

    public void custom(View v){
        String myAction = getResources().getString(R.string.my_custom_action);
        int param;

        try {
            param = Integer.parseInt(edit.getText().toString());
        }
        catch(NumberFormatException nfe){
            param = 5;
        }
        Intent intent = new Intent(myAction);
        intent.putExtra(getResources().getString(R.string.key), param);
        this.startActivity(intent);
    }

    public void callForRes(View v){
        Intent intent = new Intent(this, FourthActivity.class);
        intent.putExtra(getResources().getString(R.string.key), edit.getText().toString());
        this.startActivityForResult(intent, rCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == rCode) {
            if(resultCode == Activity.RESULT_OK){
                edit.setText(edit.getText().toString()+" is "+data.getStringExtra(getResources().getString(R.string.resultKey)));
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}