package com.example.enclaveit.androidreviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by enclaveit on 15/12/2016.
 */

public class ExplicitIntent extends AppCompatActivity {
    EditText firstNum;
    EditText secondNum;
    Button add;
    int sum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        firstNum = (EditText) findViewById(R.id.edFirstNumBer);
        secondNum =  (EditText) findViewById(R.id.edSecondNumber);
        add = (Button) findViewById(R.id.btAddButton);

        add.setOnClickListener(new AddButtonClickHandler());
    }
    public class  AddButtonClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int num1 = Integer.parseInt(firstNum.getText().toString());
            int num2 = Integer.parseInt(secondNum.getText().toString());
            Intent explicitIntent = new Intent(ExplicitIntent.this, ResultIntent.class);
            explicitIntent.putExtra("SUM", num1+" + "+num2+" = "+(num1+num2));
            startActivity(explicitIntent);
        }
    }
}
