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
EditText phonenumberr;
EditText passwordd;
Button login;
    String mobilePattern = "[5]{1}[0-9]{11}";
         String passwordPattern = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        phonenumberr = findViewById(R.id.editTextPhone);
        passwordd = findViewById(R.id.editTextTextPassword3);
        login = findViewById(R.id.Login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValidation();

            }
        });

    }

        private boolean setValidation(){
           String  phonenumber = phonenumberr.getText().toString();
            String password= passwordd.getText().toString();
//


            if (phonenumber.length() == 0) {
                phonenumberr.setError(getResources().getString(R.string.mobile_no_not_valid));
                return false;
            } else if (phonenumber.length() < 9) {
                phonenumberr.setError(getResources().getString(R.string.mobile_no_not_valid9));
                return false;
            } else if (phonenumber.charAt(0) != '5') {
                phonenumberr.setError(getResources().getString(R.string.mobilenosholdstartdigit5));
                return false;
            } else if (password.length() == 0) {
                passwordd.setError(getResources().getString(R.string.passwordshouldnotbeempty));
                return false;
            } else if (!password.matches(passwordPattern)) {
                passwordd.setError(getResources().getString(R.string.passwordshouldconatins));
                return false;
            } else if (password.length() < 8) {
                passwordd.setError(getResources().getString(R.string.mineightdigit));
                return false;
            } else {
                passwordd.setError(null);
                passwordd.setError(null);
                return false;
            }
        };

}

