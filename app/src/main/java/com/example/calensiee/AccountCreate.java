package com.example.calensiee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calensiee.View.MenuView;
import com.example.calensiee.View.WeekViewActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AccountCreate extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    private EditText textEmail;
    private EditText textPassword;

    DatabaseReference reference;
    FirebaseDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.account_create);

        // [END initialize_auth]
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            AccountUtil.user = mAuth.getCurrentUser();
                            updateUI(AccountUtil.user);

                            if(!AccountUtil.user.getUid().toString().isEmpty()){

                                UserUtil accountInfos = new UserUtil(AccountUtil.user.getUid().toString(),false);
                                db=FirebaseDatabase.getInstance();
                                reference = FirebaseDatabase.getInstance("https://calensiee-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("user");
                                Log.d(TAG, reference.toString());

                                reference.child(accountInfos.getUserId()).setValue(accountInfos).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(AccountCreate.this,"Successfuly created",Toast.LENGTH_SHORT).show();
                                        reference = FirebaseDatabase.getInstance("https://calensiee-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("user");
                                        reference.child(AccountUtil.user.getUid().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    if (task.getResult().exists()) {
                                                        Toast.makeText(AccountCreate.this, "Welcome", Toast.LENGTH_SHORT).show();
                                                        DataSnapshot dataSnapshot = task.getResult();
                                                        AccountUtil.isAdmin = Boolean.valueOf(String.valueOf(dataSnapshot.child("admin").getValue()));
                                                    } else {
                                                        Toast.makeText(AccountCreate.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            }
                                        });
                                        Intent intent = new Intent(AccountCreate.this, MenuView.class);
                                        startActivity(intent);
                                    }
                                });
                            }else {
                                // If sign in fails, display a message to the user.
                                Log.e(TAG, "createUserIndatabase :failure", task.getException());
                                Toast.makeText(AccountCreate.this, "Database failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(AccountCreate.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    public void creerCompte(View view){
        initWidgets();
        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();
        createAccount(email,password);
    }

    private void initWidgets()
    {

        textEmail = findViewById(R.id.editTextTextEmailAddress);
        textPassword = findViewById(R.id.editTextTextPassword);

    }
    private void reload() { }

    private void updateUI(FirebaseUser user) { }
}
/**
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser != null) {

                        String userId = currentUser.getUid();
                        DatabaseReference userMoviesRef = FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("movies");
                        Movie movie = getIntent().getParcelableExtra("movie");
                        userMoviesRef.child(String.valueOf(movie.getId())).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                                Log.d("Firebase", "onDataChange: dataSnapshot.exists() = " + dataSnapshot.exists());

                                if (!dataSnapshot.exists()) {
                                // Le film n'est pas encore enregistré, ajoutez-le à la base de données
                                userMoviesRef.child(String.valueOf(movie.getId())).setValue(movie);
                                Toast.makeText(FilmDetailsActivity.this, "Film enregistré avec succès", Toast.LENGTH_SHORT).show();
                                } else {
                                // Le film est déjà enregistré
                                Toast.makeText(FilmDetailsActivity.this, "Ce film est déjà enregistré", Toast.LENGTH_SHORT).show();
                        }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                                Log.e("Firebase", "Erreur lors de l'accès à la base de données : " + databaseError.getMessage());
                                }
                                });
                                } else {
                                Toast.makeText(FilmDetailsActivity.this, "Vous etes pas authentifie", Toast.LENGTH_SHORT).show();
                                }*/