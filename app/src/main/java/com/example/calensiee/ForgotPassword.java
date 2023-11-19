package com.example.calensiee;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;

public class ForgotPassword extends AppCompatActivity {

    private FirebaseAuth mAuth;
    // [END declare_auth]
    private EditText textEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.password_reset);
        // [END initialize_auth]
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }

    public void resetPassword(View view) {
        initWidgets();
        String email = textEmail.getText().toString();
        if (!TextUtils.isEmpty(email)) {
            mAuth.sendPasswordResetEmail(email)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(ForgotPassword.this, "Un email de réinitialisation a été envoyé à l'adresse mail indiquée", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ForgotPassword.this, EmailPasswordActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ForgotPassword.this, "Error :- " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }        else{
        textEmail.setError("Email field can't be empty");
        }
    }
    private void initWidgets()
    {
        textEmail = findViewById(R.id.editTextTextEmailAddress);
    }
    private void reload() { }
    private void updateUI(FirebaseUser user) { }
}
