package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
EditText phonenumber;
EditText password;
Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        phonenumber = findViewById(R.id.editTextPhone);
        password = findViewById(R.id.editTextTextPassword3);
        login = findViewById(R.id.Login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });

        private void SetValidation() {
            String mobilePattern = "[5]{1}[0-9]{11}";
           String passwordPattern = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$";
            phonenumber = phonenumber.getText().toString();
            password = password.getText().toString();

            if (phonenumber.length() == 0) {
                phonenumber.setError(getResources().getString(R.string.mobile_no_not_valid));
                proceedToLogin = false;
            } else if (phonenumber.length() < 9) {
                phonenumber.setError(getResources().getString(R.string.mobile_no_not_valid9));
                proceedToLogin = false;
            } else if (phonenumber.charAt(0) != '5') {
                phonenumber.setError(getResources().getString(R.string.mobilenosholdstartdigit5));
                proceedToLogin = false;
            } else if (password.length() == 0) {
                password.setError(getResources().getString(R.string.passwordshouldnotbeempty));
                proceedToLogin = false;
            } else if (!passwordd.matches(passwordPattern)) {
                password.setError(getResources().getString(R.string.passwordshouldconatins));
                proceedToLogin = false;
            } else if (passwordd.length() < 8) {
                password.setError(getResources().getString(R.string.mineightdigit));
                proceedToLogin = false;
            } else if (!checkBox.isChecked()) {
                Toast.makeText(this, getString(R.string.clickonterms), Toast.LENGTH_SHORT).show();
                proceedToLogin = false;
            } else {
                password.setError(null);
                password.setError(null);
                proceedToLogin = true;
            }
            if(proceedToLogin) {
                if (ConnectivityReceiver.isConnected(this)){
                    new RegistrationRequest().execute();
                }
                else {

                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                }
            }
            return proceedToLogin;

        }
        });
    }
}

