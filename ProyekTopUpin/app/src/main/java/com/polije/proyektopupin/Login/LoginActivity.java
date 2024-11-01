package com.polije.proyektopupin.Login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.polije.proyektopupin.Activitys.ProgramActivity;
import com.polije.proyektopupin.ForgotPassword.ForgotpassActivity;
import com.polije.proyektopupin.R;
import com.polije.proyektopupin.Register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {


    //Variables
    TextInputEditText txt_user, txt_pass;
    TextView forgotPass, signUp;
    Button btnlogin, btngoogle;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FIRST_SUB_WINDOW);
        setContentView(R.layout.activity_login);

        if(getSupportActionBar() !=null){
            getSupportActionBar().hide();
        }

        //Hooks
        txt_user = findViewById(R.id.txt_username);
        txt_pass = findViewById(R.id.txt_password);
        forgotPass = findViewById(R.id.forgotpass);
        signUp = findViewById(R.id.signup);
        btnlogin = findViewById(R.id.btn_login);
        btngoogle = findViewById(R.id.btn_google);

        //data dummy
        username = "fiqoo";
        password = "fiqo123";

        //aksi untuk menuju ke lupa password
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Forget Password ?");
                builder.setMessage("Do You Want to Reset Your Password ?");

                //ketika tombol ya ditekan
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent( LoginActivity.this, ForgotpassActivity.class);
                        startActivity(intent);
                        finish();
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

        //aksi menuju ke halaman register
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Don't Have an Account ?");

                //ketika tombol ya ditekan
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent( LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);
                        finish();

                        //menampilkan toast
                        Toast.makeText(LoginActivity.this, "Come On, Create Your Account Now !", Toast.LENGTH_SHORT).show();
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

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameVal = txt_user.getText().toString();
                String passwordVal = txt_pass.getText().toString();

                if(usernameVal.isEmpty() || passwordVal.isEmpty()){
                    //show text if username and password empty
                    Toast.makeText(LoginActivity.this, "Please Fill Your Username and Password First", Toast.LENGTH_SHORT).show();

                } else {
                    if(usernameVal.equals(username) && passwordVal.equals(password)){
                        //show text if username and password accepted
                        Toast.makeText(LoginActivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                        //to program activity after login
                        Intent intent = new Intent(LoginActivity.this, ProgramActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //show text if username ora password is wrong
                        Toast.makeText(LoginActivity.this, "Your Username or Password is Wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}