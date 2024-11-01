package com.polije.proyektopupin.Register;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.polije.proyektopupin.Login.LoginActivity;
import com.polije.proyektopupin.R;

public class RegisterActivity extends AppCompatActivity {


    //Variables
    TextInputEditText txt_user, txt_email, txt_pass, txt_confirm;
    Button btn_regis, btngoogle;
    TextView signIn;
    String username, email, password, confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        if(getSupportActionBar() !=null){
            getSupportActionBar().hide();
        }

        //Hooks
        txt_user = findViewById(R.id.txt_username);
        txt_email = findViewById(R.id.txt_email);
        txt_pass = findViewById(R.id.txt_password);
        txt_confirm = findViewById(R.id.txt_confirmpass);
        btn_regis = findViewById(R.id.btn_register);
        btngoogle = findViewById(R.id.btn_google);
        signIn = findViewById(R.id.signup);

        //Aktivity ke login
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setMessage("Already Have an Account ?");

                //ketika tombol ya ditekan
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent( RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                        //menampilkan toast
                        Toast.makeText(RegisterActivity.this, "Come On, Make You Activity Now !", Toast.LENGTH_SHORT).show();
                    }
                });

                //ketika tombol tidak ditekan
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                //Menampilkan dialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameVal = txt_user.getText().toString();
                String emailVal = txt_email.getText().toString();
                String passwordVal = txt_pass.getText().toString();
                String confirmVal = txt_confirm.getText().toString();

                if (usernameVal.isEmpty() || emailVal.isEmpty() || passwordVal.isEmpty() || confirmVal.isEmpty()){
                    //show text if column empty
                    Toast.makeText(RegisterActivity.this, "Please Fill the Column First", Toast.LENGTH_SHORT).show();
                    
                } else {
                    
                    if(!emailVal.contains("@")){
                        //show text if email doesn't sign @
                        Toast.makeText(RegisterActivity.this, "Your Email Doesn't Have the @ Sign", Toast.LENGTH_SHORT).show();

                    } else if(!passwordVal.trim().equals(confirmVal.trim())) {
                        //show text if password and confirm password not same
                        Toast.makeText(RegisterActivity.this, "Password and Confirm Password Must Be the Same", Toast.LENGTH_SHORT).show();

                    } else {
                        //show text the account has been registered
                        Toast.makeText(RegisterActivity.this, "Your New Account Has Been Registered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}