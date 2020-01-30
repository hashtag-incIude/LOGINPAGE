package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();

               Boolean chkemailpass=db.emailpassword(email,password);
               if (chkemailpass==true) {
                   Toast.makeText(getApplicationContext(), "SUCCESSFULLY LOGIN", Toast.LENGTH_SHORT).show();
                   Intent ak = new Intent(Login.this, second.class);
                   startActivity(ak);
               }
               else
                   Toast.makeText(getApplicationContext(), "WRONG EMAIL ID OUR PASSWORD", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
