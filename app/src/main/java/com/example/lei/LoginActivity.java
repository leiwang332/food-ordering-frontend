package com.example.lei;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lei.foodordering.R;
import com.example.lei.mockimpl.BackendMockFactory;

public class LoginActivity extends AppCompatActivity {

    //declare layout button,editText,progressbar
    private EditText etEmail,etPassword;
    private Button bLogin;
    private ProgressBar mprogressBar;
    private TextView registerLink;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberCheck;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        BackendMockFactory.setApplicationContext(getApplicationContext());

        //final ImageView iLogin = (ImageView) findViewById(R.id.iLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        mprogressBar = (ProgressBar) findViewById(R.id.progressBar) ;
        registerLink = (TextView) findViewById(R.id.tvRegisterhere);
        rememberCheck = (CheckBox) findViewById(R.id.rememberCheck);

        mprogressBar.setVisibility(View.GONE);

        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember){
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            etEmail.setText(account);
            etPassword.setText(password);
            rememberCheck.setChecked(true);
        }

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String account = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if (account.equals("lei12@gmail.com") && password.equals("123456")) {
                    editor = pref.edit();
                    if (rememberCheck.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    mprogressBar.setVisibility(View.VISIBLE);
                    Intent login = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(login);

                    //finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}


