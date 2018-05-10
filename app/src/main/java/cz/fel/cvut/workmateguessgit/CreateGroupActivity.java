package cz.fel.cvut.workmateguessgit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class CreateGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
    }

    public void onClickRegister(View view) {

        EditText emailEditText = findViewById(R.id.emailEditText);

        String email = emailEditText.getText().toString();

        EditText passwordEditText = findViewById(R.id.passwordEditText);

        String password = passwordEditText.getText().toString();

        EditText passwordAgainEditText = findViewById(R.id.passwordAgainEditText);

        String passwordAgain = passwordAgainEditText.getText().toString();


        /*if(!password.equals(passwordAgain)) {

            Toast toast = Toast.makeText(RegisterActivity.this, "Zadaná hesla se neshodují", Toast.LENGTH_LONG);

            toast.show();

            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("RegisterActivity", "createUserWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });*/
    }
}
