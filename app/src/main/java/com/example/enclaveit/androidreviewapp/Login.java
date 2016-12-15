package com.example.enclaveit.androidreviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edName;
    EditText edPassWord;
    Button btLogin;

    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edName = (EditText) findViewById(R.id.edName);
        edPassWord = (EditText) findViewById(R.id.edPassWord);
        btLogin = (Button)findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edName.getText().toString().equals("admin") &&
                        edPassWord.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials" , Toast.LENGTH_LONG).show();

                    counter --;
                    if (counter == 0){
                        btLogin.setEnabled(false);
                    }
                }
            }
        });
    }
}
