package com.example.mynewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener  {

    private TextView banner, registerUser;
    private EditText editTextFullName, editTextEmail, editTextPassword,editTextAge;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registeruser);
        registerUser.setOnClickListener(this);

        editTextFullName = (EditText) findViewById(R.id.fullName);
        editTextAge = (EditText) findViewById(R.id.age);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

   
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.banner:
                    startActivity(new Intent(this,MainActivity.class));
                    break;
                case R.id.registeruser:
                    registerUser();
                    break;
            }
        

    }


        private void registerUser() {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String fullname = editTextFullName.getText().toString().trim();
            String age = editTextAge.getText().toString().trim();

            if(fullname.isEmpty()){
                editTextFullName.setError("full name is required!");
                editTextFullName.requestFocus();
                return;
            }

            if(age.isEmpty()){
                editTextAge.setError("Age is required! ");
                editTextAge.requestFocus();
                return;
            }

            if(email.isEmpty()){
                editTextEmail.setError("Email is required!");
                editTextEmail.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editTextEmail.setError("please provide valid e-mail!");
                editTextEmail.requestFocus();
                return;
            }

            if(password.isEmpty()){
                editTextPassword.setError("Password is required!");
                editTextPassword.requestFocus();
                return;

            }

            if(password.length() < 6){
                editTextPassword.setError("Min password length should be 6 characters");
                editTextPassword.requestFocus();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                User user = new User(fullname, age, email);

                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                if (task.isSuccessful()) {
                                                    Toast.makeText(RegisterUser.this, "User has been registered succesfully!", Toast.LENGTH_LONG).show();
                                                    progressBar.setVisibility(View.VISIBLE);

                                                } else {
                                                    Toast.makeText(RegisterUser.this, "failed to register ! Try Again", Toast.LENGTH_LONG).show();
                                                    progressBar.setVisibility(View.GONE);
                                                }
                                            }
                                        });
                            }else{
                                Toast.makeText(RegisterUser.this, "failed to register ! ", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);




                            }
                        }



});
    }
}