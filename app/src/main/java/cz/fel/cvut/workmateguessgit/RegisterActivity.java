package cz.fel.cvut.workmateguessgit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    public void onStart() {
        super.onStart();

        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void onClickRegister(View view) {

        EditText emailEditText = findViewById(R.id.emailEditText);

        String email = emailEditText.getText().toString();

        EditText passwordEditText = findViewById(R.id.passwordEditText);

        String password = passwordEditText.getText().toString();

        EditText passwordAgainEditText = findViewById(R.id.passwordAgainEditText);

        String passwordAgain = passwordAgainEditText.getText().toString();


        if(!password.equals(passwordAgain)) {

            Toast toast = Toast.makeText(RegisterActivity.this, "Zadaná hesla se neshodují", Toast.LENGTH_LONG);

            toast.show();

            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //FirebaseUser user = firebaseAuth.getCurrentUser();

                            Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);

                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("RegisterActivity", "Uživatelský účet se nepodařilo vytvořit", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
