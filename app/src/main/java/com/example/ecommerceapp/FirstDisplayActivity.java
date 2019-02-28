package com.example.ecommerceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class FirstDisplayActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnJoinNow,btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_display);
        Init();
        btnJoinNow.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private void Init() {
        btnJoinNow=findViewById(R.id.btnJoinNow);
        btnSignIn=findViewById(R.id.btnSignIn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.btnJoinNow:
               Intent SignUp=new Intent(FirstDisplayActivity.this,RegisterActivity.class);
               startActivity(SignUp);
               finish();
            break;
            case R.id.btnSignIn:
                Intent SignIn=new Intent(FirstDisplayActivity.this,LoginActivity.class);
                startActivity(SignIn);
                finish();
                break;
        }
    }
}
