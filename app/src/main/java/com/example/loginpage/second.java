package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class second extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1=findViewById(R.id.bot);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =getPackageManager().getLaunchIntentForPackage("io.kommunicate.app");
                startActivity(i);

            }
        });

        b2=findViewById(R.id.pedometer);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =getPackageManager().getLaunchIntentForPackage("de.j4velin.pedometer");
                startActivity(i);

            }
        });

    }
}
