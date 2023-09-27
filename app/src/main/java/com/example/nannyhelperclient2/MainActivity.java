package com.example.nannyhelperclient2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLoginButtonOnClick();

    }

    private void setLoginButtonOnClick() {
        MaterialButton loginButton = (MaterialButton) findViewById(R.id.loginbtn);
        loginButton.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        InputStream in = NetworkUtils.GetUrl(
                MainActivity.this,
                "http://172.20.10.7/",
                null
        );
        Utils.AlertMessage(MainActivity.this, "Data", in.toString());
        startActivity(new Intent(getApplicationContext(), NannyFirstActivity.class));

    }
}