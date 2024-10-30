package com.polije.proyektopupin.Register;

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
import com.polije.proyektopupin.Login.LoginActivity;
import com.polije.proyektopupin.R;

public class RegisterActivity extends AppCompatActivity {


    //Variables
    TextInputEditText txt_user, txt_email, txt_pass, txt_confirm;
    Button btn_regis, btngoogle;
    TextView signIn;

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

    }
}