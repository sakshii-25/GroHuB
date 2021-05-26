package com.example.grohub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText regName, regUsername, regEmail, regPhoneno, regPassword;
    Button regBtn, regtoLoginBtn;

    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;


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

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = regName.getText().toString();
                String username = regUsername.getText().toString();
                String email = regEmail.getText().toString();
                String phoneNo = regPhoneno.getText().toString();
                String password = regPassword.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    regName.setError("Name is required.");
                    return;
                }

                if (TextUtils.isEmpty(username)) {
                    regUsername.setError("UserName is required.");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    regEmail.setError("Email is required.");
                    return;
                }

                if (TextUtils.isEmpty(phoneNo)) {
                    regPhoneno.setError("Phone no. is required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    regPassword.setError("Password is required.");
                    return;
                }


                if (password.length() < 6) {
                    regPassword.setError("Password must be >= 6 characters.");
                    return;
                }


                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                UserHelperClass helperclass = new UserHelperClass(name,username,email,phoneNo,password);

                                FirebaseDatabase.getInstance().getReference("Users")

                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(helperclass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                    Toast.makeText(Registration.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Login.class));
                                    }
                                });
                                }
                                else {
                                    Toast.makeText(Registration.this,"Error!"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();


                                }


                            }
                        });
            }
        });

       /*  regtoLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, Homepage.class);
                startActivity(intent);


            }
        });*/
    }
}