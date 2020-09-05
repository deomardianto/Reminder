package com.project.gemastik.reminder.verify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.gemastik.reminder.MainActivity;
import com.project.gemastik.reminder.R;
import com.subhrajyoti.passwordview.PasswordView;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    PasswordView password;
    FloatingActionButton login;
    TextView signin;
    FirebaseAuth mAuth;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.maillogin);
        password = findViewById(R.id.pwlogin);
        mAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        signin = findViewById(R.id.btnsignin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser(){
        String txmail, txpass;

        txmail = email.getText().toString();
        txpass = password.getText().toString();

        if (TextUtils.isEmpty(txmail)){
            Toast.makeText(getApplicationContext(),"Email tidak boleh kosong!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(txpass)){
            Toast.makeText(getApplicationContext(),"Password tidak boleh kosong!",Toast.LENGTH_SHORT).show();
            return;
        }

        pd = new ProgressDialog(this);
        pd.setTitle("Proses Login");
        pd.setCancelable(false);

        pd.show();
        mAuth.signInWithEmailAndPassword(txmail, txpass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            pd.dismiss();
                            Toast.makeText(getApplicationContext(),"Login sukses!",Toast.LENGTH_SHORT).show();

                            Intent intens = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intens);
                            finish();
                        } else {
                            pd.dismiss();
                            Toast.makeText(getApplicationContext(),"Login gagal, silakan coba lagi",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
