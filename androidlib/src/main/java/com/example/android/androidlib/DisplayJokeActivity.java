package com.example.android.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {
    TextView txtVwDisplayJoke;
    public final static String JOKE = "joke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        txtVwDisplayJoke=findViewById(R.id.txtVwDisplayJoke);
        Intent intent=getIntent();
        txtVwDisplayJoke.setText(intent.getStringExtra(JOKE));
    }
}
