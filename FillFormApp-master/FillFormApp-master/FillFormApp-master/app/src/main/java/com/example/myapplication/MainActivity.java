package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_firstname, edt_lastname, edt_birthday, edt_address, edt_email;
    RadioButton rb_male, rb_female;
    CheckBox checkBox;
    Button btn_regis;
    String firstname, lastname, birthday, address, email;
    String gender;
    Boolean checkAgree = false;
    Boolean checkDone;
    Boolean checkGender = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ClickListeners();

    }

    public void init(){
        edt_firstname = findViewById(R.id.edt_firstname);
        edt_lastname = findViewById(R.id.edt_lastname);
        edt_birthday = findViewById(R.id.edt_birthday);
        edt_address = findViewById(R.id.edt_address);
        edt_email = findViewById(R.id.edt_email);

        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);

        checkBox = findViewById(R.id.checkBox);
        btn_regis = findViewById(R.id.btn_regis);

    }

    public void ClickListeners(){
        rb_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = rb_male.getText().toString();
                checkGender = true;
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAgree = true;
            }
        });
        rb_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = rb_female.getText().toString();
                checkGender = true;
            }
        });

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstname = edt_firstname.getText().toString();
                lastname = edt_lastname.getText().toString();
                birthday = edt_birthday.getText().toString();
                address = edt_address.getText().toString();
                email = edt_email.getText().toString();
                checkDone = true;
                Log.d("First Name", firstname);
                Log.d("Last Name", lastname);
                Log.d("Birthday", birthday);
                Log.d("Address", address);
                Log.d("Email", email);
                if (firstname.equals("")){
                    checkDone = false;
                    changeColor(edt_firstname);
                    ShowToast("First Name Missing");

                }

                if (lastname.equals("")){
                    checkDone = false;
                    changeColor(edt_lastname);
                    ShowToast("Last Name Missing");
                }

                if (!checkGender){
                    checkDone = false;
                    ShowToast("Please choose your gender");
                }

                if (birthday.equals("")){
                    checkDone = false;
                    ShowToast("Birthday Missing");
                    changeColor(edt_birthday);
                }

                if (address.equals("")){
                    checkDone = false;
                    ShowToast("Address Missing");
                    changeColor(edt_address);
                }


                if (email.equals("")){
                    checkDone = false;
                    ShowToast("Email Missing");
                    changeColor(edt_email);
                    Log.d("Email", "Email mising");
                }


                if (!checkAgree){
                    checkDone = false;
                    ShowToast("Please agree with our terms");
                }


                if (checkDone) {
                    recallColor(edt_firstname);
                    recallColor(edt_lastname);
                    recallColor(edt_birthday);
                    recallColor(edt_address);
                    recallColor(edt_email);
                    ShowToast("Proceed...");
                }

            }
        });

    }

    public void ShowToast(String message){
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void changeColor (EditText edt){
        edt.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
    }

    public void recallColor(EditText edt){
        edt.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purple_700)));
    }





}