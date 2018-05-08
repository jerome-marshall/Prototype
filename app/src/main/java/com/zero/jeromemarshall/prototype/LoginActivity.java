package com.zero.jeromemarshall.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton loginButton = (ImageButton) findViewById(R.id.imageButton3);
        loginButton.setOnClickListener(this);
        ImageButton signupButton = (ImageButton) findViewById(R.id.imageButton5);
        signupButton.setOnClickListener(this);
        TextView forgotPassword = (TextView) findViewById(R.id.textView4);
        forgotPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton5: {
                Intent signupintent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signupintent);
                break;
            }
            case R.id.imageButton3: {
                Intent loginintent = new Intent(this, HomepageActivity.class);
                startActivity(loginintent);
                break;
            }
            case R.id.textView4: {
                Intent forgotintent = new Intent(this, ForgotPasswordActivity.class);
                startActivity(forgotintent);
                break;
            }
        }

    }
}
