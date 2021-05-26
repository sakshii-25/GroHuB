package com.example.grohub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    TextInputLayout regName,regUsername,regEmail,regPhoneno,regPassword;
    Button regBtn,regtoLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_registration);

        regName = findViewById(R.id.regName);
        regUsername = findViewById(R.id.regUsername);
        regEmail = findViewById(R.id.regEmail);
        regPhoneno = findViewById(R.id.regPhoneno);
        regPassword = findViewById(R.id.regPassword);
        regBtn = findViewById(R.id.regBtn);
        regtoLoginBtn = findViewById(R.id.regtoLoginBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email  = regEmail.getEditText().getText().toString();
                String phoneNo = regPhoneno.getEditText().getText().toString();
                String password= regPassword.getEditText().getText().toString();
  
                UserHelperClass helperClass = new UserHelperClass(name,username,email,phoneNo,password);

                reference.child(phoneNo).setValue(helperClass);
            }
        });

       regtoLoginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Intent intent = new Intent(Registration.this,Homepage.class);
               startActivity(intent);


           }
       });

    }
}