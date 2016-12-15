package com.example.enclaveit.androidreviewapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by enclaveit on 15/12/2016.
 */

public class ResultIntent extends Activity {
    TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
         setContentView(R.layout.result);
         result =(TextView) findViewById(R.id.textResult);
         Intent intent = getIntent();
         String sum = (String) intent.getSerializableExtra("SUM");
         result.setText(sum);
    }
}
